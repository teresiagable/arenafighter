package se.lexicon.teresia.arena_fighter;

import java.util.Arrays;

public class Battle {
	public Fighter player1;
	public Fighter player2;
	public Round[] rounds = new Round[0];

	public Battle(Fighter player1, Fighter player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void AddRound(Round newRound) {
		this.rounds = Arrays.copyOf(this.rounds, this.rounds.length + 1); // create one round for the new data
		this.rounds[this.rounds.length - 1] = newRound;
		// System.arraycopy(newRound, 0, this.rounds, this.rounds.length - 1, 1);// add
		// round to Battle.rounds
	}

	// PrintBattleLog(){}
//
	public void printData2() {
		System.out.println("Arena fight between " + this.player1.getFullName() + " and " + this.player2.getFullName());
		for (Round round : rounds) {
			System.out.println(
					round.striker.getFullName() + " hits " + round.target.getFullName() + " for " + round.hitValue
							+ " health points down to:\t " + round.targetHealth + " hp and " + round.targetStrength);
			// System.out.println(round.target);
			System.out.print(round.targetSurvived ? "" : round.target.getFullName() + " died");
		}
	}

	public void printData3() {
		System.out.println("Arena fight between " + this.player1.getFullName() + " and " + this.player2.getFullName());
		for (Round round : rounds) {
			System.out.println(
					round.striker.getFullName() + " hits for " + round.hitValue + " and " + round.target.getFullName()
							+ " is down to:\t " + round.targetHealth + " hp and " + round.targetStrength + " str");
			// System.out.println(round.target);
			System.out.print(round.targetSurvived ? "" : round.target.getFullName() + " died");
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
	
	public Fighter ageUpgradeAndReset() {
		Fighter winner = rounds[rounds.length-1].striker;
		Fighter loser = rounds[rounds.length-1].target;
		winner.addAge(1);
		winner.upgradeStartHealthPoints(loser.getStartHealthPoints() * 0.3);
		winner.setHealthPoints(winner.getStartHealthPoints());
		winner.upgradeStartStrength(loser.getStartStrength() * 0.3);
		winner.setStrenght(winner.getStartStrength());
		
		return winner;
	}

}
