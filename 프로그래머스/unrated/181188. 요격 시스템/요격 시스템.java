import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, new Comparator<int[]>(){
            public int compare(int[] t1, int[] t2){
                return t1[1] - t2[1];
            }
        });
        
        int std = targets[0][1];
        
        for(int i=1; i<targets.length; i++){
            int[] cPoint = targets[i];
            
            if(cPoint[0] >= std){
                answer++;
                std = cPoint[1];
            } else {
                continue;
            }
        }
        
        return answer+1;
    }
}