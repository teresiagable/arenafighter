package se.lexicon.teresia.arena_fighter;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class Battle {
	public Fighter player1;
	public Fighter player2;
	public Round[] rounds = new Round[0];

	/**
	 * @param player1 is first fighter
	 * @param player2 is the opponent fighter
	 */
	public Battle(Fighter player1, Fighter player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	/**
	 * @param newRound = round with data
	 */
	public void AddRound(Round newRound) {
		this.rounds = Arrays.copyOf(this.rounds, this.rounds.length + 1); // create one round for the new data
		this.rounds[this.rounds.length - 1] = newRound;
		// System.arraycopy(newRound, 0, this.rounds, this.rounds.length - 1, 1);// add
		// round to Battle.rounds
	}

	// PrintBattleLog(){}
//
	public void printDataSlow() {
		System.out.println("Arena fight between " + this.player1.getFullName() + " and " + this.player2.getFullName());
		for (Round round : rounds) {
			System.out.println(
					round.striker.getFullName() + " hits " + round.target.getFullName() + " for " + round.hitValue
							+ " hp. "+round.target.getFullName()+ " is down to " + round.targetHealth + " hp");
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(round.targetSurvived ? "" : round.target.getFullName() + " died.");
			
		}
	}



	public void printData() {
		System.out.println("Arena fight between " + this.player1.getFullName() + " and " + this.player2.getFullName());
		System.out.print(this.player1.getFullName() +"\t|");
		for (int i = 1; i < rounds.length; i=i+2) {
			System.out.print(rounds[i].targetHealth +"|");
		}
		System.out.println("");
		System.out.print(this.player2.getFullName() +"\t|");
		for (int i = 0; i < rounds.length; i=i+2) {
			System.out.print(rounds[i].targetHealth +"|");
		}	
		System.out.println("\n"+ rounds[rounds.length-1].striker.getFullName() + " won the fight!");	
	}
	
	
}
