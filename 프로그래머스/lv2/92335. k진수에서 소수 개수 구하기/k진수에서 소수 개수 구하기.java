import java.util.Arrays;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String number = "";
        
        while(n>k){
            number = n%k + number;
            n/=k;
        }
        number = n+number;

        String[] numArr = number.split("0");
        
        for(String num : numArr){
            if(!num.equals("") && isPrimeNumber(Long.parseLong(num))){
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPrimeNumber(long num){
        
        if(num == 1){
            return false;
        }
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}