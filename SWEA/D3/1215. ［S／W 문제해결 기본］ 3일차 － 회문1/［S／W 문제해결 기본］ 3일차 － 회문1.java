import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			// 행렬입력
			String[][] board = new String[8][8];
			int wordLen = Integer.parseInt(br.readLine());
			for(int i=0; i<8; i++) {
				board[i] = br.readLine().split("");
			}
			// 전치행렬 만들기
			String[][] transBoard = new String[8][8];
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					transBoard[i][j] = board[j][i];
				}
			}
			int count = 0;
			for(int i=0; i<8; i++) {
				for(int j=0; j<8-wordLen+1; j++) {
					String[] word1 = Arrays.copyOfRange(board[i], j, j+wordLen);
					String[] word2 = Arrays.copyOfRange(transBoard[i], j, j+wordLen);
					int round = 0;
					for(int k=0; k<wordLen/2; k++) {
						round++;
						if(!word1[k].equals(word1[wordLen-k-1])){
							round = 0;
							break;
						}
						if(round == wordLen/2) {
							count++;
							round = 0;
						}
						
					}
					for(int k=0; k<wordLen/2; k++) {
						round++;
						if(!word2[k].equals(word2[wordLen-k-1])){
							round = 0;
							break;
						}
						if(round == wordLen/2) {
							count++;
						}
						
					}
				}
			}
			sb.append(String.format("#%d %d\n", t, count));
		}
		bw.write(sb.toString());
		bw.close();
	}
}