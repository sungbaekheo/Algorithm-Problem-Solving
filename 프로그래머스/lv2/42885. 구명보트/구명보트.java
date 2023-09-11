import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        System.out.println(Arrays.toString(people));
        int sIdx = 0;
        int eIdx = people.length-1;
        
        while(sIdx<=eIdx){
            if(people[sIdx]+people[eIdx]>limit){
                eIdx--;
                answer++;
            } else {
                sIdx++;
                eIdx--;
                answer++;
            }
        }
        
        return answer;
    }
}