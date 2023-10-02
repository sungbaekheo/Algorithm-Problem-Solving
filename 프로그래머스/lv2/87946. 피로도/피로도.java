class Solution {
    
    int maxCount = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        int[][] permutation = new int[dungeons.length][2];
        boolean[] visited = new boolean[dungeons.length];
        
        getPermutation(dungeons, permutation, visited, 0, dungeons.length, k);
        
        return maxCount;
    }
    
    public void completeDungeons(int[][] permutation, int k){
        
        int count = 0;
        
        for(int[] dungeon : permutation){
            if(dungeon[0]<=k){
                k-=dungeon[1];
                count++;
            }
        }
        
        maxCount = maxCount>count? maxCount:count;
        return;
    }
    
    public void getPermutation(int[][] dungeons, int[][] permutation, boolean[] visited, int depth, int length, int k){
        
        if(depth == length){
            completeDungeons(permutation, k);
            return;
        }
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i]){
                visited[i] = true;
                permutation[depth] = dungeons[i];
                getPermutation(dungeons, permutation, visited, depth+1, length, k);
                visited[i] = false;
            }
        }
    }
}