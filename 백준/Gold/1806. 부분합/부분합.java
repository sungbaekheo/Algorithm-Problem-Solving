import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] arr = new int[N+1];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int front = 0;
        int rear = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = arr[rear];
        while(rear<N){
            if(sum<S){
                sum+=arr[++rear];
            } else {
                int len = rear-front+1;
                minLen = Math.min(minLen, len);
                sum-=arr[front++];
            }
        }
        if(minLen == Integer.MAX_VALUE){
            System.out.println(0);
        } else {
            System.out.println(minLen);
        }
    }
}