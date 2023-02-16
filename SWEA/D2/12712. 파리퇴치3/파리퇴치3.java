import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int range = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[size][size];
			for(int i=0; i<size; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
			int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
			
			int max = 0;
			for(int r=0; r<size; r++) {
				for(int c=0; c<size; c++) {
					int pMax = map[r][c];
					for(int d=0; d<8; d++) {
						int nr = r;
						int nc = c;
						for(int i=1; i<range; i++) {
							nr+=dr[d];
							nc+=dc[d];
							if(nr>=0 && nr<size && nc>=0 && nc<size) {
								pMax+=map[nr][nc];
							}
						}
						if(d == 3) {
							if(pMax>max) {
								max = pMax;
							}
							pMax = map[r][c];
						}
					}
					if(pMax > max) {
						max = pMax;
					}
				}
			}
			sb.append(String.format("#%d %d\n", t, max));
		}
		bw.write(sb.toString());
		bw.close();
	}
}