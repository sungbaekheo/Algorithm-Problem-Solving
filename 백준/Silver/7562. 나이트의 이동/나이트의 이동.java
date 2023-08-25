import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  static int size;
  static boolean[][] visited;

  static int[] dr = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
  static int[] dc = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testCase = sc.nextInt();

    for (int t = 1; t <= testCase; t++) {
      size = sc.nextInt();

      visited = new boolean[size][size];

      Point start = new Point(sc.nextInt(), sc.nextInt(), 0);
      Point target = new Point(sc.nextInt(), sc.nextInt(), 0);

      System.out.println(countTurnToReachTheTarget(start, target));
    }
  }

  static int countTurnToReachTheTarget(Point start, Point target) {
    Queue<Point> q = new LinkedList<>();
    q.offer(start);
    visited[start.r][start.c] = true;

    while(!q.isEmpty()) {
      Point night = q.poll();

      if(night.r == target.r && night.c == target.c){
        return night.move;
      }

      for (int d = 0; d < 8; d++) {
        int nr = night.r + dr[d];
        int nc = night.c + dc[d];

        if (nr < 0 || nr >= size || nc < 0 || nc >= size){
          continue;
        }

        if(!visited[nr][nc]){
          q.offer(new Point(nr, nc, night.move+1));
          visited[nr][nc] = true;
        }
      }
    }

    return 0;
  }

  static class Point {

    int r;
    int c;
    int move;

    public Point(int r, int c, int move) {
      this.r = r;
      this.c = c;
      this.move = move;
    }
  }
}