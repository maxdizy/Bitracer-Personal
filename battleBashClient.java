import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class battleBashClient{
  public static void main(String[] args) throws Exception{
    try{
      Socket client = new Socket("192.168.0.110", 4444);

      ObjectOutputStream clientOut = new ObjectOutputStream(client.getOutputStream());
      //ObjectOutputStream serverOut = new ObjectOutputStream(connection.getOutputStream());
      ObjectInputStream clientIn = new ObjectInputStream(client.getInputStream());
      //ObjectInputStream serverIn = new ObjectInputStream(connection.getInputStream());
      System.out.println("Communication ready...");

      String messageOut = "Hello World";
      clientOut.writeObject(messageOut);
      clientOut.flush();
      System.out.println("\"" + messageOut + "\"" + " was sent to the server");

      String messageIn = (String)clientIn.readObject();
      System.out.println("Message recieved from server: " + "\"" + messageIn + "\"");


      clientOut.close();
      client.close();
    }
    catch(Exception e){
      System.out.println("Client Failed...");
      System.out.println(e);
    }
  }
}
