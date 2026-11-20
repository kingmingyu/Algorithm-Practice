import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            
            int idx = 0;
            int x = 0;
            int y = 0;
            while(idx < n * n) {
                // 왼쪽 -> 오른쪽
                while(idx < n*n && x < n && arr[y][x] == 0) {
                    arr[y][x] = idx + 1;
                    idx++; x++;
                }
                x--;
                y++;
                // 오른쪽 -> 아래
                while(idx < n*n && y < n && arr[y][x] == 0) {
                    arr[y][x] = idx + 1;
                    idx++; y++;
                }
                y--;
                x--;
                // 아래 오른쪽 -> 왼쪽
                while(idx < n*n && x >= 0 && arr[y][x] == 0) {
                    arr[y][x] = idx + 1;
                    idx++; x--;
                }
                x++;
                y--;
                // 아래 -> 위
                while(idx < n*n && y >= 0 && arr[y][x] == 0) {
                    arr[y][x] = idx + 1;
                    idx++; y--;
                }
                y++;
                x++;
            }
            
            
            // 정답 출력
            System.out.println("#" + i);
            for(int[] a : arr) {
                for(int cur : a) {
                    System.out.print(cur + " ");
                }
                System.out.println();
            }
        }
    }
}