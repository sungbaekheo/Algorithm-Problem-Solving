import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][][] ladder = new int[N+1][3][2];
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) {
				int input = sc.nextInt();
				int min = ladder[i-1][j][0];
				int max = ladder[i-1][j][1];

				for(int k=-1; k<=1; k++) {
					if(j+k<0 || j+k>=3) {
						continue;
					}
					min = Math.min(min, ladder[i-1][j+k][0]);
					max = Math.max(max, ladder[i-1][j+k][1]);

					ladder[i][j][0] = min+input;
					ladder[i][j][1] = max+input;
				}
			}
		}
		
		int resMin = Integer.MAX_VALUE, resMax = Integer.MIN_VALUE;
		for(int i=0; i<3; i++){
			resMin = Math.min(resMin, ladder[N][i][0]);
			resMax = Math.max(resMax, ladder[N][i][1]); 
		}

		System.out.println(resMax+" "+resMin);
	}
}