package eg.edu.alexu.csd.datastructure.linkedList.cs31_cs60;

import java.awt.Point;
import java.util.Scanner;

/**.
 * main
 * @author EL-hamd
 *
 */
public class MainLinkedList {

	/**
	 * Instance of the solver class.
	 */
	static Polynomial app = new Polynomial();

	/**
	 * Adds polynomials.
	 */
	private static void addP() {
		System.out.println("Insert" +
	"the first operand variable name" +
				" : A, B or C.");
		final char poly1 = MainLinkedList.readChoice();
		System.out.println("Insert " +
		"the first operand variable name" +
				" : A, B or C.");
		final char poly2 = MainLinkedList.readChoice();
		try {
			MainLinkedList.app.add(poly1, poly2);
			System.out.println("The " +
			"result set in R : " +
					MainLinkedList.app.print('R'));
		} catch (final RuntimeException eAdd) {
			System.out.println(eAdd.getMessage());
		}
	}

	/**
	 * Clears a polynomial.
	 */
	private static void clearP() {
		System.out.println("Select the " +
	"polynomial you want to clear" +
				" : A, B or C.");
		final char polyClear = MainLinkedList.readChoice();
		try {
			MainLinkedList.app.clearPolynomial(polyClear);
			System.out.println("Polynomial " +
			polyClear +
			" is cleared.");
		} catch (final RuntimeException eClear) {
			System.out.println(eClear.getMessage());
		}
	}

	/**
	 * Evaluates a polynomial.
	 */
	private static void evaluateP() {
		System.out.println("Select the " +
	"polynomial you want to evaluate" +
				" : A, B or C.");
		final char polyEval = MainLinkedList.readChoice();
		System.out.println("Enter the value for x.");
		final Scanner valueInput = new Scanner(System.in);
		final int x = valueInput.nextInt();
		try {
			final float evaluated =
					MainLinkedList.app.evaluatePolynomial
					(polyEval, x);
			System.out.println("The evaluated value is : " +
					evaluated);
		} catch (final RuntimeException eEvaluated) {
			System.out.println(eEvaluated.getMessage());
		}
	}

	/**
	 * Gets the terms in the form of a 2D array.
	 *
	 * @param variable
	 *            input
	 * @return the 2D array.
	 */
	private static int[][] getTerms(final char variable) {
		int termCounter = 0; // Counts terms.
		final Linked_List termList = new Linked_List();

		int inputCoeff;
		int inputExp;
		System.out.println(
				"Insert the polynomial terms in " +
		"the form :\n(coeff1 , exponent1)," +
						" (coeff2 , exponent2), ..");

		final Scanner input = new Scanner(System.in);
		final String line = input.nextLine();

		System.out.println(line);

		final Scanner sc = new Scanner(line.toString());
		sc.useDelimiter(", |,| |\\(|\\)");

		while (sc.hasNext()) {
			String tmp = sc.next();
			if (!tmp.equals("")) {
				inputCoeff = Integer.parseInt(tmp);
				tmp = sc.next();
				inputExp = Integer.parseInt(tmp);
				termList.add(new Point(inputCoeff, inputExp));
				termCounter++;
			}
		}
		sc.close();

		if (termCounter == 0) {
			return null;
		}
		final int[][] terms = new int[termCounter][2];
		for (int i = 0; i < termCounter; i++) {
			terms[i][0] = ((Point) termList.get(i)).x;
			terms[i][1] = ((Point) termList.get(i)).y;
		}
		return terms;
	}

	/**
	 * Main menu choice.
	 */
	private static final int SET = 1;
	/**
	 * Main menu choice.
	 */
	private static final int PRINT = 2;
	/**
	 * Main menu choice.
	 */
	private static final int ADD = 3;
	/**
	 * Main menu choice.
	 */
	private static final int SUBTRACT = 4;
	/**
	 * Main menu choice.
	 */
	private static final int MULTIPLY = 5;
	/**
	 * Main menu choice.
	 */
	private static final int EVALUATE = 6;
	/**
	 * Main menu choice.
	 */
	private static final int CLEAR = 7;
	/**
	 * Main menu choice.
	 */
	private static final int EXIT = 8;

