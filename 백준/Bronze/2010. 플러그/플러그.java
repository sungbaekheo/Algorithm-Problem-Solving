import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int nMulti = sc.nextInt();
        
        int nPlug = 0;
        
        for(int i=0; i<nMulti; i++){
            nPlug+=sc.nextInt();
        }
        
        System.out.println(nPlug-nMulti+1);
    }
}