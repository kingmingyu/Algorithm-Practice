import java.util.*;
import java.io.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        while(n > 1) {
            n /= 2;
            //System.out.println("a:" + a + "/ b:" + b + "/ n:" + n);
            if(a > n && b <= n || a <= n && b > n) {
                int answer = 0;
                while(n > 1) {
                    System.out.println(n);
                    answer ++;
                    n /= 2;
                }
                return answer + 1;
            }
            else {
                while(true) {
                    if(a - n < 0 || b - n < 0) {
                        break;
                    }
                    a -= n; b -= n;
                }
            }
        }
        return 1;
    }
}
       
//    4       7
//  2   4   6   7
// 1 2 3 4 5 6 7 8