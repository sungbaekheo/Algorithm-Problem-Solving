import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	
		int testCase = Integer.parseInt(br.readLine());
		String[] gradeList = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
		for(int t=1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int students = Integer.parseInt(st.nextToken());
			int numOfStu = Integer.parseInt(st.nextToken());
			
			double[] scoreList = new double[students];
			for(int i=0; i<students; i++) {
				st = new StringTokenizer(br.readLine());
				scoreList[i] = Integer.parseInt(st.nextToken())*0.35 + Integer.parseInt(st.nextToken())*0.45 + Integer.parseInt(st.nextToken())*0.20;
			}
			int rating = students-1;
			for(int i=0; i<students; i++) {
				if(scoreList[numOfStu-1] > scoreList[i]) {
					rating--;
				}
			}
			bw.write(String.format("#%d %s\n", t, gradeList[rating/(students/10)]));
		}
		bw.close();
	}
}