import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        
        List<Integer> array = new ArrayList<>();
        
        for(int[] interval : intervals){
            int f = interval[0];
            int l = interval[1];
            for(int i=f; i<=l; i++){
                array.add(arr[i]);
            }
        }
        
        int[] answer = new int[array.size()];
        for(int i=0; i<array.size(); i++){
            answer[i] = array.get(i);
        }
        
        return answer;
    }
}