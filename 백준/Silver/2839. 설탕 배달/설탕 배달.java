import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();
        boolean go = true;
        int nDeliver = 0;
        while(total>0){
            if(total%5 == 0){
                nDeliver+=total/5;
                break;
            }else{
                total-=3;
                nDeliver++;
            }
        }
        if(total<0){
            nDeliver = -1;
        }
        System.out.println(nDeliver);
    }
}