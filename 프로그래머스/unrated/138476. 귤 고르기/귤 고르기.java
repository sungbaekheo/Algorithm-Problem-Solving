import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.lang.Comparable;
import java.util.Map.Entry;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> tangs = new HashMap<>();
        PriorityQueue<Tangerine> pq = new PriorityQueue<>();
        
        for(int i=0; i<tangerine.length; i++){
            tangs.put(tangerine[i], tangs.getOrDefault(tangerine[i], 0)+1);
        }
        
        for(Entry<Integer, Integer> entry : tangs.entrySet()){
            pq.offer(new Tangerine(entry.getKey(), entry.getValue()));
        }
        
        while(k>0){
            int tangNow = pq.poll().num;
            answer++;
            k = k - tangNow;
        }
        
        return answer;
    }
}

class Tangerine implements Comparable<Tangerine>{
    int key;
    int num;
    
    public Tangerine(int key, int num){
        this.key = key;
        this.num = num;
    }
    
    public int compareTo(Tangerine t2){
        return t2.num - this.num;
    }
}