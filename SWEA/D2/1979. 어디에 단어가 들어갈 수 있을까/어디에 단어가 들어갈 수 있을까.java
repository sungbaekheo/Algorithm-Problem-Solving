import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int matrixSize = Integer.parseInt(st.nextToken());
			int wordLen = Integer.parseInt(st.nextToken());
			int count = 0;
			int[][] wordMatrix = new int[matrixSize][matrixSize];
			int[] colSum = new int[matrixSize];
			for(int i=0; i<matrixSize; i++) {
				st = new StringTokenizer(br.readLine());
				int blank = 0;
				for(int j=0; j<matrixSize; j++) {
					wordMatrix[i][j] = Integer.parseInt(st.nextToken());
					if(wordMatrix[i][j] == 1) {
						blank++;
						colSum[j]++;
					}
					if(blank == wordLen && (wordMatrix[i][j] == 0 || j == matrixSize-1)) {
						count++;
						blank = 0;
					}
					if(colSum[j] == wordLen && (wordMatrix[i][j] == 0 || i == matrixSize-1)) {
						count++;
						colSum[j] = 0;
					}
					if(wordMatrix[i][j] == 0) {
						blank = 0;
						colSum[j] = 0;
					}
				}
			}
			bw.write(String.format("#%d %d\n", t, count));
		}
		bw.close();
	}
}