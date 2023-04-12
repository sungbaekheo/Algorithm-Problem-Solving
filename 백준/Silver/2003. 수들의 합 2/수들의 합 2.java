import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] numArr = new int[N+1];
		
		for(int i=0; i<N; i++) {
			numArr[i] = sc.nextInt();
		}
		
		int front = 0;
		int rear = 0;
		int sum = numArr[front];
		int count = 0;
		
		while(rear<=N-1) {
			if(sum == M) {
				count++;
				sum-=numArr[front++];
				sum+=numArr[++rear];
			} else if(sum<M) {
				sum+=numArr[++rear];
			} else {
				sum-=numArr[front++];
			}
		}
		
		System.out.println(count);
	}
}