import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		// N => 붕어빵 먹으러 오는 사람
		// M => 붕어빵 만드는 데 걸리는 시간
		// K => M당 만들 수 있는 붕어빵 수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testCase; t++) {
			String possible = "Possible";
			st = new StringTokenizer(br.readLine());
			int guestNum = Integer.parseInt(st.nextToken());
			int times = Integer.parseInt(st.nextToken());
			int quantity = Integer.parseInt(st.nextToken());
			
			// 주어진 조건 중 손님이 도착하기까지 걸리는 최대 시간을
			// 붕어빵 만드는 데 걸리는 시간으로 나눈 길이만큼의 배열 선언
			// 왜냐하면, 3초가 걸릴 경우 {0초, 1초, 2초} = 0개, {3초, 4초, 5초} = K개 ... nK개로
			// 해당 시간대에 받아갈 수 있는 붕어빵의 양과 해당 시간대에 찾아오는 손님의 차를 구하기 위함
			int[] offered = new int[11112/times+1];
			st = new StringTokenizer(br.readLine());
			// 배열에서 방문한 손님의 대기시간/times의 index에 (붕어빵개수) -1씩 해줌
			for(int i=0; i<guestNum; i++) {
				int num = Integer.parseInt(st.nextToken());
				offered[num/times]--;
			}
			// 0번째 index가 0인 경우 => 붕어빵을 만드는 데 걸리는 시간보다
			// 일찍 도착한 손님이 있는 경우 Impossible 출력
			if(offered[0] < 0) {
				possible = "Impossible";
			} else {
				// 배열을 순회하면서 0보다 작은 값
				// (최대 공급할 수 있는 붕어빵보다 수요가 많을 경우)
				// Impossible 출력
				for(int i=1; i<offered.length; i++) {
					// offered는 나름의 합배열로 시간이 누적될 수록 붕어빵의 수가 누적되고
					// 손님이 있을 경우 해당 수만큼 빠지도록 처리함
					offered[i] += offered[i-1]+quantity;
					if(offered[i] < 0) {
						possible = "Impossible";
						break;
					}
				}
			}
			sb.append(String.format("#%d %s\n", t, possible));
		}
		bw.write(sb.toString());
		bw.close();
	}
}