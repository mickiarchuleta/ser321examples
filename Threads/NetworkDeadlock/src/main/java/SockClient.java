import java.net.*;
import java.io.*;

class SockClient {
    public static void main(String[] args) throws Exception {
        String host = args.length > 0 ? args[0] : "localhost";
        int    port = args.length > 1 ? Integer.parseInt(args[1]) : 3333;

        Socket sock = new Socket(host, port);
        ObjectInputStream  in  = new ObjectInputStream(sock.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());

        String s = (String) in.readObject();
        out.writeObject("Back at you");

        in.close(); out.close(); sock.close();
    }
}
