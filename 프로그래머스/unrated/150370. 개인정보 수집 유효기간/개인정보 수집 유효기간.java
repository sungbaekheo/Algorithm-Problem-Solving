import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.Arrays;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> tempAnswer = new ArrayList<>();
        Map<String, Integer> periods = new HashMap<>();
        
        LocalDate todayDate = LocalDate.parse(today.replace(".", "-"));
        
        for(String term : terms){
            String[] t = term.split(" ");
            periods.put(t[0], Integer.parseInt(t[1]));
        }
        
        for(int p=0; p<privacies.length; p++){
            String[] privacy = privacies[p].split(" ");
            LocalDate agreeDate = LocalDate.parse(privacy[0].replace(".", "-"));
            String termKind = privacy[1];
            LocalDate limitDate = agreeDate.plusMonths(periods.get(termKind)).minusDays(1);

            if(todayDate.isAfter(limitDate)){
                tempAnswer.add(p+1);
            }
        }
        
        int[] answer = new int[tempAnswer.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = tempAnswer.get(i);
        }
        
        return answer;
    }
}