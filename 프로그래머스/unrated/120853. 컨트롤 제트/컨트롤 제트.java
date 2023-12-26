class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] oper = s.split(" ");
        
        for(int i=0; i<oper.length; i++){
            if(oper[i].equals("Z")){
                answer-=Integer.parseInt(oper[i-1]);
            } else {
                answer+=Integer.parseInt(oper[i]);
            }
        }
        
        return answer;
    }
}