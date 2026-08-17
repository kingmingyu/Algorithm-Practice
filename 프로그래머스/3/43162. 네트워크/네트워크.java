class Solution {
    static int[][] map;
    static int nG;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        nG = n;
        map = computers;
        visited = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                //System.out.println(i);
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    public static void dfs(int s) {
        for(int i = 0; i < nG; i++) {
            //System.out.println("search: " + i);
            if(map[s][i] == 1 && visited[i] == false) {
                //System.out.println("visited: " + i);
                visited[i] = true;
                dfs(i);
            }
        }
    }
}