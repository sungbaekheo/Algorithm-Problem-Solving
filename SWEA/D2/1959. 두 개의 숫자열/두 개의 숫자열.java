import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        
        int testCase = sc.nextInt();
        
        for(int t=1; t<=testCase; t++) {
        	int n = sc.nextInt();
        	int m = sc.nextInt();
        	// 두 개의 배열에 값 입력하기
        	int[] first = new int[n];
        	int[] second = new int[m];
        	for(int i=0; i<n; i++) {
        		first[i] = sc.nextInt();
        	}
        	for(int i=0; i<m; i++) {
        		second[i] = sc.nextInt();
        	}
        	// 최대값 저장용 변수
        	int max = 0;
        	if(first.length < second.length) {
        		for(int i=0; i<=second.length-first.length; i++) {
        			int temp = 0;
        			for(int j=0; j<first.length; j++) {
        				temp+=first[j]*second[i+j];
        			}
        			if(max < temp) {
        				max = temp;
        			}
        		}
        	} else {
        		for(int i=0; i<=first.length-second.length; i++) {
        			int temp = 0;
        			for(int j=0; j<second.length; j++) {
        				temp+=second[j]*first[i+j];
        			}
        			if(max < temp) {
        				max = temp;
        			}
        		}
        	}
        	System.out.printf("#%d %d\n", t, max);
        }
    }
}