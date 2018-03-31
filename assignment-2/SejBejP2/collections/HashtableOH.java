package collections;

import java.util.Iterator;

import collections.LinkedList;
import f13.Map;

/**
 * The class uses a chained hashtable which resolves collisions, more entries
 * can be stored in the bucket.
 * 
 * @author Benjamin Sejdic
 */
public class HashtableOH<K, V> implements Map<K, V> {
	private LinkedList<Entry<K, V>>[] table;
	private int size;

	/**
	 * Creates a new instance of HashtableOH 
	 */
	public HashtableOH(int size) {
		table = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			table[i] = new LinkedList<Entry<K, V>>();
		}
	}

	private int hashIndex(K key) {
		int hashCode = key.hashCode();
		hashCode = hashCode % table.length;
		return (hashCode < 0) ? -hashCode : hashCode;
	}

	public V put(K key, V value) {
		V res = null;
		int hashIndex = hashIndex(key);
		Entry<K, V> entry = new Entry<K, V>(key, value);
		int index = table[hashIndex].indexOf(entry);
		if (index == -1) {
			table[hashIndex].addFirst(entry);
			size++;
		} else {
			res = table[hashIndex].set(index, entry).value;
		}
		return res;
	}

	/**
	 * Prints every pair of key and value in the hashtable.
	 */
	public void list() {
		Entry<K, V> entry;
		for (int i = 0; i < table.length; i++) {
			System.out.print(i + ":");
			for (int j = 0; j < table[i].size(); j++) {
				entry = table[i].get(j);
				System.out.print(" <" + entry.key + "," + entry.value + ">");
			}
			System.out.println();
		}
	}

	public V get(K key) {
		int hashIndex = hashIndex(key);
		Entry<K, V> entry = new Entry<K, V>(key, null);
		for (int pos = 0; pos < table[hashIndex].size(); pos++) {
			if (table[hashIndex].get(pos).equals(entry)) {
				return table[hashIndex].get(pos).value;
			}
		}
		return null;
	}

	public V remove(K key) {
		V res = null;
		int hashIndex = hashIndex(key);
		Entry<K, V> entry = new Entry<K, V>(key, null);
		for (int pos = 0; pos < table[hashIndex].size(); pos++) {
			if (table[hashIndex].get(pos).equals(entry)) {
				res = table[hashIndex].get(pos).value;
				table[hashIndex].get(pos).key = null;
				table[hashIndex].get(pos).value = null;
				size--;
			}
		}
		return res;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean containsKey(K key) {
		return get(key) != null;
	}

	public void clear() {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].size(); j++) {
				table[i].get(j).key = null;
				table[i].get(j).value = null;
			}
		}
		size = 0;
	}

	public Iterator<K> keys() {
		ArrayList<K> keys = new ArrayList<K>();
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].size(); j++) {
				if (table[i].get(j).key != null) {
					keys.add(table[i].get(j).key);
				}
			}
		}
		return keys.iterator();
	}

	public Iterator<V> values() {
		ArrayList<V> values = new ArrayList<V>();
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].size(); j++) {
				if (table[i].get(j).value != null) {
					values.add(table[i].get(j).value);
				}
			}
		}
		return values.iterator();
	}

	public static void main(String[] args) {
		HashtableOH<String, String> table = new HashtableOH<String, String>(4);
		table.put("hej", "hello");
		table.put("röd", "red");
		table.put("vit", "white");
		table.put("säng", "bed");
		table.put("svart", "black");
		table.put("gul", "yellow");
		table.put("dator", "computer");
		table.put("snö", "snow");
		table.put("blå", "blue");
		table.put("grön", "green");
		table.put("hus", "house");
		System.out.println("true = " + table.containsKey("säng"));
		System.out.println("false = " + table.containsKey("haha"));
		System.out.println("bed = " + table.get("säng"));
		System.out.println("null = " + table.get("null"));
		System.out.println("isEmpty = " + table.isEmpty());
		System.out.println("removed svart: " + table.remove("svart"));
		table.list();
		System.out.println("added lahme = " + table.put("Lahme", "meat"));
		table.list();
		table.clear();
		System.out.println(table.size());
		table.list();
	}
}
