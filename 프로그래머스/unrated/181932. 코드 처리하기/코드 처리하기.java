class Solution {
    public String solution(String code) {
        String answer = "";
        
        int mode = 0;
        for(int i=0; i<code.length(); i++){
            char chr = code.charAt(i);
            
            if(mode == 0){
                if(chr != '1'){
                    if(i%2 == 0){
                        answer+=chr;
                    }
                } else {
                    mode = 1;
                }
            } else {
                if(chr != '1'){
                    if(i%2 == 1){
                        answer+=chr;
                    }
                } else {
                    mode = 0;
                }
            }
        }
        if(answer.equals("")){
            answer = "EMPTY";
        }
        
        return answer;
    }
}