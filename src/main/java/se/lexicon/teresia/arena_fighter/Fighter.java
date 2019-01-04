package se.lexicon.teresia.arena_fighter;

import se.lexicon.erik.name_gen.RandomNameGenerator;
import se.lexicon.teresia.number_gen.RandomNumberGenerator;

public class Fighter {

	// static RandomNameGenerator rNameG = new RandomNameGenerator();
	
	private String fullName;
	private int age;
	public static final int theRetirementAge = 50;

	private int startHealthPoints;
	private int healthPoints;
	private int startStrength;
	private int strenght;
	private boolean alive = true;
	public static final double fatigueFactor = 0.95; // strength is decreased by % on each hit
	public static final double hitFactor = 0.30; // a nice number to create a hitvalue

	public Fighter(String fullName, int age, int healthPoints, int strenght) {

		this.fullName = fullName;
		this.age = age;
		this.healthPoints = healthPoints;
		this.strenght = strenght;
	}

	public Fighter() {

		this.fullName = RandomNameGenerator.getRandomFirstName();

		this.age = RandomNumberGenerator.getInstance().getRandomIntBetween(40, 45);
		this.startHealthPoints = RandomNumberGenerator.getInstance().getRandomIntBetween(1000, 2000);
		this.healthPoints = this.startHealthPoints;
		this.startStrength = RandomNumberGenerator.getInstance().getRandomIntBetween(1000, 2000);
		this.strenght = this.startStrength;
	}

	public String getFullName() {
		return fullName;
	}

	public int getStartStrength() {
		return startStrength;
	}

	public void setStartStrength(int startStrength) {
		this.startStrength = startStrength;
	}

	public void setStartHealthPoints(int startHealthPoints) {
		this.startHealthPoints += startHealthPoints;
	}

	public int getStartHealthPoints() {
		return startHealthPoints;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getStrenght() {
		return strenght;
	}

	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}

	public boolean isAlive() {
		return alive;
	}

	public boolean takeHit(int hitValue) {
		if (this.healthPoints <= hitValue) {
			// the fighter died
			this.alive = false;
			this.healthPoints = 0;
		} else {
			// the fighter survived but loses health and strength
			this.healthPoints -= hitValue;
			this.strenght = (int) Math.round(this.strenght * fatigueFactor);
		}
		return alive;
	}

	public int doHit() {
		// calculate a hitValue from this fighter
		
		int critFactor = RandomNumberGenerator.getInstance().getRandomIntBetween(1, 2);
		//double rbgDouble =RNGnum/(double)10;
		double hitValue = ((healthPoints + strenght)/ 2 * hitFactor * critFactor);
		return (int) Math.round(hitValue);
	}

	public void addAge(int i) {
		this.age += i;

	}

	public void upgradeStartHealthPoints(double opponentHealth) {
		this.startHealthPoints += (int) opponentHealth;

	}

	public void upgradeStartStrength(double opponentStrength) {
		this.startStrength += (int) opponentStrength;

	}

	public void printNewValues() {
		System.out.println(this.fullName + " has regained his health and upgraded his armor and weapon. ");
		System.out.println("His age are now " + this.age + ", healthpoints = " + this.startHealthPoints
				+ " and strength = " + this.startStrength);

	}

	public static Fighter ageUpgradeAndReset(Fighter myFighter, Fighter myOpponent) {

		Fighter winner = null;
		Fighter loser = null;
		
		if (myFighter.alive) {
			winner = myFighter;
			loser = myOpponent;
		} else {
			winner = myOpponent;
			loser = myFighter;
		}

		winner.addAge(1);
		winner.upgradeStartHealthPoints(loser.getStartHealthPoints() * (1-fatigueFactor));
		winner.setHealthPoints(winner.getStartHealthPoints());
		winner.upgradeStartStrength(loser.getStartStrength() * (1-fatigueFactor));
		winner.setStrenght(winner.getStartStrength());
		
		return winner;

	}

}
