import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> order = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            order.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++){
            String call = callings[i];
            
            int preOrd = order.get(call) - 1;
            int thisOrd = order.get(call);
            
            String preCall = players[preOrd];
            
            players[preOrd] = call;
            players[thisOrd] = preCall;
            
            order.replace(call, preOrd);
            order.replace(preCall, thisOrd);
        }
        
        return players;
    }
}