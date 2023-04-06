import java.util.Scanner;

public class Solution {
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static boolean digged;
	static int lenWay;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][N];
			lenWay = Integer.MIN_VALUE;
			int highest = 0;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = sc.nextInt();
					highest = Math.max(highest, map[r][c]);
				}
			}

			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == highest) {
						visited = new boolean[N][N];
						digged = false;
						visited[r][c] = true;
						DFS(r, c, 1);
					}
				}
			}
			sb.append("#").append(t).append(" ").append(lenWay).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void DFS(int r, int c, int cnt) {
		
		lenWay = Math.max(lenWay, cnt);
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>= N || visited[nr][nc]) {
				continue;
			}
			
			if(map[nr][nc] < map[r][c]) {
				visited[nr][nc] = true;
				DFS(nr, nc, cnt+1);
				visited[nr][nc] = false;
			} else {
				if(!digged) {
					for(int k=1; k<=K; k++) {
						map[nr][nc]-=k;
						digged = true;
						if(map[nr][nc] < map[r][c]) {
							visited[nr][nc] = true;
							DFS(nr, nc, cnt+1);
							visited[nr][nc] = false;
						}
						map[nr][nc]+=k;
						digged = false;
					}
				}
			}
		}
	}
}