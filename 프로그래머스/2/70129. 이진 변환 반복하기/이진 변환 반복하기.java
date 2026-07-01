class Solution {
    public int[] solution(String s) {
        int zero = 0;
        int cnt = 0;
        while(!s.equals("1")) {
            int cur1 = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    zero++;
                }
                else {
                    cur1++;
                }
            }
            s = Integer.toBinaryString(cur1);
            cnt++;
        }
        int[] answer = new int[2];
        answer[0] = cnt;
        answer[1] = zero;
        return answer;
    }
}