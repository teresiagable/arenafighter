package se.lexicon.teresia.arena_fighter;

import java.util.Scanner;

public class ArenaFighterTheGame {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Fighter myFighter = null;

		do {
			myFighter = new Fighter();
			System.out.println("This is your fighter: ");
			printFighterData(myFighter);
		} while (!continuePlay(1));

		do {
			Fighter myOpponent = new Fighter();
			System.out.println("This is your opponent: ");
			printFighterData(myOpponent);

			Battle theBattle = new Battle(myFighter, myOpponent);

			while (myFighter.isAlive() && myOpponent.isAlive()) {
				fight(theBattle, myFighter, myOpponent);

				if (myOpponent.isAlive()) {
					// opponent returns a strike
					fight(theBattle, myOpponent, myFighter);
				}
			}
			theBattle.printDataSlow();

			myFighter = Fighter.ageUpgradeAndReset(myFighter, myOpponent);
			myFighter.printNewValues();

			if (myFighter.getAge() >= Fighter.theRetirementAge) {
				System.out.println(myFighter.getFullName() + " is to old to fight. He is limping away in the sunset.");
				break;
			}
		} while (continuePlay(3));
	}

	/**
	 * @param theBattle  = the battle to save data in
	 * @param myFighter  = the fighter who strikes
	 * @param myOpponent = the fighter who take the hit
	 */
	private static void fight(Battle theBattle, Fighter theFighter, Fighter theOpponent) {
		int hitValue = theFighter.doHit();
		theOpponent.takeHit(hitValue);
		Round newRound = new Round(theFighter, theOpponent, hitValue, theOpponent.getHealthPoints(),
				theOpponent.getStrenght(), theOpponent.isAlive());
		theBattle.AddRound(newRound);

	}

	private static void printFighterData(Fighter myFighter) {
		System.out.println(myFighter.getFullName() + " " + myFighter.getAge() + " years");
		System.out.println("health: " + myFighter.getHealthPoints());
		System.out.println("strength: " + myFighter.getStrenght());
	}

	private static boolean continuePlay(int i) {
		String questionString;
		switch (i) {
		case 1:
			questionString = "Do you want to fight or get a new fighter ?";
			break;
		case 2:
			questionString = "Do you want to play against this fighter or retire?";
			break;
		case 3:
			questionString = "Do you want to continue fight with the winner?";
			break;
		default:
			questionString = "What?";
			break;
		}
		System.out.println(questionString);
		String input = scanner.nextLine();
		boolean returnValue = true;
		switch (input) {
		case "Y":
		case "y":
			returnValue = true;
			break;
		case "N":
		case "n":
			returnValue = false;
			break;
		default:
			System.out.println("I'll take that as a YES");
			returnValue = true;
			break;
		}
		return returnValue;
	}

}
