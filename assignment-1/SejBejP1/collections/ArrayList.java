package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Klassen kan användas till att skapa en array som är mer flexibel än en vanlig array då denna klass
 * har metoder som kan användas för att förändra arrayen på olika sätt.
 * @author Benjamin Sejdic
 *
 * @param <E> olika typer av objekt
 */
public class ArrayList<E> implements List<E> {
	private E[] elements;
	private int size;
	
	/**
	 * Används för att utöka arrayens storlek då den är full
	 */
	private void grow() {
		E[] temp = (E[]) new Object[2*elements.length];
		for(int i = 0; i<elements.length; i++) {
			temp[i] = elements[i];
		}
		elements = temp;
	}
	
	public ArrayList() {
		this(20);
	}
	
	public ArrayList(int initialCapacity) {
		initialCapacity = Math.max(1, initialCapacity);
		elements = (E[])new Object[initialCapacity];
	}

	public void add(int index, E element) {
//		System.out.println("Elements length: " + elements.length);
//		System.out.println("Size: " + size);
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		if(size==elements.length)
			grow();
		for(int i=size-1; i>index; i--) {
			elements[i]=elements[i-1];
		}
		elements[index] = element;
		size++;
		
	}

	public void add(E element) {
		add(size,element);
	}

	public void addFirst(E element) {
		add(0, element);
	}

	public void addLast(E element) {
		add(size, element);
	}

	public E remove(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E element = elements[index];
		for(int i = index; i<elements.length-1; i++) {
			elements[i] = elements[i+1];
		}
		
		elements[size-1] = null;
		size--;

		return element;
	}
	
//	public E remove(int n) {
//		if (n == 0) {
//            Integer value = (Integer)list.getData();
//            list = list.getNext();
//        } else {
//            ObjectNode node = list;
//            int currentPos = 0;
//            while (currentPos < n - 1) {
//                currentPos++;
//                node = node.getNext();
//            }
//            value = (Integer)node.getNext().getData();
//            node.setNext(node.getNext().getNext());
//        }
//        System.out.println(list);
//        System.out.println("Borttaget element: nr " + n + " med värdet " + value);
//    }

	public E removeFirst() {
		return remove(0);
	}

	public E removeLast() {
		return remove(size-1);
	}

	public void clear() {
		for(int i = 0; i < size; i++) {
			elements[i] = null;;
		}
		size = 0;
	}

	public E get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		return elements[index];
	}

	public E set(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		E prevElement = elements[index];
		elements[index] = element;
		return prevElement;
	}

	public int indexOf(E element) {
		for(int i = 0; i < size; i++) {
			if(element.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	public int indexOf(int startIndex, E element) {
		if (startIndex < 0 || startIndex > size) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = startIndex; i < size; i++) {
			if(element.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder("[ ");
		for(int i=0; i<size; i++) {
			res.append(elements[i]);
			if(i<size-1)
				res.append("; ");
		}
		res.append(" ]");
		return res.toString();
	}

	public Iterator<E> iterator() {
		return new Iter();
//		return new Iterator<E>() {
//			private int index=0;
//			
//			public boolean hasNext() {
//				return index<size;
//			}
//			
//			public E next() {
//				if(index==size)
//					throw new NoSuchElementException();
//				return elements[index++];
//			}
//			
//			public void remove() {
//				throw new UnsupportedOperationException();
//			}
//		};
	}
	
	private class Iter implements Iterator<E> {
		private int index=0;
		
		public boolean hasNext() {
			return index<size;
		}
		
		public E next() {
			if(index==size)
				throw new NoSuchElementException();
			return elements[index++];
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(10);
		for(int i=10; i<120; i+=10) {
			list.add(i);
		}
		System.out.println(list);
//		Iterator<Integer> numbers = list.iterator();
//		while(numbers.hasNext())
//			System.out.print(numbers.next()+ " ");
	
//		System.out.println();
//		list.add(3, 50);
//		System.out.println();
//		System.out.println("A1: " + list.size);
//		list.add(3, 50);
//		System.out.println("A2: " + list.size);

	
	}
	
	
	
	
}
