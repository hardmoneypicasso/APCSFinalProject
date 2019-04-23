import java.awt.Color;

//Nick
public class OtherTeam extends StateButton implements Tile {

	private static int initialAmount= 0;
	
	public OtherTeam(Country c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pressed() {
		// TODO Auto-generated method stub
		this.setBackground(Color.RED);
	}

	@Override
	public int getState(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static int setInitial() {
		for(int i= 0; i< 10; i++) {
			for(int j= 0; j< 10; j++) {
				if(Graphics.getArraySpot(i, j) == 0) {
					initialAmount++;
				}
			}
		}
		return initialAmount;
	}
	
	public static boolean getPeace(int current) {
		return (current < initialAmount);
	}
	

}
