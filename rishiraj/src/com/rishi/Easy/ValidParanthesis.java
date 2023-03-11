package com.rishi.Easy;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for(char i : s.toCharArray()){
            if(i == '(' || i == '{' || i == '['){
                stack.push(i);
            } else {
                if(stack.isEmpty())
                    return false;
                char element = map.get(stack.pop());
                if(element != i)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
