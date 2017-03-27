import java.util.Arrays;
import java.util.List;

/**
 * The PigLatin class takes an english word or sentence and translates it to pig latin
 *
 * @author Loic Guegan
 * @since   2017-03-26
 */
public class PigLatin {

	static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
	static List<String> vowelExceptions = Arrays.asList("yt", "xr");

	public static String translate(String englishPhrase) {
		// Split sentence into array of words, spaces, and punctuation
		String[] splitPhrase = englishPhrase.split("(?<!^)\\b");
		StringBuilder pigLatinPhrase = new StringBuilder();
		for (int i = 0; i < splitPhrase.length; i++) {
			String word = splitPhrase[i];
			// Check if a word and not punctuation or space
			if ( Character.isLetter(word.charAt(0)) ) {
				splitPhrase[i] = translateWord(word);
			}
			pigLatinPhrase.append(splitPhrase[i]);
		}
		return pigLatinPhrase.toString();
	}

	private static String translateWord(String word) {
		if (vowels.contains(word.charAt(0)) || vowelExceptions.contains(word.substring(0,2))) {
			return word + "ay";
		} else {
			for (int i = 1; i < word.length(); i++) {
				// qu is treated like a consonant
				if (word.substring(i-1,i+1).equals("qu")) {
					return word.substring(i+1) + word.substring(0,i+1) + "ay";
				} else if (vowels.contains(word.charAt(i))) {
					return word.substring(i) + word.substring(0, i) + "ay";
				}
			}
		}
		return word;
	}
}