import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Stack<Integer> stack = new Stack<>();

    int N = sc.nextInt();
    for(int i=0; i<N; i++){
      int num = sc.nextInt();
      if(num == 0){
        stack.pop();
      } else {
        stack.add(num);
      }
    }

    int sum = 0;
    while(!stack.isEmpty()){
      sum+=stack.pop();
    }
    System.out.println(sum);
  }
}