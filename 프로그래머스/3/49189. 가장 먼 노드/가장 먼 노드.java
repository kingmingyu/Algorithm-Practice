import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // ArrayList를 이용한 map 구성
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }
        for(int[] e : edge) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        // 거리 + 방문 배열
        int[] visited = new int[n + 1];
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = 1;
        int maxDist = 0;
        // bfs
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int i : map.get(cur)) {
                if(visited[i] == 0) {
                    visited[i] = visited[cur] + 1;
                    queue.offer(i);
                    maxDist = Math.max(maxDist, visited[i]);
                }
            }
        }
        
        int answer = 0;
        for(int d : visited) {
            if(d == maxDist) answer++;
        }
        return answer;
    }
}