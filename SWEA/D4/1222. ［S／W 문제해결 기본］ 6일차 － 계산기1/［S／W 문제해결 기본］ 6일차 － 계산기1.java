import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> numbers = new Stack<>();
		Stack<Character> operators = new Stack<>();
		
		for(int t=1; t<=10; t++) {
			int len = sc.nextInt();
			String str = sc.next();
			String trans = "";
			for(int i=0; i<len; i++) {
				char c = str.charAt(i);
				if(c >= 48 && c <= 57) {
					trans+=c;
				} else {
					while(!operators.isEmpty()) {
						trans+=operators.pop();
					}
					operators.push(c);
				}
			}
			while(!operators.isEmpty()) {
				trans+=operators.pop();
			}
			for(int i=0; i<trans.length(); i++) {
				char c = trans.charAt(i);
				if(c >= 48 && c <= 57) {
					numbers.push(c-'0');
				} else {
					int num2 = numbers.pop();
					int num1 = numbers.pop();
					numbers.push(num1+num2);
				}
			}
			System.out.println("#" + t+ " " + numbers.pop());
		}
	}
}