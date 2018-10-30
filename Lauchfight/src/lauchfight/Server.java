package lauchfight;

import java.net.ServerSocket;
import java.util.ArrayList;


public class Server {
    
    static ServerSocket finalServerSocket;
    
    static ServerThread t1;
    static ServerThread t2;
    static ServerThread t3;
    
    static LauchFightOnline lfo;
    
    public static void main(String[] args) {
        lfo = new LauchFightOnline();
        lfo.setUp();
        
        int port = 8187;

        //Create multiple ServerSockets to connect to a server
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }

        finalServerSocket = serverSocket;
        t1 = new ServerThread();
        t1.start();
        t2 = new ServerThread();
        t2.start();
        t3 = new ServerThread();
        t3.start();

        //for every player that wants to connect to the server
        
//        th.stream().forEach((a) -> {
//        	a.start();
//        });
        
        gameLoop();
        
    }
    
    
    public static void gameLoop() {
    	
    	while(true) {
    		lfo.gameLoop();	
    		try {
    			Thread.sleep(10);
    		}catch(Exception e) {}
    	}
    	
    }
    
}
