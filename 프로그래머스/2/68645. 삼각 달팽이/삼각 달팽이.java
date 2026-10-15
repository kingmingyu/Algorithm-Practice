class Solution {
    public int[] solution(int n) {
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            cnt += i;
        }
        int[] answer = new int[cnt];
        int[][] triArr = new int[n][n];
        int i = 0;
        int j = 0;
        int cur = 1;
        while(cur <= cnt) {
            while(cur <= cnt && i < n-1 && triArr[i+1][j] == 0) {
                // System.out.println("i: " + i + "/ j:" + j + "/ cur: " + cur);
                triArr[i++][j] = cur++;
            }
            
            while(cur <= cnt && j < n-1 && triArr[i][j+1] == 0) {
                // System.out.println("i: " + i + "/ j:" + j + "/ cur: " + cur);
                triArr[i][j++] = cur++;
            }
            
            while(cur <= cnt && triArr[i][j] == 0) {
                // System.out.println("i: " + i + "/ j:" + j + "/ cur: " + cur);
                triArr[i--][j--] = cur++;
            }
            i++; j++; i++;
            // System.out.println("cur: " + cur);
            // System.out.println("i: " + i + "/ j:" + j + "/ cur: " + cur);
        }
        // for(int[] t : triArr) {
        //     for(int c : t) {
        //         System.out.print(c + " ");
        //     }
        //     System.out.println();
        // }
        
        int answerIdx = 0;
        for(int idx = 0; idx < n; idx++) {
            for(int k = 0; k < n; k++) {
                if(triArr[idx][k] != 0) {
                    answer[answerIdx++] = triArr[idx][k];
                }
            }
        }
        return answer;
    }
}