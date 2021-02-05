import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class battleBashServer{
  public static void main(String[] args) throws Exception{
    String host = "localhost";
    int port = 10430;

    ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(host));

    System.out.println("Server Started...");
    Socket client = new Socket(host, port);
    System.out.println("Connecting to Server...");
    Socket connection = server.accept();
    System.out.println("Successfully Connected");

    ObjectOutputStream clientOut = new ObjectOutputStream(client.getOutputStream());
    ObjectOutputStream serverOut = new ObjectOutputStream(connection.getOutputStream());
    ObjectInputStream clientIn = new ObjectInputStream(client.getInputStream());
    ObjectInputStream serverIn = new ObjectInputStream(connection.getInputStream());
    System.out.println("Communication ready...");

    String messageOut = "Hello World";
    clientOut.writeObject(messageOut);
    clientOut.flush();
    System.out.println("\"" + messageOut + "\"" + " was sent to the server");

    String messageIn = (String)serverIn.readObject();
    System.out.println("Message recieved from client: " + messageIn);

    clientOut.close();
    serverOut.close();
    System.out.println("Connections Closed");
    server.close();
    System.out.println("Server Terminated");
  }
}
