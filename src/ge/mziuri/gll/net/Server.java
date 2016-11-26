package ge.mziuri.gll.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private static ArrayList<ServerThread> clients = new ArrayList<>();

    private static int ClientID = 1;

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(1234);

            while (true) {

                Socket socket = server.accept();

                ServerThread serverthread = new ServerThread(socket, ClientID);

                ClientID++;

                serverthread.start();

                clients.add(serverthread);

            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

}
