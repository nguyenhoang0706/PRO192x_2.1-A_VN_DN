import java.util.Scanner;

public class GradeStudent {
	public static int totalAllWeight = 0;

	public static void main(String[] args) {
		begin();
		double totalweightmidterm = midTerm();
		double totalweightfinalterm = finalTerm();
		double weightscore = homeWork();
		report(totalweightmidterm, totalweightfinalterm, weightscore);
	}

//	welcome to program
	public static void begin() {
		System.out.println("This program reads exam/homework scores and reports your overall course grade.");
	}

//	input midTerm
	public static double midTerm() {
		Scanner sc = new Scanner(System.in);
//	started midterm
		System.out.println("Midterm:");
//  input weight
		int weightinput;
		do {
			System.out.print("Weight (0-100)? ");
			weightinput = sc.nextInt();
		} while (weightinput <= 0 || weightinput >= 100);
		totalAllWeight += weightinput;
//  input score earned		
		int scoreinput;
		System.out.print("Score earned? ");
		scoreinput = sc.nextInt();
//  input shiftamount
		int scoreshifted;
		int shiftamount = 0;

		do {
			System.out.print("Were scores shifted (1=yes, 2=no)? ");
			scoreshifted = sc.nextInt();
		} while (scoreshifted < 1 || scoreshifted > 2);

		if (scoreshifted == 1) {
			System.out.print("Shift amount? ");
			shiftamount = sc.nextInt();
		}
		if (scoreshifted == 2) {
			shiftamount = 0;
		}

		int totalpoint = (scoreinput + shiftamount);
		if (totalpoint > 100) {
			totalpoint = 100;
		}
//  sysout total
		double totalweightmidterm = Math.round((((double) totalpoint / 100) * weightinput) * 10.0) / 10.0;
		System.out.println("Total points = " + totalpoint + " / 100");
		System.out.println("Weighted score = " + totalweightmidterm + " / " + weightinput);
		return totalweightmidterm;
	}

// input finalTerm
	public static double finalTerm() {
		Scanner sc = new Scanner(System.in);
// started finalterm
		System.out.println("Final:");
		int weightinput;
// input weight		
		do {
			System.out.print("Weight (0-100)? ");
			weightinput = sc.nextInt();
		} while (weightinput <= 0 || weightinput >= 100 || totalAllWeight + weightinput >= 100);
		totalAllWeight += weightinput;
// input score earned		
		int scoreinput;
		System.out.print("Score earned? ");
		scoreinput = sc.nextInt();
// input shiftamount
		int scoreshifted;
		int shiftamount = 0;
		do {
			System.out.print("Were scores shifted (1=yes, 2=0)? ");
			scoreshifted = sc.nextInt();
		} while (scoreshifted < 1 || scoreshifted > 2);

		if (scoreshifted == 1) {
			System.out.print("Shift amount? ");
			shiftamount = sc.nextInt();
		}
		if (scoreshifted == 2) {
			shiftamount = 0;
		}
		int testScore = scoreinput + shiftamount;
		if (testScore > 100) {
			testScore = 100;
		}
// sysout total
		System.out.println("Total points = " + testScore + " / 100");
		double totalweightfinalterm = Math.round((((double) testScore / 100) * weightinput) * 10.0) / 10.0;
		System.out.println("Weight score = " + totalweightfinalterm + " / " + weightinput);
		return totalweightfinalterm;
	}

// input homework
	public static double homeWork() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Homework:");
// input weight		
		int weightinput;
		do {
			System.out.print("Weight (0-100)? ");
			weightinput = sc.nextInt();
		} while (totalAllWeight + weightinput != 100);
// input assigment	
		int assigmentinput;
		System.out.print("Number of assigments? ");
		assigmentinput = sc.nextInt();
		int scorereal;
		int scoresum;
		int scorerealtong = 0;
		int scoresumtong = 0;
		for (int i = 1; i <= assigmentinput; i++) {
			System.out.print("Assigment " + i + " score and max? ");
			scorereal = sc.nextInt();
			scoresum = sc.nextInt();
			scorerealtong += scorereal;
			if (scorerealtong > 150) {
				scorerealtong = 150;
			}
			scoresumtong += scoresum;
		}
// input section attend
		int attendinput;
		System.out.print("How many sections did you attend? ");
		attendinput = sc.nextInt();
		int sectionpoint = attendinput * 5 <= 30 ? attendinput * 5 : 30;
		System.out.println("Section points = " + sectionpoint + " / 30");
// sysout total
		int totalpoint = scorerealtong + sectionpoint;
		int totalscoresum = scoresumtong + 30;
		System.out.println("Total points = " + totalpoint + " / " + totalscoresum);
		double weightscore = Math.round(((double) totalpoint / totalscoresum) * weightinput * 10.0) / 10.0;
		System.out.println("Weight score = " + weightscore + " / " + weightinput);
		return weightscore;
	}

// GPA report
	public static double report(double totalweightmidterm, double totalweightfinalterm, double weightscore) {
		double totalallweight = totalweightmidterm + totalweightfinalterm + weightscore;
		double GPA = 0.0;
		System.out.println("Overall percentage = " + totalallweight);
		if (totalallweight >= 85) {
			GPA = 3.0;
		}
		if (totalallweight >= 75 && totalallweight <= 84.99) {
			GPA = 2.0;
		}
		if (totalallweight >= 60 && totalallweight <= 74.99) {
			GPA = 0.7;
		}
		if (totalallweight < 60) {
			GPA = 0.0;
		}
		System.out.println("Your grade will be at least: " + GPA);
		System.out.println("<< your custom grade message here >>");
		return GPA;
	}

}
