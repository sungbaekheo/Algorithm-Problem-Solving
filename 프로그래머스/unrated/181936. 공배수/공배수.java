class Solution {
    public int solution(int number, int n, int m) {
        int answer = 0;
        
        if(number%m == 0 && number%n == 0){
            answer = 1;
        }
        
        return answer;
    }
}