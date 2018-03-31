package collections;


/**
 * Klassen inenhåller två söknings algoritmer binary search & linear search.
 * Kan användas då man vill kolla om ett objekt finns med i listan.
 * @author Benjamin Sejdic
 *
 */
public class Searching {

	/**
	 * används då listan är sorterad för att se om ett element finns samt returnera elementets position
	 * @param list ArrayList 
	 * @param element sökta elementet
	 * @return positionen för det sökta elementet eller -1 om elementet inte finns
	 */
	public static int binearSearch(ArrayList list, Object element) {
		int res = -1;	
		int pos;
		int min = 0;
		int max = list.size();
		int compare;
		Comparable comp = (Comparable) element;
		while ((min < max) && res == -1) {
			pos = (min + max) / (2);
			compare = comp.compareTo(list.get(pos));
			if (compare == 0) {	// om element = elementet i list
				res = pos;		// avbryt loopen om elementet hittas
				return pos;		// returneras positionen
			} else if (compare < 0) {	// om element är mindre än elementet i list
				max = pos - 1;
			} else {
				max = pos + 1;	// om element är större än elementet i list
			}
		}
		return -1; // hittade inget
	}
	
	/**
	 * Kontrollerar varje elemenet i listan med start på position 0 för att se om element finns 
	 * @param list List<E>
	 * @param element sökta elementet
	 * @return positionen för det sökta elementet eller -1 om elementet inte finns
	 */
	public static <E> int linearSearch(List<E> list, E element) {
		for(int i = 0; i < list.size(); i++) {
			if(element.equals(list.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Searching search = new Searching();
		ArrayList list = new ArrayList();
		
//--------------------------------TEST BinearSearch-------------------------------------------
//		for(int i=0; i<10; i++) {
//			list.add(i, i);
//		}
//		
//		System.out.print(list + "\n");
//		System.out.println(binearSearch(list, -5));
		
//--------------------------------TEST LinearSearch-------------------------------------------
//		list.add(1);
//		list.add(55);
//		list.add(66);
//		list.add(44);
//		list.add(0);
//		System.out.println(linearSearch(list, 0));
	}
}
