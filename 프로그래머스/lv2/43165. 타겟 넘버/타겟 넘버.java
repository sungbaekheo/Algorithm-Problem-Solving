class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        findTheWay(0, numbers, target, 0);
        
        return answer;
    }
    
    public void findTheWay(int sum, int[] numbers, int target, int place){
        
        if(place == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        findTheWay(sum - numbers[place], numbers, target, place+1);
        findTheWay(sum + numbers[place], numbers, target, place+1);
    }
}