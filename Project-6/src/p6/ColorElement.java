package p6;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument.LeafElement;

public class ColorElement {
	private int r, g, b, color;
	private Array7x7 arr7x7;
	private int vertikal = 1, horisontell = 5;
	private ColorDisplay colorDisplay = new ColorDisplay(vertikal, horisontell, Color.BLACK, Color.WHITE); // "new"
	private Array7x7[] Aarr7x7 = new Array7x7[vertikal * horisontell]; // måste
	// finnas
	// med
	// för
	// att
	// kunna
	// instansiera
	// ColorDisplay

	public ColorElement() {
		panel();
	}

	public void panel() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.add(colorDisplay);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < Aarr7x7.length; i++) {
			Aarr7x7[i] = new Array7x7();
		}
	}

	/**
	 * Mehod that flashed the letter no the 7x7 display
	 * @param array7x7
	 */
	public void arrayInput(Array7x7 array7x7) {
		int tempArray[][] = new int[7][7];
		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 7; col++) {
				arr7x7.setElement(row, col, array7x7.cloneArray()[row][col]);
			}
		}
		arr7x7.multiplyArray7x7(0xFF00FF00);
		tempArray = arr7x7.cloneArray();
		checkColor(tempArray);
		updateDisplay(tempArray, 0);

	}

	/**
	 * 
	 * Går igenom varje plats i den tvådimensionella arrayen och ser hur mycket
	 * av rött, grönt och blått int värdet innehåller.
	 * 
	 * @param array
	 */
	public void checkColor(int[][] array) {

		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				r = Color.red(array[row][col]);
				g = Color.green(array[row][col]);
				b = Color.blue(array[row][col]);
				color = Color.rgb(r, g, b);
				array[row][col] = color;
			}
		}
	}

	/**
	 * Updates the display
	 * @param array
	 * @param display
	 */
	public void updateDisplay(int[][] array, int display) {
		for (int j = 0; j < vertikal; j++) {
			colorDisplay.setDisplay(array, j, display);
			colorDisplay.updateDisplay();
		}
	}

	/**
	 * Method that shifts the Array7x7 to the left
	 * @param arr
	 */
	public void takeArray(int[] arr) {
		arr = Aarr7x7[0].multiplyArray7(arr, 0xFF00FF00);
		for (int i = 0; i < Aarr7x7.length; i++) {
			arr = Aarr7x7[i].shiftLeft(arr);
			checkColor(Aarr7x7[i].cloneArray());
			updateDisplay(Aarr7x7[i].cloneArray(), Aarr7x7.length - 1 - i);
		}
	}
}
