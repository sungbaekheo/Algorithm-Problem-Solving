import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] input = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			input[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		if(N%2 == 1) System.out.println(1);
		else System.out.println(Math.abs(input[N/2]-input[N/2-1])+1);
		
		
	}
}