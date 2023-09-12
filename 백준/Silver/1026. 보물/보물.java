import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int len = sc.nextInt();
      int answer = 0;
      int[] arrA = new int[len];
      Integer[] arrB = new Integer[len];

      for (int i = 0; i < len; i++) {
        arrA[i] = sc.nextInt();
      }

      for (int i = 0; i < len; i++) {
        arrB[i] = sc.nextInt();
      }

      Arrays.sort(arrA);
      Arrays.sort(arrB, Collections.reverseOrder());

      for (int i = 0; i < len; i++) {
        answer += arrA[i] * arrB[i];
      }

      System.out.println(answer);
    }
}