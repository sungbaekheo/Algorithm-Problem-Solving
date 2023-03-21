import java.util.Scanner;

public class Solution {
	static int N;
	static int K;
	static int count = 0;
	static int[] seq;
	static boolean[] selected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			count = 0;
			N = sc.nextInt();
			K = sc.nextInt();
			seq = new int[N];
			selected = new boolean[N];
			for(int i=0; i<N; i++) {
				seq[i] = sc.nextInt();
			}
			powerset(0);
			System.out.println("#"+t+" "+count);
		}
	}
	
	static void powerset(int idx) {
		if(idx == N) {
			int temp = 0;
			for(int i=0; i<N; i++) {
				if(selected[i]) {
					temp+=seq[i];
				}
			}
			if(temp == K) {
				count++;
			}
			return;
		}
		
		selected[idx] = true;
		powerset(idx+1);
		selected[idx] = false;
		powerset(idx+1);
	}
}