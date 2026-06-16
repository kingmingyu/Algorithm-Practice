import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        HashSet<String> set = new HashSet<>();
        
        for(String cur : phone_book) {
            set.add(cur);
        }
        
        for(String cur : phone_book) {
            for(int i = 0; i < cur.length(); i++) {
                String sub = cur.substring(0,i);
                if(set.contains(sub)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}