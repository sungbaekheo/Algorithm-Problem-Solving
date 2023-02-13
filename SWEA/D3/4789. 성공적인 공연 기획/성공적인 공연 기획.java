import java.util.Scanner;

public class Solution {
	public static void main(String args[]){ 
	     Scanner sc = new Scanner(System.in);

	     int testCase = sc.nextInt();
	     // 각 구간별 차이나는 인원의 최대값을 반환
	     for(int t=1; t<=testCase; t++){
	       String spectators = sc.next();
	       // 각 구간별 필요한 최소 인원을 담을 배열 == i 구간에 i명
	       int[] needs = new int[spectators.length()+1];
	       // 주어진 정보에서 각 구간별 기립박수 치는 인원 합배열
	       int[] sumList = new int[spectators.length()+1];
	       
	       // 필요한 최소 인원과 기립박수 치는 인원 간의 차
	       int maxGap = 0;
	       for(int i=1; i<=spectators.length(); i++){
	    	   int tempGap= 0;
	    	   needs[i] = i;
	    	   sumList[i] = sumList[i-1] + Character.getNumericValue(spectators.charAt(i-1));
	    	   tempGap = needs[i]-sumList[i];
	    	   if(tempGap>maxGap) {
	    		   maxGap = tempGap;
	    	   }
	       }
	       System.out.printf("#%d %d\n", t, maxGap);
	     }
	}
}