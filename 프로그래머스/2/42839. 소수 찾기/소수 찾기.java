import java.util.Set;
import java.util.HashSet;

class Solution {
    int answer = 0;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        String[] nums = numbers.split("");
        boolean[] visited = new boolean[nums.length];
        
        for(int i=1; i<=nums.length; i++){
            String[] arr = new String[i];
            permutation(nums, arr, 0, visited, i);
        }
        
        for(int num : set){
            if(checkPrimeNumber(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void permutation(String[] nums, String[] arr, int depth, boolean[] visited, int len){
        if(depth == len){
            set.add(Integer.parseInt(String.join("",arr)));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = nums[i];
                permutation(nums, arr, depth+1, visited, len);
                visited[i] = false;
            }
        }
    }
    
    public boolean checkPrimeNumber(int number){
        if(number <= 1){
            return false;
        }
        
        for(int i=2; i<=Math.sqrt(number); i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }
}