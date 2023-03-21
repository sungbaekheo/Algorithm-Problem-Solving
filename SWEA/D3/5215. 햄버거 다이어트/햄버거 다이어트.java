import java.util.Scanner;

public class Solution {
	static int N;
	static int max;
	static int[][] ingredients;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			
			N = sc.nextInt();
			max = sc.nextInt();
			ingredients = new int[N][2];
			for(int i=0; i<N; i++) {
				ingredients[i][0] = sc.nextInt();
				ingredients[i][1] = sc.nextInt();
			}
			int finalT = 0;
			for(int i=0; i<(1<<N); i++) {
				int taste = 0;
				int cal = 0;
				for(int j=0; j<N; j++) {
					if((i & 1<<j) > 0) {
						taste+=ingredients[j][0];
						cal+=ingredients[j][1];
					}
				}
				if(cal <= max) {
					finalT = finalT<taste? taste:finalT;
				}
			}
			
			System.out.println("#"+t+" "+finalT);
		}
	}
}