package HTTPService;

import java.io.BufferedReader;  
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.plaf.synth.SynthOptionPaneUI;


public class ServerHTTP {
	private ServerSocket servSock;
	private String reqAct;
	private Socket clienteact;
	private HashMap<String,Response> responses;
	private ResponseHandler handler;	
	
	
	public ServerHTTP() {
		responses=new HashMap<String,Response>();
		
	}
	/*
	 *TODO:	la request es "algo?" lleva el ? para separarlo de los dato
	 * 
	 * 
	 * */
	public void addRequest(String req,Response r) {
		
		
		responses.put(req, r);
		System.out.println("Added request: "+req);
		
	}
	public void initialize() {
		
		System.out.println("Handled requests: "+responses.keySet().toString());
		
		setServerPort();
		try {
			handler=new ResponseHandler(responses);
		} catch (IOException e) {
			System.err.println("Failed declaring the handler");
		}	
		File f=new File(".//errorLog.txt");
		File f2=new File(".//log.txt");
		
		try {
			
		
		
		if(!f.exists()) {f.createNewFile();}
		if(!f2.exists()) {f2.createNewFile();}
		System.out.println("SERVER LOCATED IN :  "+InetAddress.getLocalHost().toString().split("/")[1]+":"+servSock.getLocalPort()+"\r\r");
		
		
		
		
		while(true) {
			clienteact=servSock.accept();		
			System.out.println("ACTUAL CLIENT: "+clienteact.toString());
			
			
			
			//Here we recieve the raw request
			InputStreamReader isr=  new InputStreamReader(clienteact.getInputStream());
			BufferedReader br= new BufferedReader(isr);
			String petic=br.readLine();
			while(br.ready()) {
				petic=petic+br.readLine()+"\r";
				
			}
			System.out.println(petic);
			
			
			//here we isolate the request
			String[] datosPeticion=petic.split("\r");
			
			String datos=datosPeticion[datosPeticion.length-1];
			
			reqAct=datosPeticion[0].split(" ")[1]+" "+datos;
			
			
			//here we resolve 
			//the request is formed by 2 parts separated by " ", te tequest, and the data from the form
			System.out.println("ACTUAL REQUEST: "+reqAct);
			
			handler.resolve(reqAct.split(" ")[0], clienteact);		
			
			
			
		
		
			}
		} catch (Exception e) {
			System.out.println("Failed initializing the server");
			e.printStackTrace();
		}
		
	}
	private void setServerPort() {
		
		boolean init=false;
		int i=0;
		while(!init) {
			try {
				servSock =new ServerSocket(i);
				init=true;
			} catch (Exception e) {
				i++;
			}
			
		}
		
	}
	public void close() {
		try {
			servSock.close();
		} catch (IOException e) {
			
		}
		
	}
	
	
	
	
	
}