	/**
	 * Main method.
	 *
	 * @param args
	 *            main parameter.
	 */
	public static void main(final String[] args) {
		final Scanner input = new Scanner(System.in);
		int mainMenuChoice = 0;
		boolean running = true;
		while (running) {
			System.out.println("Please choose an action.");
			System.out.println("------------------------");
			System.out.println("1- Set a polynomial variable." +
			"\n2- Print the value of a polynomial variable."
					+ "\n3- Add two polynomials." +
			"\n4- Subtract two polynomials." +
					"\n5- Multiply two polynomials."
					+ "\n6- Evaluate a polynomial at some point." +
					"\n7- Clear a polynomial variable." + "\n8- Exit.");
			try {
				mainMenuChoice =
						Integer.parseInt(input.nextLine());
			} catch (final NumberFormatException e) {
				System.out.println("Wrong input. Try again.");
				continue;
			}

			switch (mainMenuChoice) {
			case SET:
				MainLinkedList.setP();
				break;
			case PRINT:
				MainLinkedList.printP();
				break;
			case ADD:
				MainLinkedList.addP();
				break;
			case SUBTRACT:
				MainLinkedList.subtractP();
				break;
			case MULTIPLY:
				MainLinkedList.multiplyP();
				break;
			case EVALUATE:
				MainLinkedList.evaluateP();
				break;
			case CLEAR:
				MainLinkedList.clearP();
				break;
			case EXIT:
				running = false;
				break;
			default:
				System.out.println("Wrong main menu input.");
			}
		}
		System.out.println("\nThank you for using our app !");
		input.close();
	}

	/**
	 * Multiplies polynomials.
	 */
	private static void multiplyP() {
		System.out.println("Insert the " +
	"first operand variable name" +
				" : A, B or C.");
		final char poly1 = MainLinkedList.readChoice();
		System.out.println("Insert the " +
		"first operand variable name" +
				" : A, B or C.");
		final char poly2 = MainLinkedList.readChoice();
		try {
			MainLinkedList.app.multiply(poly1, poly2);
			System.out.println("The result set in R : " +
			MainLinkedList.app.print('R'));
		} catch (final RuntimeException eAdd) {
			System.out.println(eAdd.getMessage());
		}
	}

	/**
	 * Prints polynomials.
	 */
	private static void printP() {
		System.out.println("Insert the " +
	"variable name " + ": A, B, C or R.");
		final char poly = MainLinkedList.readChoice();

		try {
			if (MainLinkedList.app.print(poly) == null) {
				System.out.println("Polynomial " +
			poly + " is empty.");
			} else {
				System.out.println
				(MainLinkedList.app.print(poly));
			}
		} catch (final RuntimeException ePrint) {
			System.out.println(ePrint.getMessage());
		}
	}

	/**
	 * Reads the input choice and handles input checking.
	 *
	 * @return character choice.
	 */
	private static char readChoice() {
		final Scanner input = new Scanner(System.in);
		if (input.hasNextLine()) {
			final String inputString = input.next();
			char variableChoice = inputString.charAt(0);
			variableChoice = Character.toUpperCase(variableChoice);
			return variableChoice;
		} else {
			return 'F';
		}

	}

	/**
	 * Sets a polynomial.
	 */
	public static void setP() {
		boolean success = false;
		// do {
		System.out.println("Insert the " +
		"variable name " +
				": A, B or C.");
		final char variableChoice = MainLinkedList.readChoice();
		final int[][] terms = MainLinkedList.getTerms(variableChoice);
		try {
			MainLinkedList.app.setPolynomial(variableChoice, terms);
			System.out.println("Polynomial " +
			variableChoice +
			"is set.");
			success = true;
		} catch (final RuntimeException eSet) {
			System.out.println(eSet.getMessage());
			success = false;
		}
		// } while (success == false);
	}

	/**
	 * Subtracts two polynomials.
	 */
	private static void subtractP() {
		System.out.println("Insert the " +
	"first operand variable name" +
				" : A, B or C.");
		final char poly1 = MainLinkedList.readChoice();
		System.out.println("Insert the" +
		" first operand variable name" +
				" : A, B or C.");
		final char poly2 = MainLinkedList.readChoice();
		try {
			MainLinkedList.app.subtract(poly1, poly2);
			System.out.println("The result set in R : " +
			MainLinkedList.app.print('R'));
		} catch (final RuntimeException eSubtract) {
			System.out.println(eSubtract.getMessage());
		}
	}

}
