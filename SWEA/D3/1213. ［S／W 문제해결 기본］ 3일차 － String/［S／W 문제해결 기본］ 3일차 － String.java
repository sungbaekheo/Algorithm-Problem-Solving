import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			
			int testCase = sc.nextInt();
			String find = sc.next();
			String str = sc.next();
			
			// 1. replace가 일어난 횟수만큼 카운트
//			int count = 0;
//			while(str.contains(find)) {
//				str=str.replaceFirst(find, "a");
//				count++;
//			}
//			System.out.println("#"+testCase+" "+count);
			
			// 2. split으로 배열 원소 개수 -1
//			String[] strArray = str.split(find);
//			System.out.println("#"+testCase+" "+(strArray.length-1));
			
			// 3. 정석 패턴 확인 하기
			int fLen = find.length(); // 찾고자 하는 단어 길이
			int sLen = str.length(); // 주어진 문자열 길이
			int i = 0; // 주어진 문자열 인덱스
			int count = 0;
			while(i<sLen-fLen+1) {
				boolean found = true;
				for(int j=0; j<fLen; j++) {
					if(str.charAt(i+j) != find.charAt(j)) {
						found = false;
						break;
					}
				}
				if(found) {
					count++;
				}
				i++;
			}
			System.out.println("#"+testCase+" "+count);
		}
	}
}