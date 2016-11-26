package ge.mziuri.gll.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread {

    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ObjectOutputStream getOos() {
        return oos;
    }

    @Override
    public void run() {

        try {

            socket = new Socket("127.0.0.1", 1234);

            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());

            while (socket.isConnected()) {

                String s = (String) ois.readObject();

            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        } catch (ClassNotFoundException ex) {

            System.out.println(ex.getMessage());

        }

    }

}
