import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {  
		
		Scanner kb= new Scanner(System.in);
		
		boolean turnChoice= true;
		char move= 'S';
		char compMove='S';
		String message= "WHAT HAPPENED";
		String win= "You win!";
		String loss= "You lose!";
		
		while(turnChoice) {
			System.out.println("make a move (S= shoot, B= block, R= reload).");
			move= kb.next().charAt(0);
			//cool cats were here!
			if(compMove != 'R') {
				int chance= (int) (Math.random()*2);
				if(chance== 0) {
					compMove= 'B';
				}else {
					compMove= 'S';
				}
			}
			
			if(compMove== 'R' && move== 'S') {
				turnChoice= false;
				message= win;
			} else if((compMove== 'R' && move== 'B') || (compMove== 'R' && move== 'R')) {
				turnChoice= true;
				message= "tie, keeping going!";
			}else if(compMove=='B' && move== 'S') {
				turnChoice= true;
				message= "Shot was blocked!";
			}else if(compMove== 'B' && (move== 'R' || move== 'B')) {
				turnChoice= true;
				message= "tie, keeping going!";
			}else if(compMove== 'S' && move== 'R') {
				turnChoice= false;
				message= loss;
			}else if(compMove== 'S' && move== 'B') {
				turnChoice= true;
				message= "Shot was blocked!";
			}else if(compMove== 'S' && move== 'S') {
				message= "You both Died!!!! :D";
				turnChoice= false;
			}
			System.out.println(message);
		}
		System.out.println("GAME OVER!");
	}
}
