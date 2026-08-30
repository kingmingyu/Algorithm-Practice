import java.util.*;
import java.io.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 가중치가 낮은 순으로 정렬(오름차순 정렬)
        Arrays.sort(costs, (int[] o1, int[] o2) -> {return o1[2] - o2[2];});
        
        parent = new int[n];
        // 부모 노드를 자기 자신으로 초기화
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // 낮은 것부터 돌면서 사이클을 생성하지 않는다면 연결(answer에 cost 추가)
        for(int[] cur : costs) {
            if(find(cur[0]) != find(cur[1])) {
                union(cur[0], cur[1]);
                answer += cur[2];
            }
        }
        
        return answer;
    }
    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        // 경로 압축(parent[x] == x일 때 까지 반복)
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX != rootY) {
            parent[rootY] = rootX;
        }
        return ;
    }
}



// import java.io.*;
// import java.util.*;

// class Solution {
//     static int[][] costsG;
//     static int nG;
//     static boolean[] visited;
//     static int[][] map;
//     static int answer = 100000;
//     static int temp = 0;
//     public int solution(int n, int[][] costs) {
//         // 자료구조 초기화
//         costsG = costs;
//         nG = n;
//         map = new int[n][n];
//         for(int[] cur : costs) {
//             map[cur[0]][cur[1]] = cur[2];
//             map[cur[1]][cur[0]] = cur[2];
//         }
//         visited = new boolean[n];
        
//         // dfs 호출
//         for(int i = 0; i < n; i++) {
//             visited[i] = true;
//             dfs(i, 1);
//             visited[i] = false;
//         }
        
//         return answer;
//     }
//     static void dfs(int s, int cnt) {
//         // n개의 정점을 모두 방문한 경우
//         if(cnt == nG) {
//             // System.out.println("===========");
//             // System.out.println("end: " + temp);
//             // System.out.println("===========");
            
//             answer = Math.min(temp, answer);
//             return;
//         }
        
//         for(int i = 0; i < nG; i++) {
//             if(map[s][i] != 0 && visited[i] == false) {
//                 visited[i] = true;
//                 temp += map[s][i];
//                 //System.out.println("cur: " + i + "costs: " + map[s][i]);
//                 dfs(i, cnt+1);
                
//                 // 백트래킹
//                 visited[i] = false;
//                 temp -= map[s][i];
//             }
//         }
//         return;
//     }
// }