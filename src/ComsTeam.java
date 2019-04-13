import java.awt.Color;

import javax.swing.JButton;

//Peter
public class ComsTeam extends StateButton implements Tile {
	
	public ComsTeam(Country c) {
		super(c);
	}

	public void pressed() {
		this.setBackground(Color.BLACK);
	}
	
}
