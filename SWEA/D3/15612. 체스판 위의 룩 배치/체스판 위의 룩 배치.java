import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testCase; t++) {
			// 체스판 만들고 룩 위치 입력받기
			String[][] board = new String[8][8];
			for(int i=0; i<8; i++) {
				board[i] = br.readLine().split("");
			}
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			
			String answer = "no";
			boolean isTrue = true;
			int rook = 0;
			main: for(int r=0; r<8; r++) {
				for(int c=0; c<8; c++) {
					if(board[r][c].equals("O")) {
						rook++;
					}
					for(int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						while(nr>=0 && nr<8 && nc>=0 && nc<8) {
							if(board[r][c].equals("O") && board[nr][nc].equals("O")) {
								isTrue = false;
								break main;
							}
							nr+=dr[d];
							nc+=dc[d];
						}
					}
				}
			}
			if(isTrue && rook==8) {
				answer="yes";
			}
			sb.append(String.format("#%d %s\n", t, answer));
		}
		bw.write(sb.toString());
		bw.close();
	}
}
