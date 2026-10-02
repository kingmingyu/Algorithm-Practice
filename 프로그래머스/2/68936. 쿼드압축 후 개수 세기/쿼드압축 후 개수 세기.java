class Solution {
    static int[] answer;
    static int[][] arrG;
    public int[] solution(int[][] arr) {
        answer = new int[2]; arrG = arr;
        // 쿼드 압축
        check(0, arr.length, 0, arr[0].length);
        
        return answer;
    }
    public void check(int xs, int xe, int ys, int ye) {
        
        int cur = arrG[xs][ys];
        
        // 종료 조건
        if(xs >= xe || ys >= ye) {
            answer[cur]++;
            return;
        }
        
        
        // 쿼드 압축 시 모두 같은지 체크
        for(int i = xs; i < xe; i++) {
            for(int j = ys; j < ye; j++) {
                if(cur != arrG[i][j]) {
                    // 분할해서 다시 호출
                    check(xs, (xs+xe)/2, ys, (ys+ye)/2);
                    check((xs+xe)/2, xe, ys, (ys+ye)/2);
                    check(xs, (xs+xe)/2, (ys+ye)/2, ye);
                    check((xs+xe)/2, xe, (ys+ye)/2, ye);
                    return;
                }
            }
        }
        // 모두 같은 경우
        answer[cur] ++;
    }
}