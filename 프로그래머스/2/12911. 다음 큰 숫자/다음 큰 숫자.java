class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String biN = Integer.toString(n, 2);
        int n1 = 0;
        for(int i = 0; i < biN.length(); i++) {
            if(biN.charAt(i) == '1') {
                n1 ++;
            }
        }
        
        for(int i = n + 1; i < 1000000; i++) {
            String curB = Integer.toString(i, 2);
            int c1 = 0;
            for(int j = 0; j < curB.length(); j++) {
                if(curB.charAt(j) == '1') {
                    c1++;
                }
            }
            if(c1 == n1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}