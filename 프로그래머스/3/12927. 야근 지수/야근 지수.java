import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            
            public int compare(Integer i1, Integer i2){
                return i2-i1;
            }
        });
        
        // 우선순위 큐 초기 입력
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }
        
        while(n>0){
            if(pq.isEmpty()){
                return 0;
            }
            
            int work = pq.poll();
            
            if(work-1 > 0){
                pq.offer(work-1);
            }
            
            n--;
        }
        
        while(!pq.isEmpty()){
            int num = pq.poll();
            answer+=Math.pow(num, 2);
        }
        
        return answer;
    }
}