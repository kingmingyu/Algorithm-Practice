class Solution {
    public long solution(int n) {
        long answer = pib(n);
        return answer;
    }
    public long pib(long n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int p1 = 1;
        int p2 = 2;
        int temp;
        for(int i = 2; i < n; i++) {
            temp = p2;
            p2 = (temp + p1) % 1234567;
            p1 = temp;
        }
        return p2;
    }
}
/*
1-> 1         => 1
2-> 1 + 1     => 2
3-> 1 + 2     => 3
4-> 1 + 3 + 1 => 5
5-> 1 + 4 + 3 => 8
6-> 1 + 5 + 4 + 1 => 13
*/
