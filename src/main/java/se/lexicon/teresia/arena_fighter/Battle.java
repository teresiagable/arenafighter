package se.lexicon.teresia.arena_fighter;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Battle {
	public Fighter myFighter;
	public Fighter theOpponent;
	public Round[] rounds = new Round[0];

	/**
	 * @param player1 is first fighter
	 * @param player2 is the opponent fighter
	 */
	public Battle(Fighter player1, Fighter player2) {
		this.myFighter = player1;
		this.theOpponent = player2;
	}
	
	/**
	 * @return the winning fighter
	 */
	public Fighter startFight() {
		while (myFighter.isAlive() && theOpponent.isAlive()) {
			battleStrike(myFighter, theOpponent);

			if (theOpponent.isAlive()) {
				// opponent returns a strike
				battleStrike(theOpponent, myFighter);
			}
		}
		return Fighter.ageUpgradeAndReset(myFighter, theOpponent);
	}

	/**
	 * @param theStriker = the fighter who strikes
	 * @param theVictim  = the fighter who take the hit
	 */
	private void battleStrike(Fighter theStriker, Fighter theVictim) {
		
		int hitValue = theStriker.doHit();
		theVictim.takeHit(hitValue);
		
		Round newRound = new Round(theStriker, theVictim, hitValue, theVictim.getHealthPoints(),
				theVictim.getStrenght(), theVictim.isAlive());
		AddRound(newRound);
	}

	/**
	 * @param newRound = round with data
	 */
	public void AddRound(Round newRound) {
		this.rounds = Arrays.copyOf(this.rounds, this.rounds.length + 1); // create one round for the new data
		this.rounds[this.rounds.length - 1] = newRound;
	}

	public void printDataSlow() {
		
		System.out.println(
				"Arena fight between " + this.myFighter.getFullName() + " and " + this.theOpponent.getFullName());
		
		for (Round round : rounds) {
			System.out.println(
					round.striker.getFullName() + " hits " + round.target.getFullName() + " for " + round.hitValue
							+ " hp. " + round.target.getFullName() + " is down to " + round.targetHealth + " hp");

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(round.targetSurvived ? "" : round.target.getFullName() + " died.");
		}
	}

	public void printData() {
		System.out.println(
				"Arena fight between " + this.myFighter.getFullName() + " and " + this.theOpponent.getFullName());
		System.out.print(this.myFighter.getFullName() + "\t|");
		for (int i = 1; i < rounds.length; i = i + 2) {
			System.out.print(rounds[i].targetHealth + "|");
		}
		System.out.println("");
		System.out.print(this.theOpponent.getFullName() + "\t|");
		for (int i = 0; i < rounds.length; i = i + 2) {
			System.out.print(rounds[i].targetHealth + "|");
		}
		System.out.println("\n" + rounds[rounds.length - 1].striker.getFullName() + " won the fight!");
	}

}
