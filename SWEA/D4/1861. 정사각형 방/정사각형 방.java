import java.util.Scanner;

public class Solution{
	
	static int size;
	static int[][] map;
	static int globalMaxDistance = -1;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
    
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++){
			size = sc.nextInt();
			map = new int[size][size];
			
			for(int r=0; r<size; r++){
				for(int c=0; c<size; c++){
					map[r][c] = sc.nextInt();
				}
			}
      
			int maxDistance = -1;
			int startPoint = size*size;
			for(int r=0; r<size; r++){
				for(int c=0; c<size; c++){
					globalMaxDistance = -1;
					int distance = 1;
					distance = wayFinder(r, c, distance);
          
					if(distance>maxDistance){
						maxDistance = distance;
						startPoint = map[r][c];
					} else if(distance == maxDistance){
						if(startPoint>map[r][c]){
							startPoint = map[r][c];
						}
					}
				}
			}
	      sb.append(String.format("#%d %d %d\n", t, startPoint, maxDistance));
		}
    	System.out.println(sb.toString());
	}
  
  	static int wayFinder(int r, int c, int distance){
  		
		int[] dr = {-1, 1, 0, 0};
	    int[] dc = {0, 0, -1, 1};
	    
	    for(int d=0; d<4; d++) {
	    	int nr = r+dr[d];
	    	int nc = c+dc[d];
	    	
	    	if(nr>=0 && nr<size && nc>=0 && nc<size) {
	    		if(map[nr][nc] - map[r][c] == 1) {
	    			distance++;
	    			distance = wayFinder(nr, nc, distance);
	    		} else {
	    			if(distance>globalMaxDistance) {
	    				globalMaxDistance = distance;
	    			}
	    		}
	    	}
	    }
	    return globalMaxDistance;
  	}
}