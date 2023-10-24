package HTTPService;

import java.io.IOException;
import java.net.Socket;

public interface Response {
	/*
	 * 
	 * 
	 * 
	 * example of a request: /?login=
	 * 
	 * */
	public void execute(Client client) throws NotHandledRequestException, IOException;
	
	

}
