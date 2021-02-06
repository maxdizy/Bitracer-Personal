import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class battleBashServer{
  public static void main(String[] args) throws Exception{
    try{
      ServerSocket server = new ServerSocket(4444);

      System.out.println("Server Started...");
      Socket connection = server.accept();
      System.out.println("Successfully Connected");

      //ObjectOutputStream clientOut = new ObjectOutputStream(client.getOutputStream());
      ObjectOutputStream serverOut = new ObjectOutputStream(connection.getOutputStream());
      //ObjectInputStream clientIn = new ObjectInputStream(client.getInputStream());
      ObjectInputStream serverIn = new ObjectInputStream(connection.getInputStream());
      System.out.println("Communication ready...");

      String messageIn = (String)serverIn.readObject();
      System.out.println("Message recieved from client: " + "\"" + messageIn + "\"");

      String messageOut = "What's Up Max";
      serverOut.writeObject(messageOut);
      serverOut.flush();
      System.out.println("\"" + messageOut + "\"" + " was sent to the server");
      //clientOut.close();
      //serverOut.close();

      serverIn.close();
      serverOut.close();
      System.out.println("Connections Closed");
      server.close();
      System.out.println("Server Terminated");
    }
    catch(Exception e){
      System.out.println("Server Failed...");
      System.out.println(e);
    }
  }
}
