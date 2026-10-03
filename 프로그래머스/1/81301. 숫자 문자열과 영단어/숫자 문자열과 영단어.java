class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur >= '0' && cur <= '9') {
                sb.append(cur);
            }
            else {
                int idx = i;
                String str = s.substring(i, idx);
                while(changeInt(str) == -1) {
                    idx++;
                    str = s.substring(i, idx);
                }
                i = idx-1;
                sb.append(changeInt(str));
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
    
    static int changeInt (String cur) {
        if(cur.equals("one")) {
            return 1;
        }
        else if(cur.equals("two")) {
            return 2;
        }
        else if(cur.equals("three")) {
            return 3;
        }
        else if(cur.equals("four")) {
            return 4;
        }
        else if(cur.equals("five")) {
            return 5;
        }
        else if(cur.equals("six")) {
            return 6;
        }
        else if(cur.equals("seven")) {
            return 7;
        }
        else if(cur.equals("eight")) {
            return 8;
        }
        else if(cur.equals("nine")) {
            return 9;
        }
        else if(cur.equals("zero")) {
            return 0;
        }
        else {
            return -1;
        }
    }
}