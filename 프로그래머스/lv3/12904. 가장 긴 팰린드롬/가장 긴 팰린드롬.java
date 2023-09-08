class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        loop: for(int i=s.length(); i>1; i--){
            for(int j=0; j<=s.length()-i; j++){
                if(isPalindrome(s, j, j+i)){
                    answer = i;
                    break loop;
                }
            }
        }

        return answer;
    }
    
    public boolean isPalindrome(String str, int start, int end){
        for(int i=start; i<start+(end-start-1/2); i++){
            if(str.charAt(i) != str.charAt(start+end-i-1)){
                return false;
            }   
        }
        return true;
    }
}