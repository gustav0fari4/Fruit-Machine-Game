package Griffith;

import java.util.Random;
import java.util.Scanner;

public class FruitMachine {

	//Starting credits
	private static int credits = 100;
	//Credits required to play the game
	private static final int costPerGame = 10;
	//Multi-player for winning combinations
	private static final int winMultiplier = 2;
	//5% chance for special win
	private static final double specialWinChance = 0.05;
	
	public static void main(String[]args) {
		/*
		 * This is the main method that runs the game
		 * It uses a Scanner to get input from the user
		 * It presents a menu to the user and repeatedly asks for their choice until they choose to exit.
		 * Depending on the user's choice, it calls different methods like 'playGame', 'displayRuleset', 'displayCredits', or 'buyCredits'
		 */
		
		Scanner scan = new Scanner (System.in);
		
		while (true) {
			displayMenu();
			int choice = getValidInput(scan,1,5);
			switch (choice) {
			case 1:
				playGame(scan);
				break;
			case 2:
				displayRuleset();
				break;
			case 3:
				displayCredits();
				break;
			case 4:
				buyCredits(scan);
				break;
			case 5:
				System.out.println("Thanks for playing! Goodbye.");
				System.exit(0);
				break;	}	}	}

	private static void displayMenu() {
		//This method displays the menu, which includes options for playing a new game, viewing rules, checking credits, buying credits, or exiting the game. 
		System.out.println("******************************");
		System.out.println("*********Grand Casino*********");
		System.out.println("1. Play a new game");
		System.out.println("2. See ruleset");
		System.out.println("3. See remaining credits");
		System.out.println("4. Buy credits");
		System.out.println("5. Exit");
		System.out.println("******************************");
		System.out.println("Enter your choice: ");	}
	
	private static int getValidInput(Scanner scan, int min, int max) {
		//This method ensures that user input is valid and within a specified range.
		//Method applied to the methods: chooseDifficulty , displayMenu and buyCredits.
		int input;
		while(true) {
			try {
				input = Integer.parseInt(scan.nextLine());
				if (input >= min && input <= max) {
					return input; }
				else {
					System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ":");	}	}
			catch (NumberFormatException e) {
				System.out.println("Invalid input. Please");	}	}	}
	
	private static int chooseDifficulty(Scanner scan) {
		//This method allows the user to choose the difficulty level of the game (Easy, Medium, Hard)
		System.out.println("=== Choose Difficulty ===");
		System.out.println("1. Easy (x1)");
		System.out.println("2. Medium (x2)");
		System.out.println("3. Hard (x3)");
		System.out.println("Enter difficulty level: ");
		return getValidInput(scan,1,3);		}
	
	private static char[]spinWheels(){
		//This method simulates the spinning of the wheels on the slot machine. It generates three random numbers representing symbols on the wheels
		Random rdm = new Random();
		char[]symbols = {'?', '$', '%', '&', '7', '#'};
		char[]result = new char [3];	
		for (int i = 0; i < 3; i++) {
			result[i] = symbols[rdm.nextInt(symbols.length)];	}
		return result; 		}
	
	private static void displaySlotMachine(char[]result) {
		//This method get ASCII art to enhance the user interface when they got the spin done
		System.out.println("=== Spin Result ===");
		System.out.println("  _______     _______     _______ ");
		System.out.println(" |       |   |       |   |       |");
        System.out.println(" |   " + result[0] + "   |   |   " + result[1] + "   |   |   " + result[2] + "   |");
        System.out.println(" |_______|   |_______|   |_______|"); 	}
	
	private static int calculateWinnings(char[] result, int difficulty) {
		//This method calculates the winning based on the spin result (matching symbols)
		//All symbols match
		if (result[0] == result[1] && result [1] == result[2]) {
			if(result[0] =='7' && Math.random()<specialWinChance) {
				System.out.println("Congratulations!!!! Special Win: 1,000 Euros!!!!");
				System.exit(0);		}
			return winMultiplier * 150 * difficulty;	}
		//Two symbols match
		else if (result[0] == result[1] || result[1] == result[2] || result[0] == result[2]) {
			return winMultiplier * 50 * difficulty;		}
		//No match
		return 0;	}
	
	private static void playGame(Scanner scan) {
		/*
		 * This method handles the logic for playing the game
		 * It gets the user-selected difficulty level, checks if the player has enough credits, deducts the cost
		 * of the game, spins the wheels, calculate winnings and updates the credits
		 */
		int difficulty = chooseDifficulty(scan);
		//If credits is not enough to play the game ends.
		if(credits < costPerGame * difficulty) {
			System.out.println("Game over! You don't have enough credits to play.");
			System.exit(0);		}
		//Cost is deducted by the chosen difficulty
		credits -= costPerGame * difficulty;
		//Spin the wheels
		char[]result = spinWheels();
		displaySlotMachine(result);
		//Calculate winnings
		int winnings = calculateWinnings(result,difficulty);
		//Updated the credits
		credits += winnings;
		System.out.println("Credits won " + winnings);
		System.out.println("Remaining credits " + credits); 	}
	
	private static void displayRuleset() {
		//This method displays the rule-set, explaining the different pay-out scenarios for the game
		System.out.println("=== Ruleset ===");
		System.out.println("Match 3 symbols, including '7' (with 5% chance): 1,000 Euros");
		System.out.println("Match 3 symbols: 150 credits");
		System.out.println("Match 2 symbols: 50 credits");
		System.out.println("No match: 0 credits"); 		}
	
	private static void displayCredits() {
		//This method displays the remaining credits
		System.out.println("=== Credits ===");
		System.out.println("Remaining credits: " + credits); 	}

	private static void buyCredits(Scanner scan) {
		//This method allow the user to buy additional credits
		System.out.println("=== Buy credits ===");
		System.out.println("Enter the number of credits to buy: ");
		int purchasedCredits = getValidInput(scan,1,1000);
		credits += purchasedCredits;
		System.out.println("You've successfully bought " + purchasedCredits + " credits.");
		System.out.println("Total credits: " + credits); 	}
	
}