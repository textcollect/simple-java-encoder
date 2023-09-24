import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
	public static void main(String[] args) {
		// Press Alt+Enter with your caret at the highlighted text to see how
		// IntelliJ IDEA suggests fixing it.
		Logic l = new Logic();
		Scanner scan = new Scanner(System.in);

//		while-loop to repeat this code until correct input
		while (true) {
			System.out.println("Type 'e' to encode, 'd' to decode: ");
			String encORdec = scan.nextLine();

			if (encORdec.equalsIgnoreCase("e")) {
				String ptext = "";

//				try-catch block in case of errant input
				try {
					System.out.println("Type text to encode: ");
					ptext = scan.nextLine();
				} catch (Exception e) {
					System.out.println("Error. Invalid input. Try again.");
				}

				System.out.println(l.encode(ptext.toUpperCase()));
				scan.close();
				break;
			} else if (encORdec.equalsIgnoreCase("d")) {
				String etext = "";

//				try-catch block in case of errant input
				try {
					System.out.println("Type text to decode: ");
					etext = scan.nextLine();
				} catch (Exception e) {
					System.out.println("Error. Invalid input. Try again.");
				}

				System.out.println(l.decode(etext.toUpperCase()));
				scan.close();
				break;
			} else {
				System.out.println("Invalid input. Try again.");
			}
		}


//		System.out.printf("Hello and welcome!\n");

//		// Press Shift+F10 or click the green arrow button in the gutter to run the code.
//		for (int i = 1; i <= 5; i++) {
//
//			// Press Shift+F9 to start debugging your code. We have set one breakpoint
//			// for you, but you can always add more by pressing Ctrl+F8.
//			System.out.println("i = " + i);

	}
}

