import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        String[][] fArr = new String[files.length][3];
        int idx = 0;
        
        for(String f : files) {
            
            // 파일 안에서 머리, 숫자, 꼬리 구분하기
            for(int i = 0; i < f.length(); i++) {
                char curChar = f.charAt(i);
                if(curChar >= '0' && curChar <= '9') {
                    int numS = i;
                    int numE = i;
                    while(numE - numS < 5 && 
                          (curChar >= '0' && curChar <= '9')) {
                        numE++;
                        if(numE < f.length())
                            curChar = f.charAt(numE);
                        else {
                            break;
                        }
                    }
                    
                    String head = f.substring(0, numS);
                    String number = f.substring(numS, numE);
                    String tail = f.substring(numE, f.length());
                    
                    fArr[idx][0] = head;
                    fArr[idx][1] = number;
                    fArr[idx][2] = tail;
                    idx++;
                    break;
                }
            }
        }
        
        Arrays.sort(fArr, (o1, o2) -> {
            if(o1[0].toUpperCase().equals(o2[0].toUpperCase())) 
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            return o1[0].toUpperCase().compareTo(o2[0].toUpperCase());
        });
        
        String[] answer = new String[files.length];
        idx = 0;
        for(String[] cur : fArr) {
            answer[idx++] = cur[0]+cur[1]+cur[2];
        }
        return answer;
    }
}