import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bytes = sc.nextInt()/4;
        String answer = "";
        for(int i=0; i<bytes; i++){
            answer += "long ";
        }
        answer += "int";

        System.out.println(answer);

    }
}