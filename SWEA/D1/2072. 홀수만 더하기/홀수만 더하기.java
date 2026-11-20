import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        // 정답 배열
        int[] answer = new int[tc];
        
        for(int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur % 2 != 0) answer[i] += cur;
            }
        }
        
        // 정답 출력
        for(int i = 1; i <= tc; i++) {
            System.out.println("#" + i + " " + answer[i-1]);
        }
    }
}