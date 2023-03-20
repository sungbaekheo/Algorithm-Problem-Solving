import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        char[] str = sc.next().toCharArray();
        long hash = 0;

        for(int i=0; i<len; i++){
            hash+=(str[i]-'a'+1)*Math.pow(31, i);
        }
        System.out.println(hash%1234567891);
    }
}