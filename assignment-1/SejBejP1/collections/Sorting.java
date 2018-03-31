package collections;

import java.util.Random;

/**
 * Klassen anv�nds till för sortering av double array och ArrayList. Quicksort metoden 
 * sorterar en double[] i v�xande form medan mergesort metoden sorterar en ArrayList.
 * @author Benjamin Sejdic
 *
 */

public class Sorting {
	
	/**
	 * Quicksort används för att sortera en double array i växande form
	 * @param array arrayen som man vill sortera
	 */
	public static void sort(double[] array) {
		quickSort(array, 0, array.length-1);
	}
	
	private static void quickSort(double[] array, int start, int end) {
		int pivotIndex;	// anger det indexet som är sorterad i arrayen (t.ex. pivotIndex = 3 säger att elementet i array[3] är sorterad, den kommer inte flyttas)
		if(start < end) {
			pivotIndex = partition(array, start, end, (start+end)/(2) );
			quickSort(array, start, pivotIndex-1);	// Sorterar alla elementet till vänster om pivotIndexet
			quickSort(array, pivotIndex+1, end);	// Sorterar alla elemenetet till höger om pivotIndexet
		}
	}

	private static int partition(double[] array, int start, int end, int pivotIndex) {
		double pivotValue = array[pivotIndex];	// pivotValue = mittersta elementet i arrayen 
		int currentPos = start;
		
		double temp1 = array[end];
		array[end] = array[pivotIndex];
		array[pivotIndex] = temp1;
		
		for(int i = start; i < end; i++) {
			if(array[i] < pivotValue) {	// Om den hittar ett värde som är mindre än pivotValue läggs värdet längst till vänster i arrayen (currentPos ökar med ett sedan)
				double temp2 = array[currentPos];
				array[currentPos] = array[i];
				array[i] = temp2;
				currentPos++;
			}
		}
		
		double temp3 = array[currentPos];
		array[currentPos] = array[end];
		array[end] = temp3;
		
		
		return currentPos;
	}
	
	/**
	 * MergeSort används för att sortera en ArrayList i växande form
	 * @param list ArrayList som man vill sortera
	 */
	 public static void mergeSort(ArrayList list)  {
		 Object temp[] = new Object[ list.size() ];
		 mergeSort(list, 0, list.size(), temp);
		 temp = null;
	 }

	 private static void mergeSort(ArrayList list, int start, int n, Object[] temp) {
		 int n1, n2;
		 if ( n > 1) {		// Finns det mer än ett "element" i listan?
			 n1 = n/2;		// Delar upp listan i mitten, n1 kommer ha den v�nstra delen av listan
			 n2 = n - n1;	// n2 kommer ha den högra delen av listan
			 mergeSort(list, start, n1, temp);		// dela upp den vänstra listan tills man har elementen var för sig 
			 mergeSort(list, start + n1, n2, temp);	// därefter delar man upp den högra listan tills man har elementen var för sig
			 merge(list, start, n1, n2, temp);		
			 
		 }
	 }

	 private static void merge(ArrayList list, int first, int n1, int n2, Object[] temp) {
		 int cursor1 = 0;		// cursor1 pekar på vänster halva
		 int cursor2 = n1;		// cursor2 pekar på höger halva
		 int counter = 0;		// räknare som håller koll på vart man är någonstans i den temporära arrayen 
		 int last = (n1 + n2);	// Antalet element 
		 int compare;			// Används till att kunna jämföra objekten			
		 
		 while( (cursor1 < n1) && (cursor2 < last) ) {					// håller på sålänge man inte har jämfört alla element
			 Comparable comp = (Comparable)list.get(first + cursor1);	// comp innehåller ett element i den vänstra listan (n1)
			 compare = comp.compareTo(list.get(first + cursor2));		// elementet i comp jämförs sedan med ett element i den högra listan (n2)
			 if( compare < 0 ) {					
				 temp[ counter ] = list.get(first + cursor1);
	             cursor1++;
			 } else if ( compare > 0) {
				 temp[ counter ] = list.get(first + cursor2);
				 cursor2++;
			 }
			 counter++; // används som en hjälp pekare för att kunna veta vart nästa elemenet ska lagras i temp[] 
		 }
		 
		 while( cursor1 < n1) {
			temp[ counter ] = list.get(first + cursor1);
			cursor1++;
			counter++;
		 }
		 
		 while( cursor2 < last ) {
			 temp[ counter ] = list.get(first + cursor2);
			 cursor2++;
			 counter++;
		 }
		 
		 for(int i = 0; i < last; i++) {
			list.set((first + i), temp[i]);
		 }
	 }
	
	public static void main(String[] args) {
		Sorting lb4 = new Sorting();
		ArrayList list = new ArrayList();
		Random rand = new Random();
		
//----------------------------TEST AV QUICKSORT---------------------------------------		
//		double arrDouble[] = { 44.8, 45.0, 1.7, 0.6, 0.33, -66.0 };
//		
//		System.out.println("Före: ");
//		for(int i = 0; i < arrDouble.length; i++){
//			System.out.print(arrDouble[i] + " ");
//		}
//		System.out.println("\n");
//		sort(arrDouble);
//		System.out.println("Efter: ");
//		for(int i = 0; i<arrDouble.length; i++){
//			System.out.print(arrDouble[i] + " ");
//		}

//----------------------------TEST AV MERGESORT---------------------------------------
//		for ( int i = 0; i < 6; i++) {
//			list.add(i, rand.nextInt(20));
//		}
//		System.out.print("f�re");
//		System.out.println(list + " ");
//        lb4.mergeSort( list );
//        System.out.println("Efter");
//        System.out.print(list + " ");
//        System.out.println();
	}
}
