import java.net.*;
import java.util.Scanner;
import java.io.*;

public class SharedActionState{
	String value;
	private SharedActionState mySharedObj;
	private String myThreadName;
	private double balanceA;
	private double balanceB; 
	private double balanceC;
	private boolean accessing=false;
	private int threadsWaiting=0; 
	Double transfervalue;

	
	
	SharedActionState(double BalanceA, double BalanceB , double BalanceC) {
		balanceA = BalanceA;
		balanceB = BalanceB;
		balanceC = BalanceC;
	}

	
	  public synchronized void acquireLock() throws InterruptedException{
	        Thread me = Thread.currentThread(); 
	        System.out.println(me.getName()+" is attempting to acquire a lock!");	
	        ++threadsWaiting;
		    while (accessing) {  
		      System.out.println(me.getName()+" waiting to get a lock as someone else is accessing the thread");
		      wait();
		    }
		    --threadsWaiting;
		    accessing = true;
		    System.out.println(me.getName()+" got a lock!"); 
		  }

		  
		  public synchronized void releaseLock() {
		      accessing = false;
		      notifyAll();
		      Thread me = Thread.currentThread();
		      System.out.println(me.getName()+" released a lock!");
		  }
	
	

	public synchronized String processInput(String myThreadName, String theInput) {

    		System.out.println(myThreadName + " received "+ theInput);
    		String theOutput = null;
    		if (theInput.equalsIgnoreCase("Deposit") || (theInput.equalsIgnoreCase("Withdraw") || (theInput.equalsIgnoreCase("Transfer")))) {

    			if (myThreadName.equals("ClientA")) {	  
       				System.out.println(myThreadName + " made the Balance " + balanceA);
       				
    				theOutput = "Balance is = " + balanceA ;
    			}
		
    			else if (myThreadName.equals("ClientB")) {
    		
       				System.out.println(myThreadName + " made the Balance " + balanceB);
       				
    				theOutput = "Balance is = " + balanceB ;

    			}
       			else if (myThreadName.equals("ClientC")) {
       				
       				System.out.println(myThreadName + " made the Balance " + balanceC);
       				
    				theOutput = "Balance is = " + balanceC ;

       			}
    			
       			else {System.out.println("Error - thread call not recognised.");}
    		}
    		
    		
    		else { 
    			theOutput = myThreadName + " received incorrect request - only understand \"Deposit, Withdraw and Transfer\"";
		
    		}

 

    		System.out.println(theOutput);
    		return theOutput;
    	}
	public synchronized String Add_money(String myThreadName, String inputLine2) {
			String theOutput2 = "";
			if (myThreadName.equalsIgnoreCase("ClientA")){
				Double depositvalue = Double.parseDouble(inputLine2);
				balanceA = depositvalue + balanceA;
				theOutput2  = myThreadName + " new Balance " + balanceA;
			}
			if (myThreadName.equalsIgnoreCase("ClientB")){
				Double depositvalue = Double.parseDouble(inputLine2);
				balanceB = depositvalue + balanceB;
				theOutput2  = myThreadName + " new Balance " + balanceB;
			}
			if (myThreadName.equalsIgnoreCase("ClientC")){
				Double depositvalue = Double.parseDouble(inputLine2);
				balanceC = depositvalue + balanceC;
				theOutput2  = myThreadName + " new Balance " + balanceC;				
			}
				
			System.out.println(theOutput2);
			return theOutput2;
	}
	public synchronized String Subtract_money(String myThreadName, String inputLine2) {
		String theOutput2 = "";
		if (myThreadName.equalsIgnoreCase("ClientA")){
			Double withdrawvalue = Double.parseDouble(inputLine2);
			System.out.println(myThreadName + " received "+ withdrawvalue);
			balanceA = balanceA - withdrawvalue;
			theOutput2  = "New Balance " + balanceA;
		}
		if (myThreadName.equalsIgnoreCase("ClientB")){
			Double withdrawvalue = Double.parseDouble(inputLine2);
			System.out.println(myThreadName + " received "+ withdrawvalue);
			balanceB = balanceB - withdrawvalue;
			theOutput2  = "New Balance " + balanceB;
		}
		if (myThreadName.equalsIgnoreCase("ClientC")){
			Double withdrawvalue = Double.parseDouble(inputLine2);
			System.out.println(myThreadName + " received "+ withdrawvalue);
			balanceC = balanceC - withdrawvalue;
			theOutput2  = "New Balance " + balanceC;
		}

		System.out.println(theOutput2);
		return theOutput2;
}
	
	

	public synchronized String Transfer_money(String myThreadName, String ThreadName, String inputLine2) {
		String theOutput2 = "";
			transfervalue = Double.parseDouble(inputLine2);
			System.out.println(ThreadName + " received "+ transfervalue);
			if (myThreadName.equalsIgnoreCase("ClientA")){
			balanceA = balanceA - transfervalue; 
			theOutput2  = "new balance after transfer " + balanceA;
			}
			if (myThreadName.equalsIgnoreCase("ClientB")){
				balanceB = balanceA - transfervalue; 
				theOutput2  = "new balance after transfer " + balanceB;
				}
			if (myThreadName.equalsIgnoreCase("ClientC")){
				balanceC = balanceC - transfervalue; 
				theOutput2  = "new balance after transfer " + balanceC;
				}
			if (ThreadName.equalsIgnoreCase("ClientA")) {
				ThreadName = "ClientA";
				Add_money(ThreadName, inputLine2);
			}
			if (ThreadName.equalsIgnoreCase("ClientB")) {
				ThreadName = "ClientB";
				Add_money(ThreadName, inputLine2);	
			}
			if (ThreadName.equalsIgnoreCase("ClientC")) {
				ThreadName = "ClientC";
				Add_money(ThreadName, inputLine2);
			}
			
			return theOutput2;
			
			
			

		
		
	
}

}

