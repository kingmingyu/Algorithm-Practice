import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        
        HashSet<String> reportSet = new HashSet<>();
        for(int i = 0; i < report.length; i++) {
            reportSet.add(report[i]);
        }
        
        // 맴버 인덱스
        HashMap<String, Integer> member = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            member.put(id_list[i], i);
        }
        
        // 신고 횟수 누적
        HashMap<String, Integer> reportCnt = new HashMap<>();
        for(String r : reportSet) {
            String[] curR = r.split(" ");
            reportCnt.put(curR[1], reportCnt.getOrDefault(curR[1], 0) + 1);
        }
        
        for(String r : reportSet) {
            String[] curR = r.split(" ");
            if(reportCnt.get(curR[1]) >= k) {
                result[member.get(curR[0])]++;
            }
        }
        
        return result;
    }
}