import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			int input = sc.nextInt();
			int[] numList = new int[input];
			
			for(int i=0; i<input; i++) { // 주어진 숫자 배열에 입력
				numList[i] = sc.nextInt();
			}
			int max = -1; // 출력할 답 (해당하는 수가 없다면 -1을 출력해야 하기에 -1로 초기화)
			
			for(int i=0; i<input-1; i++) {
				int temp = 0;
				for(int j=i+1; j<input; j++) {
					boolean isDanjo = true;
					// 각 수를 곱해서 얻은 수를 String 배열로 바꾸고
					// 같은 수를 정렬해서 값을 얻기
					// 만약 정렬된 값과 기존 값이 같다면 단조 증가하는 수
					String num = String.valueOf(numList[i]*numList[j]);
					for(int k=1; k<num.length(); k++) {
						int num2 = Character.getNumericValue((num.charAt(k)));
						int num1 = Character.getNumericValue((num.charAt(k-1)));
						if(num2<num1) {
							isDanjo = false;
						}
					}
					
					if(isDanjo) { // 단조증가하는 수일 때만 최대값 연산 수행
						temp = numList[i]*numList[j];
						if(temp>max) {
							max = temp;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", t, max);
		}
	}
}