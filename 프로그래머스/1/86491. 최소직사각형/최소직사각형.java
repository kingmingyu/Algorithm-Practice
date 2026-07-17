class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w = 0;
        int h = 0;
        for(int[] cur : sizes) {
            if(cur[0] <= w && cur[1] <= h || cur[0] <= h && cur[1] <= w) {
                // System.out.println("Pass/ cur[0]: " + cur[0] + "/ cur[1]: " + cur[1]);
                continue;
            }
            
            if(cur[0] >= cur[1]) {
                w = Math.max(cur[0], w);
                h = Math.max(cur[1], h);
            }
            else{
                w = Math.max(cur[1], w);
                h = Math.max(cur[0], h);
            }
            
        }
        // System.out.println("w: " + w + "/ h: " + h);
        return w * h;
    }
}