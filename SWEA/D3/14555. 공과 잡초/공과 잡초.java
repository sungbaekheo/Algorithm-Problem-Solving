import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			String str = sc.next();
			int count = 0;
			
			for(int i=0; i<str.length()-1; i++) {
				if(str.charAt(i) == '(' && (str.charAt(i+1) == ')' ||  str.charAt(i+1) == '|')) {
					count++;
				} else if(str.charAt(i) == '|' && str.charAt(i+1) == ')') {
					count++;
				}
			}
			System.out.println("#"+t+" "+count);
		}
	}
}
