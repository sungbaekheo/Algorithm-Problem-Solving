import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] order;
	static boolean[] visited;
	static int answer;
	static int[][] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			N = sc.nextInt();
			order = new int[N+2][2];
			visited = new boolean[N+2];
			result = new int[N+2][2];
			answer = Integer.MAX_VALUE;
			order[0][0] = result[0][0] = sc.nextInt();
			order[0][1] = result[0][1] = sc.nextInt();
			order[N+1][0] = result[N+1][0] = sc.nextInt();
			order[N+1][1] = result[N+1][1] = sc.nextInt();
			
			for(int i=1; i<=N; i++) {
				order[i][0] = sc.nextInt();
				order[i][1] = sc.nextInt();
			}

			perm(1);
			System.out.println("#"+t+" "+answer);
		}
	}
	
	public static void visit() {
		int tmp = 0;
		for(int i=1; i<N+2; i++) {
			tmp+=Math.abs(result[i-1][0]-result[i][0])+Math.abs(result[i-1][1]-result[i][1]);
			if(tmp>=answer) {
				return;
			}
		}
		answer = tmp;
	}
	
	public static void perm(int idx) {
		if(idx == N+1) {
			visit();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) {
				continue;
			}
			result[idx] = order[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
	}
}