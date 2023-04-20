import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Point> q = new LinkedList<>();
        
        int goal = sc.nextInt();
        boolean[][] visited = new boolean[1001][1001];
        
        visited[1][0] = true;
        q.offer(new Point(1, 0, 0));

        while(!q.isEmpty()){
            Point curr = q.poll();
            if(curr.p == goal){
                System.out.println(curr.task);
                break;
            }
            if(!visited[curr.p][curr.p]){
                q.offer(new Point(curr.p, curr.p, curr.task+1));
            }
            
            int next = curr.p + curr.clipBoard;
            if(next <= 1000 && !visited[next][curr.clipBoard] && curr.clipBoard>0){
                visited[next][curr.clipBoard] = true;
                q.offer(new Point(next, curr.clipBoard, curr.task+1));
            }
            next = curr.p - 1;
            if(next>1 && !visited[next][curr.clipBoard]){
                visited[next][curr.clipBoard] = true;
                q.offer(new Point(next, curr.clipBoard, curr.task+1));
            }
        }   
    }

    static class Point{
        int p;
        int clipBoard;
        int task;
        
        public Point(int p, int clipBoard, int task){
            this.p = p;
            this.clipBoard = clipBoard;
            this.task = task;
        }
    }
    }