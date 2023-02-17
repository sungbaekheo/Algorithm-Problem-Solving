import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			
			// 번호별 박스를 뜻하는 배열
			int[] boxes = new int[n+1];
			for(int i=1; i<=q; i++) {
				int l = sc.nextInt(); // 왼쪽 인덱스
				int r = sc.nextInt(); // 오른쪽 인덱스
				for(int j=l; j<=r; j++) { // 왼쪽 - 오른쪽 사이의 박스에 q값 입력
					boxes[j] = i;
				}
			}
			sb.append("#"+t+" ");
			for(int i=1; i<boxes.length; i++) {
				sb.append(boxes[i]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}