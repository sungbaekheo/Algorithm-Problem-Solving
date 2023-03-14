import java.util.Scanner;

public class Main {
  static boolean[] visited;
  static int[][] graph;
  static int size;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    size = sc.nextInt();
    int N = sc.nextInt();

    graph = new int[size+1][size+1];
    visited = new boolean[size+1];

    for(int i=0; i<N; i++){
      int r = sc.nextInt();
      int c = sc.nextInt();
      graph[r][c] = graph[c][r] = 1;
    }

    int connected = 0;
    for(int i=1; i<size+1; i++){
      if(visited[i] == false){
        connected++;
        DFS(i);
      }
    }
    System.out.println(connected);
  }

  static void DFS(int i){
    if(visited[i] == true){
      return;
    } else {
      visited[i] = true;
      for(int j=1; j<size+1; j++){
        if(graph[i][j] == 1){
          DFS(j);
        }
      }
    }
  }
}