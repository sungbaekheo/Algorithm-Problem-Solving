import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String str = "";
        
        for(int i=0; i<a.length(); i++){
            char chr = a.charAt(i);
            if(chr - 'a' >= 0){
                str += Character.toUpperCase(chr);
            } else {
                str += Character.toLowerCase(chr);
            }
        }
        
        System.out.println(str);
    }
}