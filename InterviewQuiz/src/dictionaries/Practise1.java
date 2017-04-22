package dictionaries;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class Practise1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		
		Map<Integer, Integer> numsCount = createNumsCount(line);
		
		for (Entry<Integer, Integer> numsEntry : numsCount.entrySet()) {
			
			System.out.printf("number %d is %d times in the line\n", numsEntry.getKey(), numsEntry.getValue());
		}
	}

	private static Map<Integer, Integer> createNumsCount(String line) {
		
		Scanner inScanner = new Scanner(line);
		
		Map<Integer, Integer> numbers = new HashMap<>();
		
		while (inScanner.hasNext()) {
			
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
