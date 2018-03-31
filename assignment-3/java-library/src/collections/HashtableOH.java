package collections;
import java.util.*;
import java.util.Iterator;


/**
 * Hashtabellen använder öppen hashing
 * @author Danial Mahmoud
 */
public class HashtableOH<K,V> implements Map<K,V> { 
    private LinkedList<Entry<K,V>>[] table;
    private int size;
    
    /** Creates a new instance of HashtableOH */
    public HashtableOH( int size ) {
        table = (LinkedList<Entry<K,V>>[])new LinkedList[ size ];
        for( int i = 0; i < size; i++ ) {
            table[ i ] = new LinkedList<Entry<K,V>>();
        }
    }
    
    public int hashIndex( K key ) {
        int hashCode = key.hashCode();
        hashCode = hashCode % table.length;
        //System.out.println("hashCode in HashtableOH: " + hashCode);
        return ( hashCode < 0 ) ? -hashCode : hashCode;
    }
    
    public V put( K key, V value ) {
    	V res = null;
        int hashIndex = hashIndex( key );
        Entry<K,V> entry = new Entry<K,V>( key, value );
        int index = table[ hashIndex ].indexOf( entry );
        if( index == -1 ) {
            table[ hashIndex ].addFirst( entry );
            res = table[ hashIndex].get(0).value;
            size++;
        }
        else {
        	res = table[ hashIndex ].add2( index, entry ).value;
        }
        return res;
    }
    
    public void list() {
        Entry<K,V> entry;
        for(int i=0; i<table.length; i++) {
            System.out.print( i + ":");
            for( int j = 0; j < table[ i ].size(); j++ ) {
                entry = table[ i ].get( j );
                System.out.print(" <" + entry.key +"," + entry.value + ">" );
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
		Entry<K, V> entry;
		V res = null;
		for (int i = 0; i < table.length; i++) {
			for (int k = 0; k < table[i].size(); k++) {
				entry = table[i].get(k);
				if (entry.key == key) {
					res = entry.value;
					table[i].remove(k);
					size--;
				}
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
		int hashIndex = hashIndex( key );
		V value = get(key);
        Entry<K,V> entry = new Entry<K,V>( key, value );
        int index = table[ hashIndex ].indexOf( entry );
        if( index == -1 ) {
        	return false;
        }else{
        	return true;
        }
	}

	public void clear() {
		Entry<K, V> entry;
		for(int i = 0; i < table.length; i++){ 
            for( int k = 0; k < table[i].size(); k++ ) { 
            	entry = table[i].get(k);
            	entry.key = null;
            	entry.value = null;
            }

        }
		size = 0;
	}

	public Iterator<K> keys() {
		ArrayList<K> list = new ArrayList<K>();
		for(int i = 0; i < table.length; i++){
			for(int k = 0; k < table[i].size(); k++){
				if(table[i].get(k).key != null){
					list.add(table[i].get(k).key);
				}
			}
		}
		return list.iterator();
	}

	public Iterator<V> values() {
		ArrayList<V> list = new ArrayList<V>();
		for(int i = 0; i < table.length; i++){
			for(int k = 0; k < table[i].size(); k++){
				if(table[i].get(k).value != null){
					list.add(table[i].get(k).value);
				}
			}
		}
		return list.iterator();
	}
    
    public static void main(String[] args) {
        HashtableOH<String,String> table = new HashtableOH<String,String>(4);
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
        table.list();
        
        System.out.println("Test av get-metoden: ");
        System.out.println(table.get("hus"));
        
        System.out.println("Test av remove-metoden: ");
        System.out.println(table.remove("hus"));
        table.list();
        System.out.println(table.remove("Laserturken"));
        
        System.out.println("Test av containsKey-metoden: ");
        System.out.println(table.containsKey("hus"));
        System.out.println(table.containsKey("grön"));
        
        System.out.println("Test av clear-metoden: ");
        table.clear();
        table.list();


    }
}
