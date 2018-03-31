package p6;
/**
 * 
 * @author Benjamin Sejdic
 * 
 */
public class Array7 {

	private int[] array7;
	
	/**
	 * Constructor
	 */
	public Array7() {
		this.array7 = new int[7];
	}

	/**
	 * Sets a value to the specified row in array7
	 * @param pos the position we want to change
	 * @param value the value we want to set
	 */
	public void setElement(int pos, int value) {
		array7[pos] = value;
	}

	/**
	 * Returns an element from the specified position
	 * @param pos the position we want to get the value from
	 * @return the value from the specified position
	 */
	public int getElement(int pos) {
		return array7[pos];
	}
	
	/**
	 * Returns array7
	 * @return array7
	 */
	public int[] getArray() {
		int[] tempArr = new int[7];
		for (int i = 0; i < array7.length; i++ ) {
			tempArr[i] = array7[i];
		}
		return tempArr;
	}
}
