import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> preAns = new ArrayList<>();
        
        Map<String, Integer> musicMap = new HashMap<>();
        Map<String, PriorityQueue<Music>> musicQ = new HashMap<>();
        PriorityQueue<Genre> genreQ = new PriorityQueue<>();
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            Music music = new Music(i, play);
            
            if(musicMap.getOrDefault(genre, -1) == -1){
                musicQ.put(genre, new PriorityQueue<Music>());    
            }
            
            musicMap.put(genre, musicMap.getOrDefault(genre, 0)+play);
            musicQ.get(genre).offer(music);
        }
        
        for(String key : musicMap.keySet()){
            genreQ.offer(new Genre(key, musicMap.get(key)));
        }
        
        while(!genreQ.isEmpty()){
            Genre genre = genreQ.poll();
            PriorityQueue<Music> pq = musicQ.get(genre.name);
            for(int i=0; i<2; i++){
                if(pq.isEmpty()){
                    break;
                }
                preAns.add(pq.poll().no);
            }
        }
        
        answer = preAns.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
    
    class Music implements Comparable<Music>{
        int no;
        int cnt;
        
        public Music(int no, int cnt){
            this.no = no;
            this.cnt = cnt;
        }
        
        public int compareTo(Music m){
            return m.cnt - this.cnt;
        }
    }
    
    class Genre implements Comparable<Genre>{
        String name;
        int cnt;
        
        public Genre(String name, int cnt){
            this.name = name;
            this.cnt = cnt;
        }
        
        public int compareTo(Genre g){
            return g.cnt - this.cnt;
        }
    }
}