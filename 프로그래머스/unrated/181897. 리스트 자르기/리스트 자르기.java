import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {

        List<Integer> ans = new ArrayList<>();
        
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        switch(n){
            case 1:
                for(int i=0; i<=b; i++){
                    ans.add(num_list[i]);
                }
                break;
            case 2:
                for(int i=a; i<num_list.length; i++){
                    ans.add(num_list[i]);
                }
                break;
            case 3:
                for(int i=a; i<=b; i++){
                    ans.add(num_list[i]);
                }
                break;
            case 4:
                for(int i=a; i<=b; i+=c){
                    ans.add(num_list[i]);
                }
                break;
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}