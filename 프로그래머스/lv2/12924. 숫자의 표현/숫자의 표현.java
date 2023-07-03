class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int front = 0;
        int rear = 1;
        int sum = rear;
        
        while(front<=rear){
            if(sum < n){
                sum+=(++rear);
            } if(sum == n){
                answer++;
                sum+=(++rear);
            } if(sum > n){
                sum-=front++;
            }
        }
        return answer;
    }
}