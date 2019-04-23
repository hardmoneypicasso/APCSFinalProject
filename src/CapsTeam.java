import java.awt.Color;

//Cesar
public class CapsTeam extends StateButton implements Tile {

	public CapsTeam(Country c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pressed() {
		// TODO Auto-generated method stub
		double ran= Math.random()*100;
		if(ran>50) {
			this.setBackground(Color.RED);
		}
	}

	@Override
	public int getState(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

}
