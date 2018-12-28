package se.lexicon.teresia.arena_fighter;

public class Fighter {

	private String fullName;
	private int age;
	public static final int theRetirementAge = 50;
	private int healthPoints;
	private int strenght;
	private boolean alive = true;
	public static final double fatigueFactor = 0.75;  //strength is decreased by 75% on each hit
	public static final double hitFactor = 0.20;  //strength is decreased by 75% on each hit

	public Fighter(String fullName, int age, int healthPoints, int strenght) {

		this.fullName = fullName;
		this.age = age;
		this.healthPoints = healthPoints;
		this.strenght = strenght;
	}

	public String getFullName() {
		return fullName;
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
		if (this.healthPoints >= hitValue) {
			//the fighter died 
			this.alive = false;			
		}
		else {
			//the fighter survived but loses health and strength
			this.healthPoints-=hitValue;
			this.strenght = (int)Math.round(this.strenght*fatigueFactor);
		}
		return alive;
	}
	
	public int doHit()
	{
		//calculate a hitValue from this fighter
		return (int) Math.round((healthPoints+strenght)/2 * hitFactor);
	}
	
	
	
}
