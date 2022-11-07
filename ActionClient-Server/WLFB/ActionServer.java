import java.net.*;
import java.io.*;





public class ActionServer {
  public static void main(String[] args) throws IOException {

	ServerSocket ActionServerSocket = null;
    boolean listening = true;
    String ActionServerName = "ActionServer";
    int ActionServerNumber = 4545;
    
    double BalanceA = 1000;
    double BalanceB = 1000;
    double BalanceC = 1000;

    
    
	SharedActionState ourSharedActionStateObject = new SharedActionState(BalanceA,BalanceB,BalanceC);
        


    try {
      ActionServerSocket = new ServerSocket(ActionServerNumber);
    } catch (IOException e) {
      System.err.println("Could not start " + ActionServerName + " specified port.");
      System.exit(-1);
    }
    System.out.println(ActionServerName + " started");

    
    while (listening){
      new ActionServerThread(ActionServerSocket.accept(), "ClientA", ourSharedActionStateObject).start();
      new ActionServerThread(ActionServerSocket.accept(), "ClientB", ourSharedActionStateObject).start();
      new ActionServerThread(ActionServerSocket.accept(), "ClientC", ourSharedActionStateObject).start();
    }
    ActionServerSocket.close();
  }
}