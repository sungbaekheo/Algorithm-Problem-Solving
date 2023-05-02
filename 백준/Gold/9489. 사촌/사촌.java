import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int[] tree = new int[N+1];
            int[] parent = new int[N+1];
            parent[0] = -1;
            int count = 0;
            if(N == 0 && target == 0){
                break;
            }

            st = new StringTokenizer(br.readLine());

            int pIdx = 0;
            int targetP = 0;
            int parentP = 0;
            for(int i=1; i<=N; i++){
                int now = Integer.parseInt(st.nextToken());
                tree[i] = now;
                if(i>1){
                    if(now - tree[i-1] != 1){
                        pIdx++;
                    }
                    parent[i] = pIdx;
                }
                if(now == target){
                    targetP = pIdx;
                    parentP = parent[pIdx];
                }
            }

            for(int i=1; i<=N; i++){
                if(parent[i] != targetP && parent[parent[i]] == parentP){
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}