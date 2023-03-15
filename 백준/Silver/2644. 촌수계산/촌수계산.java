import java.util.Scanner;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
  static int[][] graph;
  static int[] degree;
   public static void main(String args[]){ 
    Scanner sc = new Scanner(System.in);
    
    int num = sc.nextInt();
    graph = new int[num+1][num+1];
    degree = new int[num+1];

    int from = sc.nextInt();
    int to = sc.nextInt();
    
    int edge = sc.nextInt();
    for(int i=0; i<edge; i++){
      int r = sc.nextInt();
      int c = sc.nextInt();
      
      graph[r][c] = graph[c][r] = 1;
    }
    
    BFS(from, to);
  }
   static void BFS(int from, int to){
     Queue<Integer> q = new LinkedList<>();
     q.add(from);

     while(!q.isEmpty()){
       int curr = q.poll();
       for(int i=1; i<graph[curr].length; i++){
         if(graph[curr][i] != 0 && degree[i] == 0){
          degree[i] = degree[curr]+1;
          if(i == to){
            System.out.println(degree[to]);
            return;
          }
          q.add(i);
         }
       }
     }
     System.out.println(-1);
   } 
 }