import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static Map<Character, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		map.put('0', 0);
		map.put('1', 1);
		map.put('2', 2);
		map.put('3', 3);
		map.put('4', 4);
		map.put('5', 5);
		map.put('6', 6);
		map.put('7', 7);
		map.put('8', 8);
		map.put('9', 9);
		map.put('A', 10);
		map.put('B', 11);
		map.put('C', 12);
		map.put('D', 13);
		map.put('E', 14);
		map.put('F', 15);
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Deque<Character> dq = new LinkedList<>();
		Set<Integer> numSet = new HashSet<>();
		List<Integer> numList;
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			dq.clear();
			numSet.clear();
			int len = sc.nextInt();
			int order = sc.nextInt();
			char[] dial = sc.next().toCharArray();
			
			for(int i=0; i<dial.length; i++) {
				dq.add(dial[i]);
			}
			int nRotate = len/4;
			for(int i=0; i<=nRotate; i++) {
				if(i!=0) {
					dq.addFirst(dq.pollLast());
				}
				for(int j=0; j<4; j++) {
					String piece = "";
					for(int k=0; k<nRotate; k++) {
						char c = dq.poll();
						piece += String.valueOf(c);
						dq.add(c);
					}
					numSet.add(convertToDecimal(piece));
				}
			}
			numList = new ArrayList<>(numSet);
			numList.sort(Collections.reverseOrder());
			sb.append(String.format("#%d %d\n", t, numList.get(order-1)));
		}
		System.out.println(sb.toString());
	}
	
	static int convertToDecimal(String piece) {
		int number = 0;
		int temp = 0;
		for(int i=0; i<piece.length(); i++) {
			temp = map.get(piece.charAt(i));
			for(int j=0; j<piece.length()-1-i; j++) {
				temp*=16;
			}
			number+=temp;
		}
		return number;
	}
}