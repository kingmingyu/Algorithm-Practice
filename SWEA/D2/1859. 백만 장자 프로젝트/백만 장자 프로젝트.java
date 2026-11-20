import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        long[] answerArr = new long[tc];
        
        for(int i = 0; i < tc; i++) {
            int day = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] pArr = new int[day];
            
            for(int j = 0; j < day; j++) {
                pArr[j] = Integer.parseInt(st.nextToken());
            }
            
            int max = pArr[pArr.length-1];
            for(int j = pArr.length - 2; j >= 0; j--) {
                int cur = pArr[j];
                if(cur > max) {
                    max = cur;
                    continue;
                }
                else {
                    answerArr[i] += max - cur;
                }
            }
        }
        
        // 정답
        for(int i = 1; i <= tc; i++) {
            System.out.println("#" + i  + " " +answerArr[i-1]);
        }
	}
}