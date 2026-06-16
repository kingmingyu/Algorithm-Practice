import java.io.*;
import java.util.*;

class Solution {
    class Song implements Comparable<Song> {
        int id;
        String genre;
        int play;
        
        public Song(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song other) {
            if(this.play == other.play) {
                return this.id - other.id;
            }
            return other.play - this.play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        
        // 1. 장르별 총 재생횟수 구하기
        HashMap<String, Integer> ranks = new HashMap<>();
        ArrayList<Song> songs = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++) {
            ranks.put(genres[i], ranks.getOrDefault(genres[i], 0) + plays[i]);
            songs.add(new Song(i, genres[i], plays[i]));
        }
        
        // 장르에서 내림차순 정렬
        ArrayList<String> sortedG = new ArrayList<>(ranks.keySet());
        sortedG.sort((g1, g2) -> ranks.get(g2) - ranks.get(g1));
        
        // 곡 정렬
        Collections.sort(songs);
        
        // 정렬된 장르 순서대로 곡 2개씩 뽑기
        ArrayList<Integer> answerList = new ArrayList<>();
        for(String genre : sortedG) {
            int count = 0;
            for(Song song : songs) {
                if(song.genre.equals(genre)) {
                    answerList.add(song.id);
                    count++;
                }
                if(count == 2) {
                    break;
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
        
    }
}