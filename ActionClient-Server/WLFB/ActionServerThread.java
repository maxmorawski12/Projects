
import java.net.*;
import java.util.Scanner;
import java.io.*;


public class ActionServerThread extends Thread {

	
  private Socket actionSocket = null;
  private SharedActionState mySharedActionStateObject;
  private String myActionServerThreadName;
  private String TransferAccount;
  private double balanceA;
  private double balanceB; 
  private double balanceC;
  private String value;
  String depositvalue, depositoutput; 
  

  	public ActionServerThread(Socket actionSocket, String ActionServerThreadName, SharedActionState SharedObject) {

	  this.actionSocket = actionSocket;
	  mySharedActionStateObject = SharedObject;
	  myActionServerThreadName = ActionServerThreadName;
	}

  public void run() {
    try {
      System.out.println(myActionServerThreadName + " initialising.");
      PrintWriter out = new PrintWriter(actionSocket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(actionSocket.getInputStream()));
      String inputLine, outputLine;
      String inputLine2 = null, outputLine2, TransferAmount;
      
      int value = 0;
      while ((inputLine = in.readLine()) != null) {

    	  try { 
    		  mySharedActionStateObject.acquireLock();  
    		  outputLine = mySharedActionStateObject.processInput(myActionServerThreadName, inputLine);
    		  out.println(outputLine);
    		  if (inputLine.equalsIgnoreCase("Deposit")) {
    			  System.out.println("You have Chosen Deposit");
    			  System.out.println("How much do you want to deposit?");
    			  while ((inputLine2 = in.readLine()) != null) {
    			  System.out.println("You have deposited " + inputLine2);  
    			  outputLine2 = mySharedActionStateObject.Add_money(myActionServerThreadName, inputLine2);
    			  out.println(outputLine2);
    			  
    			  mySharedActionStateObject.releaseLock();
    			  
    		  }
    		  }

    		  if (inputLine.equalsIgnoreCase("Withdraw")) {
    			  System.out.println("You have Chosen Withdraw");
    		  while ((inputLine2 = in.readLine()) != null) {
    			  System.out.println("You have withdrawn " + inputLine2);  
    			  outputLine2 = mySharedActionStateObject.Subtract_money(myActionServerThreadName, inputLine2);
    			  out.println(outputLine2);			  
    			  mySharedActionStateObject.releaseLock(); 
    			  
    		  }
    		  }
    		  

    		  
    		  if (inputLine.equalsIgnoreCase("Transfer")) {  
    			  System.out.println("You have Chosen Transfer");
    			  System.out.println("You are " + myActionServerThreadName );
        		  System.out.println("Who do you want to transfer to? ClientA, ClientB or ClientC" );
        		  while ((TransferAccount = in.readLine()) != null) {
        		  out.println(TransferAccount);
        		  if (myActionServerThreadName.equalsIgnoreCase(TransferAccount)) {
        			  System.out.println("Invalid");
        			  mySharedActionStateObject.releaseLock();
        			  break; 
        			  
        		  }				  	
    			  System.out.println("How much do you want to transfer"); 			  
    			  while ((TransferAmount = in.readLine()) != null) {
    			  outputLine2 = mySharedActionStateObject.Transfer_money(myActionServerThreadName, TransferAccount, TransferAmount);
    			  out.println(outputLine2);
    		      mySharedActionStateObject.releaseLock();
    			  }    			  
 
        		  }

    		  }
    			  
    		  }
    	  
    	  
    	  
    			
    		  
    		  
    	  
    		  
    		  
    	  
    
    	  catch(InterruptedException e) {
    		  System.err.println("Failed to get lock when reading:"+e);
    	  }
      }

       out.close();
       in.close();
       actionSocket.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
    }
}


  
