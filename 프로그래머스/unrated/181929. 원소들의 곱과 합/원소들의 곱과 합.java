class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int sum = 0; // 원소들의 합의 제곱
        int mul = 1; // 원소들의 곱
        
        for(int i=0; i<num_list.length; i++){
            sum+=num_list[i];
            mul*=num_list[i];
        }
        
        answer = mul < sum*sum? 1:0;
        
        return answer;
    }
}