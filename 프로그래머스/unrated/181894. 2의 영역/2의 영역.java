class Solution {
    public int[] solution(int[] arr) {
        
        int f = -1;
        int l = -1;
        
        for(int i=0; i<arr.length; i++){
            if(f == -1 && arr[i] == 2){
                f = i;
            }
            if(f != -1 && arr[i] == 2){
                l = i;
            }
        }
        
        if(f == -1 && l == -1){
            return new int[] {-1};
        }
        
        int size = l-f+1;
        int[] answer = new int[size];
        int idx = 0;
        
        for(int i=f; i<=l; i++){
            answer[idx++] = arr[i];
        }
        
        return answer;
    }
}