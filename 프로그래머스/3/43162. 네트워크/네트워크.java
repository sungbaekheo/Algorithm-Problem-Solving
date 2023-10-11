import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                findNetwork(computers, visited, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void findNetwork(int[][] computers, boolean[] visited, int start){
        Queue<Integer> netQ = new LinkedList<>();
        
        netQ.offer(start);
        visited[start] = true;
        
        while(!netQ.isEmpty()){
            int nowCom = netQ.poll();
            
            for(int i=0; i<computers[nowCom].length; i++){
                if(i == nowCom){
                    continue;
                }
                
                int nextCom = computers[nowCom][i];
                
                if(!visited[i] && nextCom == 1){
                    netQ.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}