import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
			
		});
		
		int nodes = Integer.parseInt(st.nextToken());
		int edges = Integer.parseInt(st.nextToken());
		int powerPlant = Integer.parseInt(st.nextToken());
		
		List<int[]>[] cities = new ArrayList[nodes+1];
		boolean[] visited = new boolean[nodes+1];
		
		for(int i=0; i<=nodes; i++) {
			cities[i] = new ArrayList<>(); 
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<powerPlant; i++) {
			int plant = Integer.parseInt(st.nextToken());
			visited[plant] = true;
		}
		
		for(int i=0; i<edges; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int rear = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			cities[front].add(new int[] {rear, weight});
			cities[rear].add(new int[] {front, weight});
		}
		
		for(int i=1; i<visited.length; i++) {
			if(visited[i]) {
				for(int j=0; j<cities[i].size(); j++) {
					pq.offer(cities[i].get(j));
				}
			}
		}
		
		int selected = 0;
		int cost = 0;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(!visited[now[0]]) {
				visited[now[0]] = true;
				cost+=now[1];
				selected++;
				for(int i=0; i<cities[now[0]].size(); i++) {
					pq.offer(cities[now[0]].get(i));
				}
			}
			
			if(selected == nodes-powerPlant) {
				break;
			}
		}
		
		System.out.println(cost);
	}
}