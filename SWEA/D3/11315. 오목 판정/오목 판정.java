import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			int size = sc.nextInt();
			String[][] board = new String[size][size];
			for(int i=0; i<size; i++) {
				board[i] = sc.next().split("");
			}
			
			int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
			int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
			String answer = "NO";
			main: for(int r=0; r<size; r++) {
				for(int c=0; c<size; c++) {
					for(int d=0; d<8; d++) {
						int nr = r;
						int nc = c;
						int sum = 0;
						while(nr>=0 && nr<size && nc>=0 && nc<size) {
							if(board[nr][nc].equals("o")) {
								sum++;
							} else {
								sum = 0;
							}
							nr+=dr[d];
							nc+=dc[d];
							if(sum == 5) {
								answer = "YES";
								break main;
							}
						}
					}
				}
			}
			System.out.printf("#%d %s\n", t, answer);
		}
	}
}