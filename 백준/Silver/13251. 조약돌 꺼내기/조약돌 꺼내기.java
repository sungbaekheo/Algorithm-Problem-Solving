import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    double [] shingles = new double[N];
    double sum = 0;

    for(int i=0; i<N; i++){
      shingles[i] = sc.nextInt();
      sum += shingles[i];
    }

    int M = sc.nextInt();
    double per = 0;
    for(int i=0; i<N; i++){
      double tempSum = sum;
      int tempM = M;
      if(shingles[i] < M){
        continue;
      }
      double temp = 1;
      while(tempM>0){
        temp*=((shingles[i]--/tempSum--));
        tempM--;
      }
      per+=temp;
    }
    System.out.println(per);
  }
}