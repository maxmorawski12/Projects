package task4;
import java.util.Random;
import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
public class CuriousMode extends MainClass {
	// Variables have been declared below
		Scanner scan = new Scanner(System.in);
		int detection;
		int i = 1;
		int randwheel;
		int randwheel2;
		MainClass myf = new MainClass();
		ModeChoose modechoose = new ModeChoose();
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
					System.out.println("The program ran in Curious Mode");
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
		public void curious() {

		//Below will make the code only run if the beak is not up
		
			finchwander();
			
		}
			
		
		//If the beak is up then it will stop all of the modes and print do you want to see the logs

		
		//This is the code for the finch wander below
		public void finchwander() {
			do {
			int wheeltime = 1000;					
			Random Rand = new Random();
				MainClass.myf.setLED(0,0,255);
				randwheel = Rand.nextInt(50);
				randwheel2 = Rand.nextInt(50);
				randwheel = randwheel + 50;
				randwheel2 = randwheel2 + 50;
				// i is the counter and is being printed below
				System.out.println(i);
				MainClass.myf.setWheelVelocities(60, 60, wheeltime);
				// i is being incremented after every wheel velocity change which is 1 second
				i++;
				while (MainClass.myf.isObstacleLeftSide() == true || MainClass.myf.isObstacleRightSide() == true) {
					finchdetection();
				}
				// this is the timer
				if (i % 5 == 0) {
					System.out.println("Object not found, Turning");
					MainClass.myf.setLED(0,0,255);
					MainClass.myf.setWheelVelocities(0, 0, 1000);
					MainClass.myf.setWheelVelocities(60, 0, 1000);
					i++;	
				}
				// this will active the terminate log
				if(MainClass.myf.isBeakUp() == true) {
					terminatelog();
				}
				}
			//condition below for entire loop
			while (MainClass.myf.isObstacleLeftSide() == false || MainClass.myf.isObstacleRightSide() == false || MainClass.myf.isObstacle() == false);
		}
				
			
		
			
				// this is run only when the finch has detected a object	
			public void finchdetection() {
				detection++;
				i = 1;
				do {
				// this is for turning left
				if (MainClass.myf.isObstacleLeftSide() == true && MainClass.myf.isObstacleRightSide() == false){
					System.out.println("Turning Left");
					MainClass.myf.setLED(0,255,0);
					MainClass.myf.setWheelVelocities(40, 80);
				}
				//this is for turning right
				else if (MainClass.myf.isObstacleLeftSide() == false && MainClass.myf.isObstacleRightSide() == true ) {
					System.out.println("Turning Right");
					MainClass.myf.setLED(0,255,0);
					MainClass.myf.setWheelVelocities(80, 40);
				}
				// this is for slight turning left
				else if (MainClass.myf.isObstacle() == true && MainClass.myf.isObstacleLeftSide() == true && MainClass.myf.isObstacleRightSide() == false ) {
					System.out.println("Slight Left Turn");
					MainClass.myf.setLED(0,255,0);
					MainClass.myf.setWheelVelocities(20, 40);
				}	
				// this is for a slight turn right
				else if (MainClass.myf.isObstacle() == true && MainClass.myf.isObstacleLeftSide() == false && MainClass.myf.isObstacleRightSide() == true ) {
					System.out.println("Slight Right Turn");
					MainClass.myf.setLED(0,255,0);
					MainClass.myf.setWheelVelocities(40, 20);
				}
				// this is for when the object is directly in front of it
				else if (MainClass.myf.isObstacle() == true && MainClass.myf.isObstacleLeftSide() == true && MainClass.myf.isObstacleRightSide() == true) {
					System.out.println("Stop");
					MainClass.myf.setLED(0,0,255);
					MainClass.myf.setWheelVelocities(0, 0);
				}
				}
				while(MainClass.myf.isObstacleLeftSide() == true || MainClass.myf.isObstacleRightSide() == true || MainClass.myf.isObstacle() == true);
			}

			 }

				
			
			

			
			
			






	





		

		
