package p2;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class Viewer extends JPanel {
	JComboBox<String> from = new JComboBox<String>(P2Controller.toArray(P2Controller.readPlaces("files/places.txt")));
	JComboBox<String> to = new JComboBox<String>(P2Controller.toArray(P2Controller.readPlaces("files/places.txt")));
	JTextArea txtArea = new JTextArea();
	JButton btnSearch = new JButton("Sök");
	JRadioButton btnDepth = new JRadioButton("Sökning på djupet", true);
	JRadioButton btnBreadth = new JRadioButton("Sökning på bredden", false);
	JRadioButton btnDijkstra = new JRadioButton("Dijkstra", false);
	JPanel pnlMap = new JPanel();
	JPanel southPanel = new JPanel();
	JPanel radioPanel = new JPanel();
	JTabbedPane tabbedPane = new JTabbedPane();
	JLabel lblFrom = new JLabel("Från");
	JLabel lblTo = new JLabel("Till");
	ButtonGroup bGroup = new ButtonGroup();

	public Viewer(MapView map) {
		setLayout(new BorderLayout());
		tabbedPane.add("Karta", pnlMap);
		tabbedPane.add("Text", txtArea);
		pnlMap.add(map, BorderLayout.CENTER);
		add(tabbedPane, BorderLayout.CENTER);

		// Sökalternativ
		radioPanel.setLayout(new GridLayout(3, 1));
		radioPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Sökalternativ"));
		radioPanel.add(btnDepth);
		radioPanel.add(btnBreadth);
		radioPanel.add(btnDijkstra);
		
		southPanel.setLayout(new MigLayout());
		southPanel.add(lblFrom);
		southPanel.add(from, "width 500!, wrap");
		southPanel.add(radioPanel, "east, gapx 5, wrap");
		southPanel.add(lblTo);
		southPanel.add(to, "width 500!, wrap");
		southPanel.add(btnSearch, "span, south, width 530!");
		
		add(southPanel, BorderLayout.SOUTH);

		bGroup.add(btnDepth);
		bGroup.add(btnBreadth);
		bGroup.add(btnDijkstra);

	}

}
