class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        
        char[] inputString = my_string.toCharArray();
        
        for(int i=0; i<=(e-s)/2; i++){
            char temp = inputString[s+i];
            inputString[s+i] = inputString[e-i];
            inputString[e-i] = temp;
        }
        
        for(int i=0; i<my_string.length(); i++){
            answer+=inputString[i];
        }
        
        return answer;
    }
}