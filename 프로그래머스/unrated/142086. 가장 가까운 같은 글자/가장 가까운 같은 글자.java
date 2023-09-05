import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> pos = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(pos.get(c) == null){
                pos.put(c, i);
                answer[i] = -1;
            } else {
                answer[i] = i - pos.get(c);
                pos.replace(c, i);
            }
        }
        
        return answer;
    }
}