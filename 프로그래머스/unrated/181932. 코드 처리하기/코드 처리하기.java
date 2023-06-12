class Solution {
    public String solution(String code) {
        String answer = "";
        
        int mode = 0;
        for(int i=0; i<code.length(); i++){
            char ch = code.charAt(i);
            if(ch == '1'){
                mode = 1 - mode;
            } else if(mode == 0 && i%2 == 0){
                answer+=ch;
            } else if(mode == 1 && i%2 == 1){
                answer+=ch;
            }
        }
        if(answer.equals("")){
            answer = "EMPTY";
        }
        
        return answer;
    }
}