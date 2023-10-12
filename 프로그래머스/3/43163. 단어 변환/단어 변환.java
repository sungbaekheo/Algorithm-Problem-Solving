import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
    
    class Word {
        String word;
        int cnt;
        
        public Word(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) { 
        
        return findTheShortestStage(begin, target, words);
    }
    
    public int findTheShortestStage(String begin, String target, String[] words){
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));
        
        boolean[] visited = new boolean[words.length];
        
        while(!q.isEmpty()){
            Word curWord = q.poll();
            
            if(curWord.word.equals(target)){
                return curWord.cnt;
            }
            
            for(int i=0; i<words.length; i++){
                int count = 0;
                char[] wordArr = words[i].toCharArray();
                
                for(int j=0; j<wordArr.length; j++){
                    if(wordArr[j] != curWord.word.charAt(j)){
                        count++;
                    }
                }
                
                if(!visited[i] && count == 1){
                    q.offer(new Word(words[i], curWord.cnt+1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
}