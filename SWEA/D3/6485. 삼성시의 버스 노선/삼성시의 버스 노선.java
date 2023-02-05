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
		
		for(int t=1; t<=testCase; t++) {
			int[] busStops = new int[5001];
			int innerT = Integer.parseInt(br.readLine());
			for(int i=0; i<innerT; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				for(int j=start; j<=end; j++) {
					busStops[j]++;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+t+" ");
			int stopNum = Integer.parseInt(br.readLine());
			for(int i=0; i<stopNum; i++) {
				sb.append(busStops[Integer.parseInt(br.readLine())]+" ");
			}
			sb.append("\n");
			bw.write(sb.toString());
		}
		bw.close();
	}
}