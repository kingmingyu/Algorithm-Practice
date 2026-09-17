class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n >= 1) {
            sb.append(To123(n % 3));
            n = (n - 1) / 3;
        }
        StringBuilder answer = new StringBuilder();
        for(int i = sb.length() - 1; i >= 0; i--) {
            answer.append(sb.charAt(i));
        }
        return answer.toString();
    }
    
    public String To123(int n) {
        if(n == 0) return "4";
        else return String.valueOf(n);
    }
}