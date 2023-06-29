import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> points = new HashMap<>();
        
        for(int i=0; i<name.length; i++){
            points.put(name[i], yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++){
            int point = 0;
            
            for(int j=0; j<photo[i].length; j++){
                String person = photo[i][j];
                point+=points.getOrDefault(person, 0);
            }
            answer[i] = point;
        }
        
        return answer;
    }
}