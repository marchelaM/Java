package dictionaries;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * This class demonstrates using of TreeMap class.
 * 
 * In a given text to find different words and count how many time we can find them in text
 */


public class FindDifferentWordsAndCount {
	
	
	private static final String TEXT = "Test text words Count " + "words count teSt";

	public static void main(String[] args) {
		
		Map<String, Integer> wordsCounts = createWordsCounts(TEXT);
		
		for (Map.Entry<String, Integer> wordsEntry : wordsCounts.entrySet()) {
			
			System.out.printf("words '%s' is been %d times in the text\n", wordsEntry.getKey(), wordsEntry.getValue());
		}
		

	}

	private static Map<String, Integer> createWordsCounts(String text2) {
		
		Scanner textScanner = new Scanner(text2);
		
		//we use comparator because we don't want words to be case sensitive
		Comparator<String> caseInsensitiveComparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareToIgnoreCase(o2);
			}
		};
		
		Map<String, Integer> words = new TreeMap<String, Integer>(caseInsensitiveComparator);
		
		while (textScanner.hasNext()) {
			
			String word = textScanner.next();
			Integer count = words.get(word);
			
			if (count == null) {
				
				count = 0;
			}
			words.put(word, count + 1);
		}
		
		return words;
	}

	
}
