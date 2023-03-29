import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testCase; t++) {
			sb.append("#").append(t).append(" ");
			int n = Integer.parseInt(br.readLine());
			List<double[]> edgeArr = new ArrayList<>();
			long[][] dist = new long[n+1][2];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				dist[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				dist[i][1] = Integer.parseInt(st.nextToken());
			}

			for(int r=1; r<=n; r++) {
				for(int c=r+1; c<=n; c++) {
					double d = Math.sqrt(Math.pow(dist[r][0]-dist[c][0], 2)+Math.pow(dist[r][1]-dist[c][1], 2));
					edgeArr.add(new double[] {r, c, d});
				}
			}
			
			double e = Double.parseDouble(br.readLine());
			
			Collections.sort(edgeArr, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					if(o1[2] - o2[2] >= 0) {
						return 1;
					} else {
						return -1;
					}
				}
			});
			
			p = new int[n+1];
			for(int i=0; i<=n; i++) {
				p[i] = i;
			}
			
			double totalTax = 0;
			int pick = 0;
			for(int i=0; i<edgeArr.size(); i++) {
				int x = (int) edgeArr.get(i)[0];
				int y = (int) edgeArr.get(i)[1];
				
				if(findset(x) != findset(y)) {
					union(x, y);
					totalTax+=Math.pow(edgeArr.get(i)[2], 2)*e;
					pick++;
				}
				
				if(pick == (n-1)) {
					break;
				}
			}
			sb.append(String.format("%.0f", totalTax)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int findset(int x) {
		if(x!=p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}
	
	static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}
}