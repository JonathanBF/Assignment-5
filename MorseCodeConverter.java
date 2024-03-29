public class MorseCodeConverter {
	// Class Variables
	protected static MorseCodeTree tree = new MorseCodeTree();

	/**
	 * Convert String Morse Code Into English
	 * 
	 * @param String encoded input
	 * @return String decoded output
	 * @throws None
	 */
	public static String convertToEnglish(String input) {
		// Variables
		String result = "";
		String[] words = input.split(" / ");

		// Loops
		for (String word : words) {
			// Variables
			String[] letters = word.split(" ");

			// Loops
			for (String letter : letters) {
				result += MorseCodeConverter.tree.fetch(letter);
			}

			result += " ";
		}

		// Return
		return result.trim();
	}

	public static String convertToEnglish(java.io.File file) throws java.io.FileNotFoundException {
		// Checks
		if (file == null) {
			throw new java.io.FileNotFoundException("File provided was null");
		}

		// Variables
		java.util.ArrayList<String> lines = new java.util.ArrayList<String>();
		java.util.Scanner scanner = new java.util.Scanner(file);
		String result = "";

		// Loops
		while (scanner.hasNext()) {
			lines.add(scanner.nextLine());
		}
		for (int i = 0; i < lines.size(); i++) {
			result += MorseCodeConverter.convertToEnglish(lines.get(i));
		}

		// Return
		scanner.close();
		return result.trim();
	}

	/**
	 * Print A Previously Generated MorseCodeTree
	 * 
	 * @return String tree
	 * @throws None
	 */
	public static String printTree() {
		// Checks
		if (tree == null) {
			return "";
		}

		// Variables
		java.util.ArrayList<String> list = tree.toArrayList();
		String result = "";

		// Loop
		for (String letter : list) {
			result += letter + " ";
		}

		// Return
		return result.trim();
	}
}