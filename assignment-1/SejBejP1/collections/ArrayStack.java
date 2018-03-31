package collections;

import java.util.EmptyStackException;

import f5.StackOverflowException;

/**
 * Används för att lagra olika slags objekt
 * 
 * @author Benjamin Sejdic
 *
 * @param <T> olika typer av objekt
 *            
 */
public class ArrayStack<T> implements Stack<T> {
	private T[] elements;
	private int size = 0;

	/**
	 * 
	 * @param capacity hur stor stacken ska vara
	 *            
	 */
	public ArrayStack(int capacity) {
		elements = (T[]) (new Object[capacity]);
	}

	/**
	 * lagrar element i stacken
	 */
	public void push(T element) {
		if (size >= elements.length)
			throw new StackOverflowException();
		elements[size] = element;
		size++;
	}

	/**
	 * hämtar ett element från stacken
	 */
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T elem = elements[--size];
		elements[size] = null;
		return elem;
	}

	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return elements[size - 1];
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<Integer>(20);
		Integer elem;
		for (int i = 0; i < 10; i++) {
			stack.push(new Integer(i));
		}
		// stack.push("HEJ"); // kompileringsfel
		while (!stack.isEmpty()) {
			elem = stack.pop();
			System.out.print(elem + " ");
		}
	}
}
