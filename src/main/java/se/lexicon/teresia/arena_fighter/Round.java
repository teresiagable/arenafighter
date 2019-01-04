package se.lexicon.teresia.arena_fighter;

public class Round {

	public Fighter striker;
	public Fighter target;
	public int hitValue;
	public int targetHealth;
	public int targetStrength;
	public boolean targetSurvived;

	/**
	 * @param striker = fighter who strikes
	 * @param target = fighter who take hit
	 * @param hitValue = int value from doHit() 
	 * @param targetHealth = targets health after takeHit()
	 * @param targetStrength = targetStrength after takeHit()
	 * @param targetSurvived = boolean isAlive after taking the hit
	 */
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
