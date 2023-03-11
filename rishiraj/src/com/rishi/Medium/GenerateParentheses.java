package com.rishi.Medium;

import java.util.*;

public class GenerateParentheses {
    private void generate(List<String> ans, int open, int close, String str){
        // if all parenthesis is used, add str to result
        if(open == 0 && close == 0)
            ans.add(str);

        // add open bracket if open is available
        if(open != 0)
            generate(ans, open - 1, close, str + '(');

        // add close bracket only if there is a open bracket and close is available
        if(open < close && close != 0)
            generate(ans, open, close - 1, str + ')');
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        // initially both open and close is n
        generate(ans, n, n, "");
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3).toString());
    }

}
