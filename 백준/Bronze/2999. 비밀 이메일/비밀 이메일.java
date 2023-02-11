import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String msg = sc.next();
        int len = msg.length();
        int a = 0;
        int b = 0;
        for(int i=1; i<=len; i++){
            if(len%i == 0 && i<=len/i){
                a = i;
                b = len/i;
            }
        }
        char[][] mm = new char[a][b];
        for(int j=0; j<b; j++){
            for(int i=0; i<a; i++){
                mm[i][j] = msg.charAt(i+(j*a));
            }
            
        }

        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                System.out.print(mm[i][j]);
            }
        }
    }
}