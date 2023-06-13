class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int n = 0;
        
        for(int[] query:queries){
            int min = Integer.MAX_VALUE;
            
            for(int i=query[0]; i<=query[1]; i++){
                if(arr[i]>query[2] && arr[i] < min){
                    min = arr[i];
                }    
            }
            if(min == Integer.MAX_VALUE){
                min = -1;
            }
            answer[n++] = min;
        }
        
        return answer;
    }
}