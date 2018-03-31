package p2;
import java.util.*;

/**
 * Klassen representerar en graf
 * @author tsroax
 *
 * @param <T> Nodens typ i grafen
 */
public class Graph<T> {
    private HashMap<T, ArrayList<Edge<T>>> graph = new HashMap<T, ArrayList<Edge<T>>>();

    /**
     * L�gger till en nod i grafen.
     * @param vertex
     */
    public void addVertex(T vertex) {
        graph.put(vertex, new ArrayList<Edge<T>>());
    }

    /**
     * L�gger till en nod, och nodens n�rliggande grannar, i grafen.
     * @param vertex nod som l�ggs till i grafen
     * @param adjacentList lista med nodens n�rliggande grannar
     */
    public void addVertex(T vertex, ArrayList<Edge<T>> adjacentList) {
        if (adjacentList != null && !graph.containsKey(vertex)) {
            graph.put(vertex, adjacentList);
        }
    }

    /**
     * L�gger till en b�ge i grafen.
     * @param from nod d�r b�gen startar
     * @param to nod till vilken b�gen leder
     * @param weight b�gens vikt/kostnad
     * @return true om b�gen l�ggs till i grafen, annars false
     */
    public boolean addEdge(T from, T to, int weight) {
        ArrayList<Edge<T>> adjacentList;
        Edge<T> edge;
        int index;
        boolean res = graph.containsKey(from) && graph.containsKey(to);
        if (res) {
            adjacentList = graph.get(from);
            edge = new Edge<T>(from, to, weight);
            index = adjacentList.indexOf(edge);
            if (index >= 0) {
                adjacentList.set(index, edge);
            } else {
                adjacentList.add(edge);
            }
        }
        return res;
    }

    /**
     * Tar bort en nod ur grafen.
     * @param vertex nod som ska tas bort
     * @return nodens n�rliggande grannar om noden tas bort, annars null
     */
    public ArrayList<Edge<T>> removeVertex(T vertex) {
        return graph.remove(vertex);
    }

    /**
     * Tar bort en b�ge ur grafen.
     * @param from startnod f�r b�gen
     * @param to nod dit b�gen leder
     * @return true om b�gen tas bort och annars false
     */
    public boolean removeEdge(T from, T to) {
        ArrayList<Edge<T>> adjacentList = graph.get(from);
        if (adjacentList != null) {
            return adjacentList.remove(new Edge<T>(from, to, 0));
        }

        return false;
    }

    /**
     * Returnerar en lista �ver n�rliggande grannar till argumentet <code>vertex<\code>
     * @param vertex nod till vilken lista �ver n�rliggande grannar returneras
     * @return lista med n�rliggande grannar
     */
    public ArrayList<Edge<T>> getAdjacentList(T vertex) {
        return graph.get(vertex);
    }

    /**
     * Returnerar true om en nod finns i grafen och annars false-
     * @param vertex nod som s�ks i grafen
     * @return true om noden finns i grafen, annars false
     */
    public boolean containsVertex(T vertex) {
        return graph.containsKey(vertex);
    }

    /**
     * Returnerar referens till Edge-objekt med start i from och slut i to.
     * Om s�dan inte finns returneras null.
     * 
     * @param from nod d�r b�gen startar
     * @param to nod d�r b�gen slutar
     * @return referens till Edge-objektet om det finns, annars null
     */
    public Edge<T> getEdge(T from, T to) {
        ArrayList<Edge<T>> adjacentList = graph.get(from);
        Edge<T> edge = null;
        int index = -1;
        if (adjacentList != null) {
            index = adjacentList.indexOf(new Edge<T>(from, to, 0));
            if (index != -1) {
                edge = adjacentList.get(index);
            }
        }
        return edge;
    }
    
    public Iterator<Edge<T>> iterator() {
    	ArrayList<Edge<T>> list = new ArrayList<Edge<T>>();
    	Iterator<ArrayList<Edge<T>>> iter = graph.values().iterator();
    	while(iter.hasNext()) {
    		list.addAll(iter.next());
    	}
    	return list.iterator();
    }

    public void shuffleEdges() {
        Iterator<T> keys = graph.keySet().iterator();
        Object key;
        while (keys.hasNext()) {
            key = keys.next();
            Collections.shuffle(graph.get(key));
        }
    }

    /**
     * 
     */
    public void printGraph() {
        Iterator<T> vertices = graph.keySet().iterator();
        T vertex;
        while (vertices.hasNext()) {
            System.out.println("-----------------------------------------------");
            vertex = vertices.next();
            System.out.println(vertex);
            for (Edge edge : graph.get(vertex))
                System.out.println("   " + edge);
            System.out.println("-----------------------------------------------");
        }
    }
}
