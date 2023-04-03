import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			Queue<Integer> q = new LinkedList<>();
			List<Integer>[] graph;
			
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[] inDegree = new int[V+1];
			graph = new ArrayList[V+1];
			
			for(int i=0; i<=V; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				int v = sc.nextInt();
				int e = sc.nextInt();
				graph[v].add(e);
				inDegree[e]++;
			}
			
			for(int i=1; i<=V; i++) {
				if(inDegree[i] == 0) {
					q.offer(i);
				}
			}
			
			sb.append("#").append(t).append(" ");
			while(!q.isEmpty()) {
				int curr = q.poll();
				for(int i : graph[curr]) {
					inDegree[i]--;
					if(inDegree[i] == 0) {
						q.offer(i);
					}
				}
				sb.append(curr).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
