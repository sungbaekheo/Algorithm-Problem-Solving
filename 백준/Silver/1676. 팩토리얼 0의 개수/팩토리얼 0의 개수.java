import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int answer = num/5+num/25+num/125;
    System.out.println(answer);
  }
}