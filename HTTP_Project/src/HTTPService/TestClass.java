package HTTPService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TestClass {
	public static void main(String[] args) {
		ServerHTTP server=new ServerHTTP();
		server.addRequest("/", new Response() {
			
			@Override
			public void execute(Client client) throws NotHandledRequestException, IOException {
				System.out.println("SE LE DA EL LOGIN ");
				login(client);
			}
		});
		server.initialize();
		
	}
	static void login(Client clienteact) throws IOException {
		

		File arc=new File("C:\\Users\\win10\\Documents\\GitHub\\HTTPServer\\HTTP_Project\\src\\login.html");
		
		FileInputStream fis=new FileInputStream(arc);
		
		clienteact.send(fis.readAllBytes());
	
		
	}
}
