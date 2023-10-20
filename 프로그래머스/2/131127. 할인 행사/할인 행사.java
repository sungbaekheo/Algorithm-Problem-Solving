import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wishList = new HashMap<>();
        int left = 0;
        int right = 9;
        
        for(int i=left; i<=right; i++){
            wishList.put(discount[i], wishList.getOrDefault(discount[i], 0)+1);
        }
        
        while(right<discount.length){
            if(isSatisfied(want, number, wishList)){
                answer++;
            }
            
            right++;
            if(right < discount.length){
                wishList.put(discount[right], wishList.getOrDefault(discount[right], 0)+1);
            }
            wishList.put(discount[left], wishList.get(discount[left])-1);
            left++;
        }
        
        return answer;
    }
    
    public boolean isSatisfied(String[] want, int[] number, Map<String, Integer> wishList){
        for(int i=0; i<want.length; i++){
            if(wishList.getOrDefault(want[i], 0) != number[i]){
                return false;
            }
        }
        return true;
    }
}