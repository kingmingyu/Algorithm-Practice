import java.util.*;
import java.io.*;

class Solution {
    static int max;
    static HashSet<String>[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] n = st.nextToken().toCharArray();
            int change = Integer.parseInt(st.nextToken());
            
            // 자료구조 초기화
            max = 0;
            visited = new HashSet[change + 1];
            
            for(int j = 0; j <= change; j++) {
                visited[j] = new HashSet<>();
            }
            dfs(n, 0, change);
            
            // 정답 출력
            System.out.println("#" +  i + " " + max);
        }
    }
    static void dfs(char[] arr, int cnt, int change) {
        if(cnt == change) {
            String num = "";
            for(int i = 0; i < arr.length; i++) {
                num += ""+ arr[i];
            }
            max = Math.max(Integer.parseInt(num), max);
            return;
        }
        
        String cur = "";
        for(int i = 0; i < arr.length; i++) {
            cur += arr[i];
        }
        if(!visited[cnt].add(cur)) {
            return;
        }
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                swap(arr, i, j);
                dfs(arr, cnt + 1, change);
                swap(arr, i, j);
            }
        }
    }
    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}