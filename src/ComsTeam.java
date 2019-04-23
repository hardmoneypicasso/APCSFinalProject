import java.awt.Color;
import java.io.IOException;

import javax.swing.JButton;

//Peter
public class ComsTeam extends StateButton implements Tile {
	
	private int countInd;
	
	public ComsTeam(Country c) {
		super(c);
	}

	public void pressed() {
		this.setBackground(Color.BLACK);
	}

	@Override
	public int getState(int i, int j) {
		return Graphics.getArraySpot(i, j);
	}

	@Override
	public int getNumberOf() {
		int count= 0;
		countInd= 0;
		for(int i= 0; i< 10; i++) {
			for(int j= 0; j< 10; j++) {
				int spot= this.getState(i, j);
				if(spot==1) {
					count++;
				}else if(spot== 0) {
					countInd++;
				}
			}
		}
		return count;
	}
	
	public void victoryState() throws IOException {
		Country result= Country.unknown;
		if(this.getNumberOf()== 100) {
			result= Country.Warring;
		}else if(this.getNumberOf() != 100 && OtherTeam.getPeace(countInd)) {
			result= Country.Peacful;
		}else if(Graphics.turnCount > 49) {
			result= Country.Loss;
		}else {
			result= Country.unknown;
		}
		
		if(!(result.equals(Country.unknown))) {
			endGame(result);
		}
	}
	
	public void endGame(Country result) throws IOException {
		if(result.equals(Country.Warring)) {
			Graphics.War();
		}else if(result.equals(Country.Peacful)) {
			Graphics.Peace();
		}else {
			Graphics.Loss();
		}
	}
	
}
