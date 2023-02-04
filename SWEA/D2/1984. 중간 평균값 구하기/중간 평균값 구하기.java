import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int maxNum = 0;
			int minNum = 10000;
			int sum = 0;
			for(int i=0; i<10; i++) {
				int num = Integer.parseInt(st.nextToken());
				sum+=num;
				if(num>maxNum) {
					maxNum = num;
				}
				if(num<minNum) {
					minNum = num;
				}	
			}
			System.out.printf("#%d %.0f\n", t, (sum-maxNum-minNum)/8.0);
		}
	}
}