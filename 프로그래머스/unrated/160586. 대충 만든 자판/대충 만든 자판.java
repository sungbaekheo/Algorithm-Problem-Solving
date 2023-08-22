class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] cntAlphabet = new int[26];
        
        for(int i=0; i<cntAlphabet.length; i++){
            cntAlphabet[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0; i<keymap.length; i++){
            String key = keymap[i];
            for(int j=0; j<key.length(); j++){
                if(cntAlphabet[key.charAt(j) - 'A']>j+1){
                    cntAlphabet[key.charAt(j) - 'A'] = j+1;
                }
            }
        }
        
        for(int i=0; i<targets.length; i++){
            String target = targets[i];
            int sumCnt = 0;
            for(int j=0; j<target.length(); j++){
                int cnt = cntAlphabet[target.charAt(j)-'A'];
                if(cnt == Integer.MAX_VALUE){
                    sumCnt = -1;
                    break;
                }
                sumCnt+=cnt;
            }
            answer[i] = sumCnt;
        }
        return answer;
    }
}