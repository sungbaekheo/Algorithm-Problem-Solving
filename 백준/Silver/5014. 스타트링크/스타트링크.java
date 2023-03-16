import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main{

  static int total;
  static int[] floors;
    
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

     total = sc.nextInt();
     int start = sc.nextInt();
     int end = sc.nextInt();
     int up = sc.nextInt();
     int down = sc.nextInt();

     floors = new int[total+1];
     BFS(start, end, up, down);   
   }

   static void BFS(int s, int e, int u, int d){
     Queue<Integer> q = new LinkedList<>();
     q.add(s);
     floors[s] = 1;

     while(!q.isEmpty()){
       int curr = q.poll();
       if(curr == e){
         System.out.println(floors[curr]-1);
         return;
       }

       if(curr+u<=total && floors[curr+u] == 0){
         q.add(curr+u);
         floors[curr+u] = floors[curr]+1;
       }

       if(curr-d>0 && floors[curr-d] == 0) {
         q.add(curr-d);
         floors[curr-d] = floors[curr]+1;
       }
     }
     System.out.println("use the stairs");
   }
 }

