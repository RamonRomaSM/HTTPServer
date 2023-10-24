package HTTPService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	/*
	 * El programador usara esta clase para crear sus respuestas, hay que facilitar la creacion
	 * de respuestas http.
	 * 
	 * http codes:
	 * Respuestas informativas (100–199),
	 * Respuestas satisfactorias (200–299),
	 * Redirecciones (300–399),
	 * Errores de los clientes (400–499),
	 * y errores de los servidores (500–599).
	 * 
	 * "HTTP/1.1 200 OK\r\n\r\n".getbytes+ respuesta custom
	 * */
	
	
	private Socket soc;
	private InputStream in;
	private OutputStream out;
	
	public Client(Socket s) throws IOException {
		soc=s;
		in=s.getInputStream();
		out=s.getOutputStream();
		
		
		
	}
	
	public void send(byte[] respContent) throws IOException {
		out.write(("HTTP/1.1 200 OK\r\n").getBytes()); 
		out.write(("\r\n").getBytes());	
		out.write(respContent);
		out.flush();
	}
	
	
	
}
