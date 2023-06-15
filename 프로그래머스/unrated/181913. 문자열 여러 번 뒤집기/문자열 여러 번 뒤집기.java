class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        
        char[] str = my_string.toCharArray();
        
        for(int[] query:queries){
            char[] subStr = new char[query[1]-query[0]+1];
            
            for(int i=query[0]; i<=query[1]; i++){
                subStr[i-query[0]] = str[i];
            }
            
            for(int i=query[0]; i<=query[1]; i++){
                str[i] = subStr[query[1]-i];
            }
        }
        
        for(int i=0; i<str.length; i++){
            answer+=str[i];
        }
        
        return answer;
    }
}