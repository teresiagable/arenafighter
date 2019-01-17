package se.lexicon.teresia.arena_fighter;

import java.util.Scanner;

import Utils.HelpMe;

public class ArenaFighterTheGame {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		Fighter myFighter = null;

		do {
			myFighter = new Fighter();
			System.out.println("This is your fighter: ");
			System.out.println(myFighter.toString());
		} while (!HelpMe.readYesNoFromUser("Do you want to fight or get a new fighter ? (n for new)"));

		do {
			Fighter myOpponent = new Fighter();
			System.out.println("This is your opponent: ");
			System.out.println(myOpponent.toString());

			Battle theBattle = new Battle(myFighter, myOpponent);
			myFighter = theBattle.startFight();
			theBattle.printDataSlow();

			myFighter.printNewValues();

			if (myFighter.getAge() >= Fighter.theRetirementAge) {
				System.out.println(myFighter.getFullName() + " is to old to fight. He is limping away in the sunset.");
				break;
			}
		} while (HelpMe.readYesNoFromUser("Do you want to continue fight with the winner?"));
		System.out.println("The Arena closed");
	}



//	private static void printFighterData(Fighter myFighter) {
//		System.out.println(myFighter.getFullName() + " " + myFighter.getAge() + " years");
//		System.out.println("health: " + myFighter.getHealthPoints());
//		System.out.println("strength: " + myFighter.getStrenght());
//	}

//	private static boolean continuePlay(String questionString){
//		
//		switch (i) {
//		case 1:
//			questionString = "Do you want to fight or get a new fighter ?";
//			break;
//		case 2:
//			questionString = "Do you want to play against this fighter or retire?";
//			break;
//		case 3:
//			questionString = "Do you want to continue fight with the winner?";
//			break;
//		default:
//			questionString = "What?";
//			break;
//		}
//		System.out.println(questionString);
//		String input = scanner.nextLine();
//		boolean returnValue = true;
//		switch (input) {
//		case "Y":
//		case "y":
//			returnValue = true;
//			break;
//		case "N":
//		case "n":
//			returnValue = false;
//			break;
//		default:
//			System.out.println("I'll take that as a YES");
//			returnValue = true;
//			break;
//		}
//		return returnValue;
//	}

}
