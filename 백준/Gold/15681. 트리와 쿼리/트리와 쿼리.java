import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  static ArrayList<Integer>[] tree;
  static boolean[] visited;
  static int[] parent;
  static int[] counting;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int root = sc.nextInt();
    int nQuery = sc.nextInt();
    parent = new int[N+1];
    visited = new boolean[N+1];
    counting = new int[N+1];

    tree = new ArrayList[N+1];

    for(int i=1; i<=N; i++){
      tree[i] = new ArrayList<>();
    }

    for(int v=1; v<N; v++){
      int n1 = sc.nextInt();
      int n2 = sc.nextInt();

      tree[n1].add(n2);
      tree[n2].add(n1);
    }

    visited[root] = true;
    saveParent(root);
    visited = new boolean[N+1];
    countNodes(root);

    for(int q=0; q<nQuery; q++){
      int query = sc.nextInt();
      System.out.println(counting[query]);
    }
  }

  public static void countNodes(int p){
    counting[p] = 1;
    visited[p] = true;
    for(int node :tree[p]){
      if(!visited[node]) {
        countNodes(node);
        counting[p] += counting[node];
      }
    }
  }

  public static void saveParent(int p){
    for(int node : tree[p]){
      if(!visited[node]){
        visited[node] = true;
        parent[node] = p;
        saveParent(node);
      }
    }
  }
}