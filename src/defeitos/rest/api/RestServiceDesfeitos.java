package defeitos.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import defeitos.db.DAO.DefeitoDAO; 

@Path("/RestServiceDesfeitos") 
public class RestServiceDesfeitos {

	private DefeitoDAO dao = new DefeitoDAO();

	@GET
	@Path("/defeitos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDefeitos() {
		//			return dao.getDefeitos();
		return Response.ok() //200
				.entity(dao.getDefeitos())
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	
	@POST
	@Path("/setText")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response setText(String texto) {
		return Response.ok() //200
				.entity(dao.salveTexto(texto))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getText")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setGet() {
		return Response.ok() //200
		.entity(dao.getTexto())
		.header("Access-Control-Allow-Origin", "*")
		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
		.allow("OPTIONS").build();
	}
	
}
