package defeitos.db.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilesUtil {

	private static String path = "./src/textoFile/texto.txt";
	
	public Boolean geraArquivo(String conteudo) {
		
		if (!checkFileExist(path)) {
			searchDirectory(new File("../"), "texto.txt");
		}
		
		try {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
			buffWrite.append(conteudo);
			buffWrite.close();  
			System.out.println("Arquivo criado com sucesso!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
}

	public static String readFile() {
		

		if (!checkFileExist(path)) {
			searchDirectory(new File("../"), "texto.txt");
		}

		try {
			FileReader gravador = new FileReader(path);
			BufferedReader entrada = new BufferedReader(gravador);
			String texto = "";

			String linha;
			while ((linha = entrada.readLine()) != null) {
				texto = texto +" "+(linha) ;
			}
//			System.out.println("information found!");
			entrada.close();
			return texto;
		} catch (IOException e) {
			System.out.println("information not found!");
			return null;
		}

	}

	private static boolean checkFileExist(String path) {
		File file = new File(path);
		return file.exists();
	}
	
	private static void searchDirectory(File directory, String fileNameToSearch) {


		if (directory.isDirectory()) {
		    search(directory, fileNameToSearch);
		} else {
		    System.out.println(directory.getAbsoluteFile() + " is not a directory!");
		}

	  }
	
	private static List<String> search(File file, String filename) {

		if (file.isDirectory()) {
//		  System.out.println("Searching directory ... " + file.getAbsoluteFile());
		  List<String> result = new ArrayList<String>();
			
		    if (file.canRead()) {
			for (File temp : file.listFiles()) {
			    if (temp.isDirectory()) {
				search(temp, filename);
			    } else {
				if (filename.equals(temp.getName())) {			
				    result.add(temp.getAbsoluteFile().toString());
				    path = temp.getAbsoluteFile().toString();
				    return result;
			    }

			}
		    }

		 } else {
			System.out.println(file.getAbsoluteFile() + "Permission Denied");
		 }
		}
		return null;
	}

}
