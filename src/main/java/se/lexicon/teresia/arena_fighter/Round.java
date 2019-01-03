package se.lexicon.teresia.arena_fighter;

public class Round {

	public Fighter striker;
	public Fighter target;
	public int hitValue;
	public int targetHealth;
	public int targetStrength;
	public boolean targetSurvived;

	public Round(Fighter striker, Fighter target, int hitValue, int targetHealth, int targetStrength,
			boolean targetSurvived) {

		this.striker = striker; 
		this.target = target;
		this.hitValue = hitValue;
		this.targetHealth = targetHealth;
		this.targetStrength = targetStrength;
		this.targetSurvived = targetSurvived;
	}
}
