package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	 // Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	static boolean winYet = false;
	public static void main(String[] args) {
		Robot[] robs = new Robot[5];
		Thread[] threads = new Thread[5];
		for (int i = 0; i < robs.length; i++) {
			final int var = i;
			robs[i] = new Robot();
			robs[i].setY(800);
			robs[i].setX(i*300+200);
			robs[i].setSpeed(500);
			threads[i] = new Thread(() -> {
				while(robs[var].getY() > 100) {
					int num = new Random().nextInt(50);
					robs[var].move(num);
					if (winYet) {
						robs[var].move(-1 * num);
						break;
					}
				}
				
				if(!winYet) {
					winYet = true;
					JOptionPane.showMessageDialog(null, "Robot " + (var+1) + " wins!");
				}
			});
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}
}
