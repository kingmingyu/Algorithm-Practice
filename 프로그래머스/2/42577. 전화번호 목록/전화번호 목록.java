import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        
        HashSet<String> pSet = new HashSet<>();
        for(String p : phone_book) {
            for(int i = 0; i < p.length(); i++) {
                String check = p.substring(0, i);
                if(pSet.contains(check)) return false;
            }
            pSet.add(p);
        }
        return true;
    }
}