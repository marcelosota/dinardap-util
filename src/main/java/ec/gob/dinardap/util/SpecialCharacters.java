package ec.gob.dinardap.util;

public class SpecialCharacters {

	public static String replaceWithSymbolAndUpperCase(String text, char symbol) {

		text = text.toUpperCase();

		// A con tilde
		text = text.replace('\u00C1', symbol);
		// E con tilde
		text = text.replace('\u00C9', symbol);
		// I con tilde
		text = text.replace('\u00CD', symbol);
		// O con tilde
		text = text.replace('\u00D3', symbol);
		// U con tilde
		text = text.replace('\u00DA', symbol);
		return text;

	}

	public static String replaceAcutesAndUpperCase(String text) {

		text = text.toUpperCase();

		// A con tilde
		text = text.replace('\u00C1', 'A');
		// E con tilde
		text = text.replace('\u00C9', 'E');
		// I con tilde
		text = text.replace('\u00CD', 'I');
		// O con tilde
		text = text.replace('\u00D3', 'O');
		// U con tilde
		text = text.replace('\u00DA', 'U');
		return text;

	}

}
