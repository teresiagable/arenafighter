package se.lexicon.teresia.arena_fighter;

import java.util.Scanner;

public class ArenaFighterTheGame {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Fighter myFighter = new Fighter();
		System.out.println("This is your fighter: ");
		System.out.println(myFighter.getFullName() + " " + myFighter.getAge() + " years");
		System.out.println("health: " + myFighter.getHealthPoints());
		System.out.println("strength: " + myFighter.getStrenght());

		do {
			Fighter myOpponent = new Fighter();
			System.out.println("This is your opponent: ");
			System.out.println(myOpponent.getFullName() + " " + myFighter.getAge() + " years");
			System.out.println("health: " + myOpponent.getHealthPoints());
			System.out.println("strength: " + myOpponent.getStrenght());

			while (myFighter.isAlive()&&myOpponent.isAlive()) {
				Battle theBattle = new Battle(myFighter, myOpponent);
				while (myFighter.isAlive() && myOpponent.isAlive()) {
					/*  start fight loop until fighter1 or2 is dead fighter */
					int hitValue = myFighter.doHit();
					myOpponent.takeHit(hitValue);
					Round newRound = new Round(myFighter, myOpponent, hitValue, myOpponent.getHealthPoints(),
							myOpponent.getStrenght(), myOpponent.isAlive());
					theBattle.AddRound(newRound);
					if (myOpponent.isAlive()) {
						// opponent returns a strike
						hitValue = myOpponent.doHit();
						myFighter.takeHit(hitValue);
						Round newRound2 = new Round(myOpponent, myFighter, hitValue, myFighter.getHealthPoints(),
								myOpponent.getStrenght(), myFighter.isAlive());
						theBattle.AddRound(newRound2);
					}
				}
				theBattle.printData();
				
				myFighter=theBattle.ageUpgradeAndReset();
			}
		} while (continuePlay(3)); 
	}

	private static boolean continuePlay(int i) {
		String questionString;
		switch (i) {
		case 1:
			questionString = "Do you want to play ?";
			break;
		case 2:
			questionString = "Do you want to play against this fighter or retire?";
			break;
		case 3:
			questionString = "Do you want to continue fight with the winner?";
			break;
		default:
			questionString = "Do you want to continue fight with the winner?";
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
