import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
DFS/BFS silver 1
 */
public class Main {

  static int row;
  static int col;
  static int[][] canvas;
  static boolean[][] visited;
  static int paintCnt = 0;
  static int largestArea = 0;

  static int[] dr = new int[] {-1, 1, 0, 0};
  static int[] dc = new int[] {0, 0, -1, 1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    row = sc.nextInt();
    col = sc.nextInt();

    canvas = new int[row][col];
    visited = new boolean[row][col];

    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        canvas[r][c] = sc.nextInt();
      }
    }

    for(int r=0; r<row; r++){
      for(int c=0; c<col; c++){
        if(canvas[r][c] == 1 && !visited[r][c]){
          countPaints(new Point(r, c));
          paintCnt++;
        }
      }
    }

    System.out.println(paintCnt);
    System.out.println(largestArea);
  }

  static void countPaints(Point point){
    int area = 1;

    Queue<Point> q = new LinkedList<>();
    q.offer(point);
    visited[point.r][point.c] = true;

    while(!q.isEmpty()){
      Point pointNow = q.poll();

      for(int d=0; d<4; d++){
        int nr = pointNow.r + dr[d];
        int nc = pointNow.c + dc[d];

        if(nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc]){
          continue;
        }

        if(canvas[nr][nc] == 1){
          q.offer(new Point(nr, nc));
          visited[nr][nc] = true;
          area++;
        }
      }
    }

    largestArea = largestArea<area? area:largestArea;
  }

  static class Point{
    int r;
    int c;

    public Point(int r, int c){
      this.r = r;
      this.c = c;
    }
  }
}