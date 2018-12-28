package se.lexicon.teresia.arena_fighter;

public class Round {
	

	public Fighter striker;
	public Fighter target;
	public int hitValue;
	public int targetHealth;
	public boolean targetSurvived;
	
	public Round(Fighter player1, Fighter player2, Fighter striker, Fighter target, int hitValue, int targetHealth,
			boolean targetSurvived) {

		this.player1 = player1;
		this.player2 = player2;
		this.striker = striker;
		this.target = target;
		this.hitValue = hitValue;
		this.targetHealth = targetHealth;
		this.targetSurvived = targetSurvived;
	}
	
	
	

}
