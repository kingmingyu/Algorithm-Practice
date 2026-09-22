class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] diff = new int[board.length+1][board[0].length+1];
        
        for(int[] cur : skill) {
            int isAttack = cur[0];
            int sx = cur[1]; int sy = cur[2];
            int ex = cur[3]; int ey = cur[4];
            int dmg = cur[5];
            if(isAttack == 1)
                dmg *= -1;
            
            diff[sx][sy] += dmg;
            diff[sx][ey+1] -= dmg;
            diff[ex+1][sy] -= dmg;
            diff[ex+1][ey+1] += dmg;
        }
        
        // 가로 방향 누적합
        for(int i = 0; i < board.length+1; i++) {
            for(int j = 1; j < board[0].length+1; j++) {
                diff[i][j] += diff[i][j-1];
            }
        }
        // 세로 방향 누적합
        for(int i = 1; i < board.length+1; i++) {
            for(int j = 0; j < board[0].length+1; j++) {
                diff[i][j] += diff[i-1][j];
            }
        }
        
        int answer = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] + diff[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}