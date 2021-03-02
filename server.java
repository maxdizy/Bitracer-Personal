import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server{
  public static void main(String[] args) throws Exception{
    try{
      ServerSocket server = new ServerSocket(8888);

      System.out.println("Server Started...");
      Socket connection = server.accept();
      System.out.println("Successfully Connected");

      ObjectOutputStream serverOut = new ObjectOutputStream(connection.getOutputStream());
      ObjectInputStream serverIn = new ObjectInputStream(connection.getInputStream());
      System.out.println("Communication ready...");

      Scanner scan = new Scanner(System.in);
      String messageIn;
      String messageOut;
      boolean running = true;
      while(running){
        String input = scan.nextLine();
        if (input.equals("q")){
          running = false;
        }
        if (input.equals("rs")){
          messageIn = (String)serverIn.readObject();
          System.out.println("Message recieved from client: " + "\"" + messageIn + "\"");
        }
        if (input.equals("ws")){
          messageOut = input;
          serverOut.writeObject(messageOut);
          serverOut.flush();
          System.out.println("\"" + messageOut + "\"" + " was sent to the server");
        }
      }

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
