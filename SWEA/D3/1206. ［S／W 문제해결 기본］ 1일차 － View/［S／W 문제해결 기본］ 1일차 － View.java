import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] answerArr = new int[10];
        
        for(int i = 0; i < 10; i++) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 빌딩 배열
            int[] bArr = new int[len];
            for(int j = 0; j < len; j++) {
                bArr[j] = Integer.parseInt(st.nextToken());
            }
            
            // 조망권 확보(가로 길이가 1000 이하 이므로 해당 건물다가 양 옆 2칸 계산 & 비교)
            for(int j = 2; j < len - 2; j++) {
                int max = Math.max(bArr[j-2], Math.max(bArr[j-1], Math.max(bArr[j+1], bArr[j+2])));
                int cur = bArr[j];
                if(cur > max) answerArr[i] += cur - max;
            }
        }
        
        // 정답 출력
        for(int i = 1; i <= 10; i++) {
            System.out.println("#" + i + " " + answerArr[i-1]);
        }
    }
}