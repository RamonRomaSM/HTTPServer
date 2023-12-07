package HTTPService;

import java.io.IOException;

public class TestClass {
	public static void main(String[] args) {
		ServerHTTP server=new ServerHTTP();
		server.addRequest("/", new Response() {
			
			@Override
			public void execute(Client client) throws NotHandledRequestException, IOException {
				System.out.println("CLIENT "+client.toString());
				
			}
		});
		server.initialize();
		
	}
}
