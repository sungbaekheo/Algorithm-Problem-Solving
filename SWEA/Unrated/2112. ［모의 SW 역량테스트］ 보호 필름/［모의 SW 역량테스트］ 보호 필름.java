import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int row;
	static int col;
	static int K;
	static int[][] film;
	static int chemicals;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[row][col];
			chemicals = Integer.MAX_VALUE;
			for(int r=0; r<row; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<col; c++) {
					film[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(!check()) {
				test(0,0);
			} else {
				chemicals = 0;
			}
			
			sb.append("#"+t+" "+chemicals+"\n");

		}
		bw.write(sb.toString());
		bw.close();
	}
	
	public static void test(int r, int cnt) {
		if(check()) {
			chemicals = chemicals<cnt? chemicals:cnt;
			return;
		}
		
		if(r >= row) {
			return;
		}
		
		test(r+1, cnt);
		
		int[] temp = new int[col];
		for(int i=0; i<col; i++) {
			temp[i] = film[r][i];
		}
		
		for(int i=0; i<col; i++) {
			film[r][i] = 0;
		}
		test(r+1, cnt+1);

		for(int i=0; i<col; i++) {
			film[r][i] = 1;
		}
		test(r+1, cnt+1);
		
		for(int i=0; i<col; i++) {
			film[r][i] = temp[i];
		}	
	}
	
	public static boolean check() {
		for(int j=0; j<col; j++) {
			int count = 1;
			for(int i=1; i<row; i++) {
				if(film[i][j] == film[i-1][j]) {
					count++;
				} else {
					count = 1;
				}
				if(count==K) {
					break;
				}
			}
			if(count != K) {
				return false;
			}
		}
		return true;
	}
}