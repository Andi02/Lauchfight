package lauchfight;


import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ServerThread extends Thread{
    
    
    InputStream inputToServer;
    OutputStream outputFromServer;
    Scanner input;
    PrintWriter printWriter;

    public ServerThread() {
        //read inputs    
        try {
            Socket listenerSocket = Server.finalServerSocket.accept();

            inputToServer = listenerSocket.getInputStream();
            outputFromServer = listenerSocket.getOutputStream();

            input = new Scanner(inputToServer, "UTF-8");
            printWriter = new PrintWriter(new OutputStreamWriter(outputFromServer, "UTF-8"), true);
        } catch (Exception ex) {
        	System.out.println("Error while createing server thread");
        }
    }
    
    @Override
	public void run(){
    	
    	while(true) {
    		printWriter.println(Server.lfo.tickGame(input.nextLine()));
    		
            try{
                Thread.sleep(1);
            }catch(Exception e){}
    	}
        
    }
    
}
