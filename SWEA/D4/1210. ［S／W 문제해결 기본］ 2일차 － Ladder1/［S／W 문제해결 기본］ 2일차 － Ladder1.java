import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			int testCase = Integer.parseInt(br.readLine());
			int[][] map = new int[100][100];
			int startPoint = 0;
			int endPoint = 0;
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						startPoint = j;
					}
				}
			}
			endPoint = laddering(map, startPoint);
			sb.append(String.format("#%d %d\n", testCase, endPoint));
		}
		bw.write(sb.toString());
		bw.close();
	}
	
	static int laddering(int[][] map, int startY) {
		int[] dc = {-1, 1};
		int pointX = 99;
		int pointY = startY;
		while(pointX>0) {
			for(int i=0; i<2; i++) {
				int dj = pointY+dc[i];
				if(dj>=0 && dj<100 && map[pointX][dj] == 1) {
					while(map[pointX-1][dj] != 1) {
						dj += dc[i];
					}
					pointY = dj;
					break;
				}
			}
			pointX--;
		}
		return pointY;
	}
}