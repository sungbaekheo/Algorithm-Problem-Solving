import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=l; i<=r; i++){
            boolean isTrue = true;
            String num = String.valueOf(i);
            for(char c:num.toCharArray()){
                if(c == '0' || c == '5'){
                    continue;
                } else {
                    isTrue = false;
                    break;
                }
            }
            if(isTrue){
                list.add(i);
            }
        }
        
        if(list.size() == 0){
            list.add(-1);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}