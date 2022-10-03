package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.

	public static void main(String[] args) {
		Thread r1 = new Thread(() -> circle(525, 600, Color.GREEN));
		Thread r2 = new Thread(() -> circle(675, 600, Color.YELLOW));
		Thread r4 = new Thread(() -> circle(450, 500, Color.RED));
		Thread r5 = new Thread(() -> circle(600, 500, Color.BLACK));
		Thread r3 = new Thread(() -> circle(750, 500, Color.BLUE));
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
	}
	
	public static void circle(int x, int y, Color color) {
		Robot robot = new Robot();
		robot.hide();
		robot.setSpeed(500);
		robot.setPenColor(color);
		robot.setPenWidth(100);
		robot.penUp();
		robot.moveTo(x, y);
		robot.penDown();
		for (int i = 0; i < 120; i++) {
			robot.move(5);
			robot.turn(3);
		}
	}
}

