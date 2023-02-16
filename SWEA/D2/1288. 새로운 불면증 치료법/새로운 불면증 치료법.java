import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			int[] numList = new int[10];
			int count = 1;
			String input = sc.next();
			boolean isFull = false;
			while(!isFull) {
				String xinput = String.valueOf(Integer.parseInt(input)*count);
				for(int i=0;  i<xinput.length(); i++) {
					numList[Character.getNumericValue(xinput.charAt(i))]++;
				}
				for(int i:numList) {
					if(i == 0) {
						isFull = false;
						count++;
						break;
					} else {
						isFull = true;
					}
				}
			}
			System.out.printf("#%d %d\n", t, Integer.parseInt(input)*count);
		}	
	}
}
