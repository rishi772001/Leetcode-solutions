package com.rishi.Medium;

public class CountAndSay {
    private String calculate(String str){
        int count = 0;
        char curr = ' ';

        String ans = "";
        for(char i : str.toCharArray()){
            if(curr == ' '){
                curr = i;
                count++;
            } else if(curr == i){
                count++;
            } else {
                ans = ans + count + curr;
                curr = i;
                count = 1;
            }
        }
        ans = ans + count + curr;

        return ans;
    }
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        return calculate(countAndSay(n - 1));
    }
}
