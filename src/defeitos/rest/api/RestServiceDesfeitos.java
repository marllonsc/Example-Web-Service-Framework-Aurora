package defeitos.rest.api;

import java.sql.SQLException;
import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 

@Path("/RestServiceDesfeitos") 
public class RestServiceDesfeitos {

	private DefeitoDAO dao = new DefeitoDAO();

	@GET
	@Path("/defeitos")
	@Produces(MediaType.APPLICATION_XML)
	public List<Defeito> getDefeitos() {
		try {
			return dao.getDefeitos();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
