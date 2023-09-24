import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Logic {
	public String encode(String plainText) {
		/*
		Choose any character in the reference table as the offset.
		The first character of the encoded message will be the
		offset character. Any character not in the reference table
		will mapped back to the same character.

		Reference table is from A to Z, 0 to 9, ()*+,-./ for a total of 44 characters

		*/

		String s1 = this.offset();
		String s2 = s1.concat(plainText); //concatenates offset character with plainText

		// from 1st index in the array, determine how many places to shift by, then replace all except 1st index

		//	mutable char array
		char[] plainTextCharArray = s2.toCharArray();
//		plainTextCharArray = this.algorithm(plainTextCharArray, "e");
		String encoded = new String(this.algorithm(plainTextCharArray, "e"));
		return encoded;
	}

	public String decode(String encodedText) {
		/*
		To decode it, you need to take the first character for
		offset and match it backwards to get the original
		plaintext.*/
		char[] encodedTextCharArray = encodedText.toCharArray();

		String decoded = new String(this.algorithm(encodedTextCharArray, "d"));
		return decoded;
	}

	private String offset() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter offset (A to Z, 0 to 9, ()*+,-./): ");

		String s = "";
		if (scan.hasNextLine()) {
			s = scan.next(); // scans only the next character entered
			scan.close();
		}

		char c = s.charAt(0); // new variable to get first character in case errant input
		s = String.valueOf(c);

		return s;
	}

	private char[] algorithm(char[] text, String encOrDec) {
		String alg = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
		char[] algArray = alg.toCharArray();
		int offInt = alg.indexOf(text[0]);

//		char[] text2 = new char[text.length];

		if (offInt != -1 && encOrDec.equals("e")) {
			// offset char is in alg
			// encode/decode by replacing characters in the `text` array
			// for each character in `text`,
			// if alg.indexOf(character) != -1,
			// character =  alg.indexOf(character) + offInt
			char[] text2 = new char[text.length];
			text2[0] = text[0];

			for (int i = 1; i < text.length; i++) {
				if (alg.indexOf(text[i]) != -1) {
					try {
						text2[i] = algArray[alg.indexOf(text[i]) - offInt];
					} catch (ArrayIndexOutOfBoundsException e) {
						text2[i] = algArray[alg.indexOf(text[i]) - offInt + 44];
					}
				} else {
					text2[i] = text[i];
				}
			}
			return text2;
		}
		else if (offInt != -1 && encOrDec.equals("d")) {
			char [] text2 = new char[text.length - 1];

			for (int i = 1; i < text.length; i++) {
				if (alg.indexOf(text[i]) != -1) {
					try {
						text2[i - 1] = algArray[alg.indexOf(text[i]) + offInt];
					} catch (ArrayIndexOutOfBoundsException e) {
						text2[i - 1] = algArray[alg.indexOf(text[i]) + offInt - 44];
					}
				} else {
					text2[i - 1] = text[i];
				}
			}
			return text2;
		} else {
			return text;
		}
	}
}
