package for_flynn_test;

import java.util.HashSet;

public class test {

	public static void main(String[] args) {
		testing();

	}
	
	public static void testing() {
		int array[] = {90, 300, 600, 400, 100, 200};
		HashSet<Integer> set = new HashSet<>();
		int minNumber = array[0];
		int maxNumber = array[0];
		
		for(int i = 0; i < array.length; i++) {
			set.add(array[i]);
			
			if(array[i] < minNumber && array[i] > 0) {
				minNumber = array[i];
			}
			
			if(array[i] > maxNumber && array[i] > 0) {
				maxNumber = array[i];
			}
		}
		
		System.out.println("Min number is: " + minNumber);
		System.out.println("Max number is: " + maxNumber);
		
		int lowestNumberFound = 0;
		
		for(int i = minNumber; i <= maxNumber; i++) {
			if(!set.contains(i)) {
				lowestNumberFound = i;
				break;
			}
		}
		
	}

}