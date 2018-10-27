package lauchfight;

import java.net.ServerSocket;


public class Server {
    
    static ServerSocket finalServerSocket;
    static ServerThread t2;
    static ServerThread t1;
    static LauchFightOnline lfo;
    
//    public static void main(String[] args) {
//        lfo = new LauchFightOnlineOnline();
//        lfo.setUp();
//        
//        int port = 8187;
//
//        //Create multiple ServerSockets to connect to a server
//        ServerSocket serverSocket = null;
//        try {
//            serverSocket = new ServerSocket(port);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        finalServerSocket = serverSocket;
//
//        //for every player that wants to connect to the server
//        t1 = new ServerThread();
//        t1.start();
//
//        t2 = new ServerThread();
//        t2.start();
//        
//        
//  
//    }
//    
}
