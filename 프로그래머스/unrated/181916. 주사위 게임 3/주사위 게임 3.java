import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] count = new int[7];
        
        count[a]++;
        count[b]++;
        count[c]++;
        count[d]++;
        
        int maxCntSpot = 0;
        int spotNum = 0;
        boolean isTwoTwo = false;
        for(int i=0; i<count.length; i++){
            if(count[i] > maxCntSpot){
                maxCntSpot = count[i];
                spotNum = i;
            } else if(maxCntSpot != 0 && maxCntSpot != 1 && count[i] == maxCntSpot){
                isTwoTwo = true;
            }
        }
        
        if(maxCntSpot == 4){
            answer = 1111*a;
        } else if(maxCntSpot == 3){
            int secNum = 0;
            for(int i=1; i<count.length; i++){
                if(count[i] == 1){
                    secNum = i;
                }
            }
            answer = (int) Math.pow(spotNum*10+secNum,2);   
        } else if(maxCntSpot == 2){
            if(isTwoTwo){
                if(a == b){
                    answer = (a+c)*Math.abs(a-c);
                } else {
                    answer = (a+b)*Math.abs(a-b);
                }
            } else {
                answer = 1;
                for(int i=0; i<count.length; i++){
                    if(count[i] == 1){
                        answer*=i;
                    }
                }
            }
        } else {
            answer = Math.min(a, Math.min(b, Math.min(c, d)));
        }
        
        return answer;
    }
}