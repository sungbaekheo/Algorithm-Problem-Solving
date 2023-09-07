import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        List<Integer> scores = new ArrayList<>();
        int score = 0;
        
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            
            if(c - '0' >= 0 && c - '0' <= 10){
                score = c - '0';
                if(c == '1' && dartResult.charAt(i+1) == '0'){
                    score = 10;
                    i++;
                }
            } else if(c - 'A' >= 0 && c - 'A' <= 25){
                if(c == 'D'){
                    score = (int) Math.pow(score, 2);
                } else if(c == 'T'){
                    score = (int) Math.pow(score, 3);
                }
                scores.add(score);
            } else {
                int mul = 2;
                int index = scores.size()-1;
                if(c == '*'){
                    if(index>0){
                        index--;
                    }
                    for(int j=index; j<scores.size(); j++){
                        scores.set(j, scores.get(j)*mul);
                    }
                } else{
                    mul = -1;
                    scores.set(index, scores.get(index)*mul);
                }

            }
        }
        
        for(int i : scores){
            answer+=i;
        }
        
        
        return answer;
    }
}