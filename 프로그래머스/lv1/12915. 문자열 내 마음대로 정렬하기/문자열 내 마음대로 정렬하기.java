import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        MyComparator comparator = new MyComparator(n);
        Arrays.sort(strings);
        Arrays.sort(strings, comparator);
        return strings;
    }
    
}

class MyComparator implements Comparator<String>{
    int idx = 0;
    public int compare(String a, String b){
        return a.charAt(idx) - b.charAt(idx);
    }
    public MyComparator(int n){
       this.idx = n; 
    }
}