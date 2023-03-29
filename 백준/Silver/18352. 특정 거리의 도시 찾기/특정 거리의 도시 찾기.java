import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // 노드의 수
    int M = sc.nextInt(); // 간선의 수
    int K = sc.nextInt(); // 구하고자 하는 거리
    int X = sc.nextInt(); // 출발 시티
  
    List<Integer>[] cities = new ArrayList[N+1];
    for(int i=0; i<=N; i++){
      cities[i] = new ArrayList<>();
    }
    for(int i=0; i<M; i++){
      int s = sc.nextInt(); // 앞 노드
      int e = sc.nextInt(); // 뒷 노드
      cities[s].add(e);
    }

    BFS(cities, K, X);
  }

  static void BFS(List<Integer>[] list, int target, int start){
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[list.length];
    int[] distance = new int[list.length];
    int count = 0;
    boolean isTrue = false;
    q.offer(start);
    visited[start] = true;
    distance[start] = count;
    while(!q.isEmpty()){
      int curr = q.poll();
      for(int i=0; i<list[curr].size(); i++){
        if(visited[list[curr].get(i)]){
          continue;
        }
        q.offer(list[curr].get(i));
        visited[list[curr].get(i)] = true;
        distance[list[curr].get(i)] = distance[curr]+1;
      }
    }
    for(int i=0; i<list.length; i++){
      if(distance[i] == target){
        isTrue = true;
        System.out.println(i);
      }
    }
    if(!isTrue){
      System.out.println(-1);
    }
    
  }
}