import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        int[] sushi = new int[N];
        int[] cnt = new int[d+1];

        for(int i=0; i<N; i++){
            sushi[i] = sc.nextInt();
        }

        int front = 0;
        int rear = -1;
        int max = Integer.MIN_VALUE;
        int kinds = 0;

        for(int i=0; i<k; i++){
            if(cnt[sushi[++rear]] == 0){
                kinds++;
            }
            cnt[sushi[rear]]++;
        }

        while(rear%N != k-2){
            if(cnt[c] == 0){
                max = Math.max(kinds+1, max);
            }
            max = Math.max(kinds, max);
            
            if(cnt[sushi[front%N]]==1){
                kinds--;
            }
            cnt[sushi[front%N]]--;
            front++;

            rear++;
            if(cnt[sushi[rear%N]]==0){
                kinds++;
            }
            cnt[sushi[rear%N]]++;
        }
        System.out.println(max);
    }
}