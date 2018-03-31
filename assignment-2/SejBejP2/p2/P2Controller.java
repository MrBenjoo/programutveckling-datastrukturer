package p2;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import p2.Viewer;

public class P2Controller {
	private Graph<String> graph = new Graph<String>();
	private MapView map;
	private TreeMap<String, Road> roads;
	private Viewer viewer;

	public P2Controller(String mapFile, Position mapLeftUp, Position mapRightDown, String placeFile, String roadFile) {
		ArrayList<Place> places = P2Controller.readPlaces(placeFile);
		roads = P2Controller.readRoads(roadFile);
		ArrayList<Road> roadList = new ArrayList<Road>();
		Iterator<Road> values = roads.values().iterator();
		while (values.hasNext()) {
			roadList.add(values.next());
		}
		map = new MapView(mapFile, mapLeftUp.getLongitude(), mapLeftUp.getLatitude(), mapRightDown.getLongitude(), mapRightDown.getLatitude());
		viewer = new Viewer(map);
		initializeBtnListener();
		showMap();
		makeGraph(places, roads);
		graph.printGraph();
	}

	public static ArrayList<Place> readPlaces(String filename) {
		ArrayList<Place> places = new ArrayList<Place>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
			String[] parts;
			double longitude, latitude;
			String text = br.readLine();
			while (text != null) {
				parts = text.split(" ");
				longitude = Double.parseDouble(parts[2]);
				latitude = Double.parseDouble(parts[1]);
				places.add(new Place(parts[0], longitude, latitude));
				text = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return places;
	}

	public static TreeMap<String, Road> readRoads(String filename) {
		TreeMap<String, Road> res = new TreeMap<String, Road>();
		ArrayList<Position> path;
		String[] parts;
		String text;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
			text = br.readLine();
			while (text != null) {
				path = new ArrayList<Position>();
				parts = text.split(",");
				for (int i = 3; i < parts.length; i += 2) {
					path.add(new Position(Double.parseDouble(parts[i]), Double.parseDouble(parts[i + 1])));
				}
				int i = 0;
				res.put(parts[0] + "-" + parts[1], new Road(parts[0], parts[1], Integer.parseInt(parts[2]), path));
				text = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return res;
	}

	public void showMap() {
		JFrame frame = new JFrame();
		frame.setSize(700, 730);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(viewer);
		frame.setVisible(true);
	}

	public void makeGraph(ArrayList<Place> places, TreeMap<String, Road> roads) {
		Iterator<Road> values = roads.values().iterator();
		Road road;
		for (Place place : places) {
			graph.addVertex(place.getName());
		}
		while (values.hasNext()) {
			road = values.next();
			graph.addEdge(road.getFrom(), road.getTo(), road.getCost());
		}
	}

	public void depthSearch(String from, String to) {
		ArrayList<Edge<String>> path;
		ArrayList<Road> roadList = new ArrayList<Road>();
		String route = "";
		if (graph.containsVertex(from)) {
			path = GraphSearch.depthFirstSearch(graph, from, to);
			for (Edge<String> edge : path) {
				roadList.add(roads.get(edge.getFrom() + "-" + edge.getTo()));
				route += edge.getFrom() + " → " + edge.getTo() + ", cost " + edge.getWeight() + "\n" + "\n";
			}
			viewer.txtArea.setText(route);
		}
		map.showRoads(roadList);
	}

	public void breadthSearch(String from, String to) {
		ArrayList<Edge<String>> path;
		ArrayList<Road> roadList = new ArrayList<Road>();
		String route = "";
		if (graph.containsVertex(from)) {
			path = GraphSearch.breadthFirstSearch(graph, from, to);
			for (Edge<String> edge : path) {
				roadList.add(roads.get(edge.getFrom() + "-" + edge.getTo()));
				route += edge.getFrom() + " → " + edge.getTo() + ", cost " + edge.getWeight() + "\n" + "\n";
			}
			viewer.txtArea.setText(route);
		}
		map.showRoads(roadList);
	}

	public void dijsktraSearch(String from, String to) {
		ArrayList<Edge<String>> path;
		ArrayList<Road> roadList = new ArrayList<Road>();
		String route = "";
		if (graph.containsVertex(from)) {
			path = GraphSearch.dijkstraSearch(graph, from, to);
			for (Edge<String> edge : path) {
				roadList.add(roads.get(edge.getFrom() + "-" + edge.getTo()));
				route += edge.getFrom() + " → " + edge.getTo() + ", cost " + edge.getWeight() + "\n" + "\n";
			}
			viewer.txtArea.setText(route);
		}
		map.showRoads(roadList);
	}

	public static String[] toArray(ArrayList<Place> arrayList) {
		String[] places = new String[arrayList.size()];
		for (int i = 0; i < arrayList.size(); i++) {
			places[i] = arrayList.get(i).getName();
		}
		return places;
	}

	public void initializeBtnListener() {
		TheActionListener actionListener = new TheActionListener();
		viewer.btnDepth.addActionListener(actionListener);
		viewer.btnBreadth.addActionListener(actionListener);
		viewer.btnDijkstra.addActionListener(actionListener);
		viewer.btnSearch.addActionListener(actionListener);
		viewer.from.addActionListener(actionListener);
		viewer.to.addActionListener(actionListener);
	}

	private class TheActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String start = viewer.from.getSelectedItem().toString();
			String end = viewer.to.getSelectedItem().toString();
			if (e.getSource() == viewer.btnSearch) {
				if (viewer.btnDijkstra.isSelected()) {
					viewer.txtArea.setText(null);
					dijsktraSearch(start, end);
				} else if (viewer.btnDepth.isSelected()) {
					viewer.txtArea.setText(null);
					depthSearch(start, end);
				} else if (viewer.btnBreadth.isSelected()) {
					viewer.txtArea.setText(null);
					breadthSearch(start, end);
				}
			}
		}
	}

}
