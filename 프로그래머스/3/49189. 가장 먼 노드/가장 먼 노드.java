import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int maxDist = Integer.MIN_VALUE;
    boolean[] visited;
    int[] dist;
    List<Integer>[] graph;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        dist = new int[n+1];
        
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] node : edge){
            int f = node[0];
            int l = node[1];
            graph[f].add(l);
            graph[l].add(f);
        }
        
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                calculateDistance(i);
            }
        }
        
        for(int i=1; i<=n; i++){
            if(dist[i] == maxDist){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void calculateDistance(int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i=0; i<graph[now].size(); i++){
                int nNode = graph[now].get(i);
                if(!visited[nNode]){
                    q.offer(nNode);
                    visited[nNode] = true;
                    dist[nNode] = dist[now]+1;
                }
                
                maxDist = maxDist>dist[nNode]? maxDist:dist[nNode];
            }
        }
    }
}