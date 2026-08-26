import java.util.*;
import java.io.*;

class Solution {
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 맵 만들기 n이 십만이므로 링크드 리스트 이용
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) map.add(new ArrayList<>());
        for(int[] r : roads) {
            map.get(r[0]).add(r[1]);
            map.get(r[1]).add(r[0]);
        }
        
        // 목적지에서 bfs
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(destination);
        int[] dist = new int[n + 1];
        for(int i = 0; i < n + 1; i++) {
            dist[i] = -1;
        }
        dist[destination] = 0;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int next : map.get(cur)) {
                if(dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                queue.add(next);
            }
        }
        
        
        // sources 까지의 거리
        int[] result = new int[sources.length];
        for(int i = 0; i < sources.length; i++) {
            result[i] = dist[sources[i]];
        }
        return result;
    }
}