package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslationApplication {

public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = null;
		
		try {
			//Bind ServerSocket to a port
			int portNo = 4222;
			serverSocket = new ServerSocket(portNo);
			
			String text1 = "Good afternoon";
			System.out.println("Waiting for request");
			
			while (true) {
				//Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				//Create steam to write data on network
				DataOutputStream outputStream = new DataOutputStream
						(clientSocket.getOutputStream());
				
				//Send current date back to the client
				outputStream.writeUTF(text1);;
				
				//Close the socket
						clientSocket.close();
			}
			
			//Closing is not necessary because the code is unreachable
			
		} catch(IOException ioe) {
			if(serverSocket != null)
				serverSocket.close();
			
			ioe.printStackTrace();
			
		}
	}
}
