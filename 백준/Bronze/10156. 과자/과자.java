import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int price = sc.nextInt();
        int n = sc.nextInt();
        int money = sc.nextInt();
        
        System.out.println(price*n<=money? 0:price*n-money);
    }
}