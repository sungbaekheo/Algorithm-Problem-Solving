import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				int input = Integer.parseInt(st.nextToken());
				dp[i][j] = input + Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
			}
		}
		
		int answer = dp[N][0];
		for(int i=1; i<3; i++) {
			answer = Math.min(dp[N][i], answer);
		}
		
		System.out.println(answer);
	}
}