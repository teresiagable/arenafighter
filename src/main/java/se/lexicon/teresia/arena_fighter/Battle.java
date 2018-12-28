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
		this.rounds = Arrays.copyOf(this.rounds, this.rounds.length + 1); // add one round for the new data
		System.arraycopy(newRound, 0, this.rounds, this.rounds.length - 1, 1);// add round to Battle.rounds
	}
	// PrintBattleLog(){}

}
