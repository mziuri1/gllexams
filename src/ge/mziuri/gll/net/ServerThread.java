package ge.mziuri.gll.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {

    private int ClientID;

    private Socket socket;

    private ObjectOutputStream oos;

    private ObjectInputStream ois;

    public ServerThread(Socket socket, int clientId) {

        this.socket = socket;
        this.ClientID = ClientID;

        try {

            oos = new ObjectOutputStream(socket.getOutputStream());

            ois = new ObjectInputStream(socket.getInputStream());

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

    @Override
    public void run() {

        while (socket.isConnected()) {

        }

    }

}
