import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int row;
    static int col;
    static int[][] aisle;
    static boolean[][] visited;
    static int biggest = 0;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        col = sc.nextInt();
        int nFood = sc.nextInt();

        aisle = new int[row+1][col+1];
        visited = new boolean[row+1][col+1];

        for(int n=0; n<nFood; n++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            aisle[r][c] = 1;
        }

        for(int r=1; r<=row; r++){
            for(int c=1; c<=col; c++){
                if(aisle[r][c] == 1 && !visited[r][c]){
                    visited[r][c] =true;
                    BFS(new Position(r, c));
                }
            }
        }
        System.out.println(biggest);

    }

    public static void BFS(Position start){
        Queue<Position> q = new LinkedList<>();
        q.offer(start);

        int size = 0;
        while(!q.isEmpty()){
            Position curr = q.poll();
            size++;
            for(int d=0; d<4; d++){
                int nr = curr.r+dr[d];
                int nc = curr.c+dc[d];

                if(nr<1 || nr>row || nc<1 || nc>col){
                    continue;
                }
                if(!visited[nr][nc] && aisle[nr][nc] == 1){
                    visited[nr][nc] = true;
                    q.offer(new Position(nr, nc));

                }
            }
        }
        biggest = Math.max(biggest, size);
    }

    static class Position {
        int r;
        int c;

        public Position(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

}