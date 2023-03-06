import java.util.Arrays;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] weapon = new int[number];
        for(int i=1; i<=number; i++){
            for(int j=1; j<=Math.sqrt(i); j++){
                if(j == Math.sqrt(i)){
                    weapon[i-1]++;
                } else if(i%j == 0){
                    weapon[i-1]+=2;
                }
            }
        }
        for(int i=0; i<number; i++){
            if(weapon[i]>limit){
                answer+=power;
            } else {
                answer+=weapon[i];
            }
        }
        return answer;
    }
}