import java.util.*;
import java.io.*;

class Solution {
    static int max;
    static int limit;
    static int N;
    static boolean[] visited;
    static int[] sArr;
    static int[] cArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            
            // 자료구조 초기화
            max = 0;
            visited = new boolean[N];
            sArr = new int[N];
            cArr = new int[N];
            
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                sArr[j] = Integer.parseInt(st.nextToken());
                cArr[j] = Integer.parseInt(st.nextToken());
            }
            
            for(int j = 0; j < N; j++) {
                if(cArr[j] > limit) continue;
                max = Math.max(max, sArr[j]);
                visited[j] = true;
                dfs(j, sArr[j], cArr[j]);
                visited[j] = false;
            }
            
            // 정답 출력
            System.out.println("#" + i + " " + max);
        }
    }
    
    static void dfs(int s, int score, int cal) {
        if(cal > limit) return;
        
        for(int i = s; i < N; i++) {
            if(visited[i] == false) {
                if(cal + cArr[i] <= limit) {
                    max = Math.max(score + sArr[i], max);
                    visited[i] = true;
                    dfs(i + 1, score + sArr[i], cal + cArr[i]);
                    visited[i] = false;
                }
            }
        }
    }
}