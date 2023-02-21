import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Map<Character, Integer> priority = new HashMap<Character, Integer>();
		priority.put('(', 4);
		priority.put('^', 3);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('+', 1);
		priority.put('-', 1);
		
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
					if(c == ')') {
						while(!operators.isEmpty() && operators.peek() != '(') {
							trans+= operators.pop();
						}
						operators.pop();
					} else {
						while(!operators.isEmpty() && (priority.get(operators.peek()) >= priority.get(c)) && operators.peek() != '(') {
							trans+= operators.pop();
						}
						operators.push(c);
					}
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
					switch(c) {
						case '+': numbers.push(num1+num2); break;
						case '-': numbers.push(num1-num2); break;
						case '*': numbers.push(num1*num2); break;
						case '/': numbers.push(num1/num2); break;
						case '^': numbers.push((int) Math.pow(num1, num2)); break;
					}
				}
			}
			System.out.println("#" + t+ " " + numbers.pop());
		}
	}
}