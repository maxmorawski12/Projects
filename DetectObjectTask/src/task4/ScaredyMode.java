package task4;
import java.util.Random;
import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
public class ScaredyMode extends MainClass {
	Scanner scan = new Scanner(System.in);
	int detection;
	int i = 1;
	int a = 1;
	int randwheel;
	int randwheel2;
	MainClass myf = new MainClass();
	CuriousMode c = new CuriousMode();
	long start = System.currentTimeMillis();
	// termination log below
	 public void terminatelog() {
		 	
		 	MainClass.myf.stopWheels();
			System.out.println("Do you want to see the execution logs? 1 = Yes / 2 = No");
			int p = scan.nextInt();
			if(p == 1) {
				long end = System.currentTimeMillis();
				long endtime = (end - start) / 1000;
				System.out.println("Here are the logs");
				System.out.println("The program ran in Scaredy Mode");
				System.out.println("The finch detected an object " +detection + " times");
				System.out.println("The finch ran for a total of " +endtime + " seconds");
				System.exit(0);
			}
			else if (p == 2) {
				System.out.println("Termination");
				System.exit(0);
			}
			else {
				System.out.println("Wrong input try again");
				terminatelog();
			}
			}
	 //beginning of the mode
	public void scaredy() {
		do {
			wandering();			
		}
		while(MainClass.myf.isObstacleLeftSide() == false || MainClass.myf.isObstacleRightSide() == false || MainClass.myf.isObstacle() == false);
		do
		{
			detected();
		}
		while(MainClass.myf.isObstacleLeftSide() == true || MainClass.myf.isObstacleRightSide() == true || MainClass.myf.isObstacle() == true);
	}
	// wander mode below
	public void wandering() {
		int wheeltime = 1000;					
		Random Rand = new Random();
		if (MainClass.myf.isObstacleLeftSide() == false || MainClass.myf.isObstacleRightSide() == false || MainClass.myf.isObstacle() == false){
			MainClass.myf.setLED(0,0,255);
			randwheel = Rand.nextInt(50);
			randwheel2 = Rand.nextInt(50);
			randwheel = randwheel + 50;
			randwheel2 = randwheel2 + 50;
			System.out.println(i);
			//random wheel feature below
			MainClass.myf.setWheelVelocities(randwheel, randwheel2, wheeltime);
			// timer added 1 by one
			i++;
			if (MainClass.myf.isObstacleLeftSide() == true || MainClass.myf.isObstacleRightSide() == true) {
				detected();
			}
			if (i % 5 == 0) {
				System.out.println("Object not found, Turning");
				MainClass.myf.setLED(0,0,255);
				MainClass.myf.setWheelVelocities(60, 0, 1000);
				i++;
			}
			if(MainClass.myf.isBeakUp() == true) {
				terminatelog();
			}
			}

		}
		
		
		
	// only for when the finch detects
	public void detected() {
		i = 1;
		++detection;
			MainClass.myf.buzz(2000, 1000);
			MainClass.myf.setLED(255,0,0);
			System.out.println("Object Detected, Reversing");
			MainClass.myf.setWheelVelocities(-200, -200, 500);
			System.out.println("Turning Around");
			MainClass.myf.setWheelVelocities(0, -145, 2000);
			MainClass.myf.setWheelVelocities(100, 100, 3000);
			}
	}
	
		
	
