class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 1;
        
        if(my_string.length() >= is_suffix.length()){
            int gap = my_string.length() - is_suffix.length();
            for(int i=is_suffix.length()-1; i>=0; i--){
                if(my_string.charAt(gap+i) != is_suffix.charAt(i)){
                    answer = 0;
                    break;
                }
            }
        } else {
            answer = 0;
        }
        
        return answer;
    }
}