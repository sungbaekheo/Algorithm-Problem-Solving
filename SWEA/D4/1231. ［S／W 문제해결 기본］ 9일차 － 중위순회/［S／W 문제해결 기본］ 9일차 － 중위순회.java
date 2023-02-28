import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int len;
	static char[] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t=1; t<=10; t++) {
			len = Integer.parseInt(br.readLine());
			tree = new char[len+1];
			for(int i=0; i<len; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				tree[idx] = c;
			}
			sb.append("#"+t+" ");
			inorderTraverse(1);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void inorderTraverse(int i) {
		if(i>len) {
			return;
		}
		inorderTraverse(i*2);
		
		sb.append(tree[i]);
		
		inorderTraverse(i*2+1);
	}
}