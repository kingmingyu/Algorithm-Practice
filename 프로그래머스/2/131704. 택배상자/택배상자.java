import java.util.*;
import java.io.*;

class Solution {
    public static Deque<Integer> container;
    public static Deque<Integer> temp;
    public static int answer;
    public int solution(int[] order) {
        // 스택
        container = new ArrayDeque<>();
        temp = new ArrayDeque<>();
        
        // 컨테이너 초기 세팅
        for(int i = order.length; i > 0; i--) {
            container.push(i);
        }
        
        // 싣기
        answer = 0;
        for(int i = 0; i < order.length; i++) {
            int box = order[i];
            boolean isGet = false;
            
            // 컨테이너, 임시 컨테이너 확인
            if(check(box)) {
                isGet = true;
                continue;
            }
            
            while(!container.isEmpty()) {
                temp.push(container.pop());
                if(check(box)){
                    isGet = true;
                    break;
                }
            }
            
            if(!isGet) break;
        }
        
        return answer;
    }
    
    public static boolean check(int box) {
        if(!container.isEmpty() && container.peek() == box) {
            answer++;
            container.pop();
            return true;
        }
        if(!temp.isEmpty() && temp.peek() == box) {
            answer++;
            temp.pop();
            return true;
        }
        return false;
    }
}