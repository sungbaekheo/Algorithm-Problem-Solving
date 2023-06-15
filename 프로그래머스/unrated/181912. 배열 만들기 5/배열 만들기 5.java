import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> numArr = new ArrayList<>();
        
        for(String num:intStrs){
            int number = Integer.parseInt(num.substring(s, s+l));
            if(number > k){
                numArr.add(number);
            }
        }
        
        int[] answer = new int[numArr.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = numArr.get(i);
        }
        
        return answer;
    }
}