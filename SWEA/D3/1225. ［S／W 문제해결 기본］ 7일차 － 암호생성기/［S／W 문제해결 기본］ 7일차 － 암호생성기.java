import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> password = new LinkedList<Integer>();
		
		for(int t=1; t<=10; t++) {
			int testCase = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<8; i++) {
				password.offer(Integer.parseInt(st.nextToken()));
			}
			main: while(true) {
				int cycle = 1;
				while(cycle<=5) {
					int digit = password.poll();
					digit-=cycle++;
					if(digit<=0) {
						password.offer(0);
						break main;
					}
					password.offer(digit);
				}
			}
			System.out.print("#"+testCase+" ");
			while(!password.isEmpty()) {
				System.out.print(password.poll()+" ");
			}
			System.out.println();
		}
	}
}