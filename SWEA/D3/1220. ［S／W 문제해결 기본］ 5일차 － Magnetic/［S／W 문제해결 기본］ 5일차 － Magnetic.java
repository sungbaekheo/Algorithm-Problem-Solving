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
		
		for(int t=1; t<=10; t++) {
			// 100X100 테이블 생성
			int size = Integer.parseInt(br.readLine());
			int[][] table = new int[size][size];
			for(int r=0; r<size; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<size; c++) {
					table[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 교착상태 발생 수를 담기 위한 answer 변수
			int answer = 0;
			for(int i=0; i<size; i++) {
				// 교착상태를 파악하기 위한 스위치를 만든다.
				boolean swch = false;
				for(int j=0; j<size; j++) {
					int magnetic = table[j][i];
					// N극 자석이 나타나면 교착상태를 판단할 수 있는 상태로 들어감
					if(magnetic == 1) {
						swch = true;
					}
					// 스위치가 켜진 상태(N극 자석이 있는 상태)에서 S극 자석을 만나면
					// 발생한 교착상태의 수를 1 증가시키고 스위치를 끈다.
					if(swch && magnetic == 2) {
						answer++;
						swch = false;
					}
				}
			}
			sb.append(String.format("#%d %d\n", t, answer));
		}
		bw.write(sb.toString());
		bw.close();
	}
}