import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<String> cardQ;
		
		int testCase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testCase; t++) {
			cardQ = new LinkedList<>();
			int len = Integer.parseInt(br.readLine());
			String[] card = br.readLine().split(" ");
			if(len%2 == 0) len = len/2;
			else len = len/2+1;
			for(int i=0; i<len; i++) {
				for(int j=0; j<card.length; j++) {
					if(j%(len) == i) {
						cardQ.offer(card[j]);
					}
				}
			}
			sb.append(String.format("#%d ",t));
			for(int i=0; i<card.length; i++) {
				sb.append(cardQ.poll()+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}