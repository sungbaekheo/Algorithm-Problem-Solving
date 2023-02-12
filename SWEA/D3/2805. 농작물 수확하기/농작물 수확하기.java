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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testCase; t++) {
			int size = Integer.parseInt(br.readLine());
			int[][] farm = new int[size][size];
			
			// 밭에 농작물 입력하기
			for(int i=0; i<size; i++) {
				String str = br.readLine();
				for(int j=0; j<size; j++) {
					farm[i][j] = Character.getNumericValue(str.charAt(j));
				}
			}
			
			// 밭의 중간 지점
			int mid = size/2;
			int total = 0;
			// 마름모꼴 출력하기와 똑같은 방법으로 마름모에 해당하는
			// 부분만 선택해서 총합 값에 넣어주기
			for(int i=0; i<size; i++) {
				int d = Math.abs(mid-i);
				for(int j=d; j<=size-Math.abs(mid-i)-1; j++) {
					total+=farm[i][j];
				}
			}
			sb.append(String.format("#%d %d\n", t, total));
		}
		bw.write(sb.toString());
		bw.close();
	}
}