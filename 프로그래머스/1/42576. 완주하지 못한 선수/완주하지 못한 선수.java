import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participants = new HashMap<>();
        for(String name : participant) {
            participants.put(name, participants.getOrDefault(name, 0) + 1);
        }
        
        for(String name : completion) {
            participants.put(name, participants.get(name) - 1);
        }
        
        for(String name : participants.keySet()) {
            if(participants.get(name) != 0) {
                return name;
            }
        }
        return "";
    }
}