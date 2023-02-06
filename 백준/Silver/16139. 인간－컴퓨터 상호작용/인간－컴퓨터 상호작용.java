import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        char[] str = br.readLine().toCharArray();
        int qNum = Integer.parseInt(br.readLine());
        
        for(int q=0; q<qNum; q++){
            st = new StringTokenizer(br.readLine());
            char alphabet = st.nextToken().charAt(0);
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            int count = 0;
            for(int i=startPoint; i<=endPoint; i++){
                if(str[i] == alphabet){
                    count++;
                }
            }
            sb.append(count+"\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}