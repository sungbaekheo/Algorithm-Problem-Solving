import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int nNum = sc.nextInt();
        int nQ = sc.nextInt();
        int[] numArray = new int[nNum+1];
        for(int i=1; i<=nNum; i++){
            numArray[i] = numArray[i-1] + sc.nextInt();
        }
        for(int i=0; i<nQ; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(numArray[end]-numArray[start-1]);
        }
    }
}