import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=1; t<=testCase; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] counter = new int[n+m+1];
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					counter[i+j]++;
				}
			}
			int max = 0;
			for(int i:counter) {
				if(i > max) {
					max = i;
				}
			}
			System.out.print("#"+t+" ");
			for(int i=0; i<counter.length; i++) {
				if(counter[i] == max) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
	}
}