package services;

import java.util.Scanner;

import Utils.HelpMe;
import se.lexicon.teresia.arena_fighter.Battle;
import se.lexicon.teresia.arena_fighter.Fighter;

public class BattleService {
	public static void start() {

		Fighter myFighter = null;
		do {

			do {
				myFighter = new Fighter();
				System.out.println();
				System.out.println("This is your fighter: \n" + myFighter.toString());

			} while (!HelpMe.readYesNoFromUser("Do you want to fight or get a new fighter ? (n for new)"));

			do {
				Fighter myOpponent = new Fighter();
				System.out.println("This is your opponent: \n" + myOpponent.toString());

				Battle theBattle = new Battle(myFighter, myOpponent);
				myFighter = theBattle.startFight();

				theBattle.printDataSlow(); // print one row each second for more excitement!
				myFighter.printNewValues(); // print the winners new health and strength values

				if (myFighter.isRetired())
					break;

			} while (HelpMe.readYesNoFromUser("Do you want to continue fight with the winner?"));

		} while (HelpMe.readYesNoFromUser("Play with a new fighter?"));

		System.out.println("The Arena closed");
	}
}
