import java.util.Scanner;

public class Main {

    static int N, S;
    static int[] numArr;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        numArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = sc.nextInt();
        }

        dfs(0, 0);

        System.out.println(S == 0? answer-1:answer);
    }

    public static void dfs(int cnt, int sum){
        if(cnt == N){
            if(sum == S){
                answer++;
            }
            return;
        }

        dfs(cnt+1, sum+numArr[cnt]);
        dfs(cnt+1, sum);
    }
}