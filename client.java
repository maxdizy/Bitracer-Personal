import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class client{
  public static void main(String[] args) throws Exception{
    try{
      //Socket client = new Socket("192.168.0.110", 4444);
      Socket client = new Socket("localhost", 8888);
      Scanner scan = new Scanner(System.in);

      ObjectOutputStream clientOut = new ObjectOutputStream(client.getOutputStream());
      ObjectInputStream clientIn = new ObjectInputStream(client.getInputStream());
      System.out.println("Communication ready...");

      String messageOut;
      String messageIn;
      boolean running = true;

      while(running){
        String input = scan.nextLine().toLowerCase();
        //quit
        if (input.equals("q")){
          running = false;
        }
        if (input.equals("read")){
          //read data
          try{
            messageIn = (String)clientIn.readObject();
            System.out.println("Message recieved from server: " + "\"" + messageIn + "\"");
          }
          catch(Exception e){
            System.out.println("there are no message to recieve...");
          }
        }
        else if(verification.checkName(input)){
          //write data
          messageOut = input;
          clientOut.writeObject(messageOut);
          clientOut.flush();
          System.out.println("\"" + messageOut + "\"" + " was sent to the server");
        }
      }
      clientOut.close();
      clientIn.close();
      System.out.println("connections closed.");
      client.close();
      System.out.println("client terminated");
    }

    catch(Exception e){
      System.out.println("Client Failed...");
      System.out.println(e);
    }
  }
}
