class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        int sIdx = my_string.length()-n;
        
        answer = my_string.substring(sIdx);
        return answer;
    }
}