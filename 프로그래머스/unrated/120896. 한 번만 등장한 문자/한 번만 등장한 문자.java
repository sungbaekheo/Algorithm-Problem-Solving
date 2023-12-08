class Solution {
    public String solution(String s) {
        String answer = "";
        
        int[] alphabets = new int[26];
        
        for(int i=0; i<s.length(); i++){
            int idx = s.charAt(i) - 'a';
            alphabets[idx]++;
        }
        
        for(int i=0; i<alphabets.length; i++){
            if(alphabets[i] == 1){
                answer+=(char) (i + 'a');
            }
        }
        
        return answer;
    }
}