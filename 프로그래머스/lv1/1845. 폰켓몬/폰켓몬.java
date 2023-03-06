import java.util.Set;
import java.util.HashSet;

class Solution {
    Set<Integer> pokemon = new HashSet<>();
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i=0; i<nums.length; i++){
            pokemon.add(nums[i]);
        }
        if(pokemon.size()>nums.length/2){
            return nums.length/2;
        } else{
            return pokemon.size();
        }
    }
}