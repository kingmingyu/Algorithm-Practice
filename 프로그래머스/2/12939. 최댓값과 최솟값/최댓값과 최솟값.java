class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int min = Integer.parseInt(nums[0]);
        int max = Integer.parseInt(nums[0]);
        
        for(int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);
            if(num > max) {
                max = num;
            }
            if(num < min) {
                min = num;
            }
        }
        String answer = min + " " + max;
        return answer;
    }
}