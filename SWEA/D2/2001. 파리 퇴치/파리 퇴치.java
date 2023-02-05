import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	
		int testCase = Integer.parseInt(br.readLine()); 
	
		for(int t=1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int matrixSize = Integer.parseInt(st.nextToken());
			int flyChaeSize = Integer.parseInt(st.nextToken());
			int[][] matrix = new int[matrixSize][matrixSize]; 
	
			for(int r=0; r<matrixSize; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<matrixSize; c++) {
					matrix[r][c] = Integer.parseInt(st.nextToken());
				}
			} 
	
			int max = 0;
			for(int r=0; r<matrixSize-(flyChaeSize-1); r++) {
				for(int c=0; c<matrixSize-(flyChaeSize-1); c++) {
					int sum = 0; 
					for(int dr=0; dr<flyChaeSize; dr++) {
						for(int dc=0; dc<flyChaeSize; dc++) {
							sum+=matrix[r+dr][c+dc];
						}
					}
					if(sum>max) {
						max = sum;
					}
				}
			}
			bw.write("#"+t+" "+max+"\n");
		}
		bw.close();
	}
}