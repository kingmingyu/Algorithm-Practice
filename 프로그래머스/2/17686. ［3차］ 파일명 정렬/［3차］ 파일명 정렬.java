import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        String[][] answer = new String[files.length][3];
        for(int i = 0; i < files.length; i++) {
            String curF = files[i];
            
            int ns = 0;
            int ne = 0;
            boolean isDigit = false;
            for(int j = 0; j < curF.length(); j++) {
                if(isDigit == false && curF.charAt(j) >= '0' && curF.charAt(j) <= '9') {
                    ns = j;
                    ne = ns;
                    isDigit = true;
                }
                if(isDigit == true) {
                    if((curF.charAt(j) >= '0' && curF.charAt(j) <= '9')
                       && ne - ns < 5
                       && ne < curF.length()) {
                        ne++;
                    }
                    else {
                        break;
                    }
                } 
            }
            String head = curF.substring(0, ns);
            String number = curF.substring(ns, ne);
            String tail = curF.substring(ne, curF.length());
            
            answer[i][0] = head;
            answer[i][1] = number;
            answer[i][2] = tail;
        }
        
        // 정렬
        Arrays.sort(answer, (o1, o2) -> {
            if(o1[0].toUpperCase().equals(o2[0].toUpperCase())) {
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }
            return o1[0].toUpperCase().compareTo(o2[0].toUpperCase());
        });
        
        // 정답 만들기
        String[] sortAnswer = new String[files.length];
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for(String[] f : answer) {
            sortAnswer[i++] = sb.append(f[0]).append(f[1]).append(f[2]).toString();
            sb = new StringBuilder();
        }
        return sortAnswer;
    }
}