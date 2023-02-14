import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			// "()"를 레이저로 알아보고 사용하기 쉽게 "l"로 변경
			String stick = sc.next().replace("()", "l");
			
			// 쇠막대기의 개수
			int nStick = 0;
			// 답으로 출력할 쇠막대기 조각의 개수
			int pieces = 0;
			// 쇠막대기의 길이만큼 진행
			for(int i=0; i<stick.length(); i++) {
				// 레이저를 만날경우 지금까지 모인 쇠막대기의 개수만큼 조각 수 더하기
				if(stick.charAt(i) == 'l') {
					pieces+=nStick;
				// "("를 만날 경우 쇠막대기의 개수 추가
				} else if(stick.charAt(i) == '(') {
					nStick++;
				// ")"를 만날 경우 기존의 쇠막대기 개수만큼 더했다가 겹치는 만큼 다시 빼줌
				} else {
					pieces++;
					nStick--;
				}
			}
			System.out.printf("#%d %d\n", t, pieces);
		}
	}
}