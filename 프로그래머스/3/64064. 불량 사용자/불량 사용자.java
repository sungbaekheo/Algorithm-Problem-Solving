import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    
    int endLen;
    int answer;
    Set<Set<String>> dictSet = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {

        endLen = banned_id.length;
        boolean[] visited = new boolean[user_id.length];
        Set<String> picked = new HashSet<>();
        
        makeCombination(0, user_id, banned_id, visited, picked);
        
        return dictSet.size();
    }
    
    public void makeCombination(int curr, String[] user_id, String[] banned_id, boolean[] visited, Set<String> picked){
        if(curr == endLen){
            dictSet.add(new HashSet<>(picked));
            return;
        }
        
        for(int i=0; i<user_id.length; i++){
            if(!visited[i] && checkIsBannedOrNot(user_id[i], banned_id[curr])){
                visited[i] = true;
                picked.add(user_id[i]);
                makeCombination(curr+1, user_id, banned_id, visited, picked);
                picked.remove(user_id[i]);
                visited[i] = false;
            }
        }
    }
    
    public boolean checkIsBannedOrNot(String id, String banId){
        
        if(banId.length() != id.length()){
            return false;
        }
        
        for(int i=0; i<id.length(); i++){
            if(banId.charAt(i) != '*' && banId.charAt(i) != id.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
}