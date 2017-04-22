package part1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MostCommonValue {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		
		Map<Integer, Integer> numsCount = createNumsCount(line);
		
		for (Map.Entry<Integer, Integer> numEntry : numsCount.entrySet()) {
			
			System.out.printf("digit '%d' is been %d times in text\n", numEntry.getKey(), numEntry.getValue());
		}
		
		
	}

	private static Map<Integer, Integer> createNumsCount(String line) {
		
		Scanner inScanner = new Scanner(line);
		Map<Integer, Integer> numbers = new HashMap<>();
		
		while (inScanner.hasNextInt()) {
			
			int digit = inScanner.nextInt();
			Integer count = numbers.get(digit);
			
			if (count == null) {
				
				count = 0;
			}
			numbers.put(digit, count + 1);
		}
		
		return numbers;
	}

}
