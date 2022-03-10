package Assigment1;

import java.util.Scanner;

public class LuckyNumber {
	public static int totalGame = 0;
	public static int totalGuesses = 0;
	public static int bestGame = 0;

	public static void main(String[] args) {
		checkPoint();

	}

	public static int randomLuckyNumber(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}

	public static void checkPoint() {
		totalGame++;
		System.out.println("I'm thinking of a number between 0 and 100...");
		Scanner sc = new Scanner(System.in);
		int input = -1;
		int luckyNumber = randomLuckyNumber(0, 100);
		int a = 0;

		while (input != luckyNumber) {
			System.out.print("Your guess? ");
			input = sc.nextInt();
			if (input < luckyNumber) {
				System.out.println("It's higher.");
			} 
			if(input > luckyNumber){
				System.out.println("It's lower.");
			}
			a++;

		}
		if (totalGame == 1) {
			bestGame = a;
		}
		totalGuesses += a;
		System.out.println("You got it right in " + a + " guesses!");

		System.out.print("do you want to play againt? ");
		String answers = sc.next();

		if (answers.equalsIgnoreCase("yes") || answers.equalsIgnoreCase("y")) {

			checkPoint();

		} else {
			System.out.println("Overall result:");
			System.out.println("Total games   = " + totalGame);
			System.out.println("Total guesses = " + totalGuesses);
			System.out.println("Guesses/game  = " + (double) totalGuesses / totalGame);
			if (a < bestGame) {
				bestGame = a;

			}
			System.out.println("Best game     = " + bestGame);

		}
	}

}
