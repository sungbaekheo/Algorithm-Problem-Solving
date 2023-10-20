import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wishList = new HashMap<>();
  
        for(int i=0; i<=discount.length-10; i++){
            
            for(int j=0; j<want.length; j++){
                wishList.put(want[j], number[j]);
            }
            
            for(int j=i; j<10+i; j++){
                String curr = discount[j];
                if(wishList.getOrDefault(curr, -1) == -1){
                    break;
                }
                
                wishList.replace(curr, wishList.get(curr)-1);
            }
            
            if(isSatisfied(want, wishList)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isSatisfied(String[] want, Map<String, Integer> wishList){
        for(String stuff : want){
            if(wishList.get(stuff) != 0){
                return false;
            }
        }
        return true;
    }
}