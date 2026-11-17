import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        // 음악시간, 이름, 음
        String[][] mArr = new String[musicinfos.length][3];
        
        for(int i = 0; i < musicinfos.length; i++) {
            String[] curArr = musicinfos[i].split(",");
            
            mArr[i][0] = getTime(curArr[0], curArr[1]);
            mArr[i][1] = curArr[2];
            
            String curM = convert(curArr[3]);
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            for(int j = 0; j < Integer.parseInt(mArr[i][0]); j++) {
                sb.append(curM.charAt(idx));
                idx = (idx + 1) % curM.length();
            }
            mArr[i][2] = sb.toString();
        }
        
        // 재생시간이 긴 순으로 정렬
        Arrays.sort(mArr, (o1, o2) -> {
            return Integer.parseInt(o2[0]) - Integer.parseInt(o1[0]);
        });
        
        for(int i = 0; i < mArr.length; i++) {
            String curM = mArr[i][2];
            m = convert(m);
            
            if(curM.contains(m)) {
                return mArr[i][1];
            }
        }
        
        return "(None)";
    }
    
    static String getTime(String s, String e) {
        String[] sT = s.split(":");
        String[] eT = e.split(":");
        
        return String.valueOf(
            (Integer.parseInt(eT[0]) - Integer.parseInt(sT[0])) * 60 
            + Integer.parseInt(eT[1]) - Integer.parseInt(sT[1]));
    }
    private String convert(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
}