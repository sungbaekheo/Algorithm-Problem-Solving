import java.util.Arrays;
import java.util.Scanner;

/*
 * 서로 어울리지 않는 재료 고려 -> 재료쌍을 그래프로 표현
 * 정확하게 같은 종류의 재료들을 사용하면 같은 종류의 버거 -> 부분집합 구하기
 * 
 * N = 재료 종류 수
 * M = 궁합이 맞지 않는 재료쌍 수
 */

public class Solution {
	static int N;
	static int M;
	static int[] ingredients;
	static int[][] bulho;
	static boolean[] selected;
	static int count;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			count = 0;
			
			ingredients = new int[N+1];
			for(int i=1; i<=N; i++) {
				ingredients[i] = i;
			}
			
			bulho = new int[N+1][N+1];
			for(int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				bulho[a][b] = bulho[b][a] = 1;
			}
			
			selected = new boolean[N+1];
			
			powerset(1);
			
			System.out.println("#"+t+" "+count);
		}
	}
	
	public static void powerset(int idx) {
		
		if(idx == N+1) {
			count++;
			return;
		}
		
		boolean isAble = true;
		for(int i=1; i<=N; i++) {
			if(bulho[idx][i] == 1 && selected[i]) {
				isAble =false;
			}
		}
		if(isAble) {
			selected[idx] = true;
			powerset(idx+1);
		}
		selected[idx] = false;
		powerset(idx+1);
	}
	
}