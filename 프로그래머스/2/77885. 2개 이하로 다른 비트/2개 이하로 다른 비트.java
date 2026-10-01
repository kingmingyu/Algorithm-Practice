class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            long cur = numbers[i];
            
            // 짝수
            if(cur % 2 == 0) {
                answer[i] = cur + 1;
            }
            // 홀수
            else {
                StringBuilder sb = new StringBuilder("0" + Long.toBinaryString(cur));
                int idx = sb.lastIndexOf("0");
                
                sb.setCharAt(idx, '1');
                sb.setCharAt(idx + 1, '0');
                
                answer[i] = Long.parseLong(sb.toString(), 2);
            }
        }
        
        return answer;
    }
}