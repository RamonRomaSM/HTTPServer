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
				System.out.println("ESTO ES LO QUE HAY "+client.toString());
				login(client.soc);
			}
		});
		server.initialize();
		
	}
	static void login(Socket clienteact) throws IOException {
		

		File arc=new File("src\\login.html");
		
		FileInputStream fis=new FileInputStream(arc);
		
		OutputStream os=clienteact.getOutputStream();
		
		
		os.write(("HTTP/1.1 200 OK\r\n").getBytes()); 
		os.write(("\r\n").getBytes());	
										
		os.write(fis.readAllBytes());
		os.flush();
	
		
	}
}
