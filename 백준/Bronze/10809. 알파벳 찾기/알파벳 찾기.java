import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        char[] str = sc.next().toCharArray();
        int[] alphabet = new int[26];
        for(int i=0; i<26; i++){
            alphabet[i] = -1;
        }

        for(int i=0; i<str.length; i++){
            if(alphabet[(int) str[i] - 'a'] == -1){
                alphabet[(int) str[i] - 'a'] = i;
            }
        }

        for(int i=0; i<alphabet.length; i++){
            System.out.print(alphabet[i]+ " ");
        }
    }
}