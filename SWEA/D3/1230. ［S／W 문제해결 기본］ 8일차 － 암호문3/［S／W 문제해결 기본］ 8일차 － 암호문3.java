import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> li = new LinkedList<>();
		
		for(int t=1; t<=10; t++) {
			int len = sc.nextInt();
			for(int i=0; i<len; i++) {
				li.add(sc.nextInt());
			}
			int num = sc.nextInt();
			for(int i=0; i<num; i++) {
				String o = sc.next();
				int idx;
				int r;
				switch(o) {
					case "I": 
						idx = sc.nextInt();
						r = sc.nextInt();
						for(int j=0; j<r; j++) {
							li.add(idx+j, sc.nextInt());
						}
						break;
					case "D": 
						idx = sc.nextInt();
						int dNum = sc.nextInt();
						for(int j=0; j<dNum; j++) {
							li.remove(idx+j);
						}
						break;
					case "A": 
						r = sc.nextInt();
						for(int j=0; j<r; j++) {
							li.add(sc.nextInt());
						}
						break;
				}
			}
			sb.append("#"+t+" ");
			for(int i=0; i<10; i++) {
				sb.append(li.pollFirst()+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}