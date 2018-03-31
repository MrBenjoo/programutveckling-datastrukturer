
package p6;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FlowingText2 {

	private long start, stop;
	private Timer timer;
	private int delay = 1000; // en second
	private boolean isRunning = false;
	private Array7x7[] charArray;
	private int loop = 10;
	// char[] charArray;
	String txt;

	// Timer task will be executed when called by the Timer object
	private TimerTask timerTask = new TimerTask() {
		private int i = 0;
		ColorElement ce = new ColorElement();
		ColorDisplay cd = new ColorDisplay(0, 0);
		Character ch = new Character();

		public void run() {
			
			if (i < loop) {
				
				int[] arr = new int[7];
				
				for (int letter = 0; letter < txt.length(); letter++) {
					charArray[letter] = ch.getChar(txt.charAt(letter));
					for (int col = 0; col < charArray[letter].getCol(0).length; col++) {
						for (int row = 0; row < charArray[letter].getRow(0).length; row++) {
							arr[row] = charArray[letter].getElement(row, col);
							
						}
						ce.takeArray(arr);
						cd.pause(100);
						
					}
				}
				i++;
				System.out.println("i: " + i );
			} else {
				timer.cancel();
			}
		}
	};

	/**
	 * Constructor
	 * 
	 * @param delay
	 */
	public FlowingText2(int delay) {
		timer = new Timer();
		getUserInput();
		charArray = new Array7x7[txt.length()];
		charArray();
		setDelay(delay);

	}

	public FlowingText2(String txt) {
		timer = new Timer();
		this.txt = txt;
		charArray = new Array7x7[txt.length()];
		charArray();
	}

	/**
	 * Asks the user to input a text that is stored in a String variable
	 */
	private String getUserInput() {
		return this.txt;
	}

	/**
	 * Sets the text that is stored in a String variable and initializes the
	 * char array and copies the chars from the string to the char array
	 */
	private void setInput(String str) {
		txt = str;
		// charArray = new char[txt.length()];
		// for(int i=0;i<txt.length();i++){
		// charArray[i] = txt.charAt(i);
		// }
	}

	/**
	 * Copies the contents of the user intput string to the character array
	 */
	private void charArray() {
		// charArray = new char[txt.length()];
		// for(int i=0;i<txt.length();i++){
		// charArray[i] = txt.charAt(i);
		// }
	}

	/**
	 * Returns a boolean of the timer showing if it is running or not
	 * 
	 * @return isRunning
	 */
	public boolean isRunning() {
		return this.isRunning;
	}

	/**
	 * Sets the delay in milliseconds
	 * 
	 * @param delay
	 */
	public void setDelay(int delay) {
		this.delay = delay;
	}

	/**
	 * The current system time stored into the start variable, used for time
	 * measurement and sets the boolean isRunning to the value true
	 */
	public void startTime() {
		this.start = System.currentTimeMillis();
		isRunning = true;
	}

	/**
	 * The current system time stored into the stop variable, used for time
	 * measurement and sets the boolean isRunning to the value false
	 */
	public void stopTime() {
		this.stop = System.currentTimeMillis();
		isRunning = false;
	}

	public void stopTimer() {
		timer.cancel();
	}

	/**
	 * Calling the TimerTask to execute the task parallel to the run method
	 */
	public void run() {
		System.out.println("System ready...");
		startTime();
		System.out.println("running...");
		timer.schedule(timerTask, 2000, 500);
	}

	// Main to test the code
	public static void main(String[] args) {

		FlowingText1 ft1 = new FlowingText1();

		ft1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		ft1.setLocationRelativeTo(null);
		ft1.setVisible(true);
		ft1.setSize(new Dimension(300, 200));

	}
}
