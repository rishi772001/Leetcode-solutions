package com.rishi.Medium;
import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    private static List<String> ans;
    LetterCombinationsOfPhoneNumber(){
        ans = new ArrayList<>();
    }
    private static void findCombinations(String digits, int r, int start, String combination, HashMap<Integer, String> values){
        int n = digits.length();

        // fixed string + iterate with the remaining elements fro curr index
        for(int i = start; i < r; i++){
            // get characters of current digit
            String chars = values.get(Character.getNumericValue(digits.charAt(i)));

            for(char c : chars.toCharArray()){
                // add current character with existing combination
                String combined = combination + c;

                // search for new combinations
                findCombinations(digits, r, i + 1, combined, values);

                // if combination length is matched then add string to output
                if(combined.length() == r){
                    System.out.println(combined);
                    ans.add(combined);
                }
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        ans.clear();
        HashMap<Integer, String> values = new HashMap<>();
        values.put(2, "abc");
        values.put(3, "def");
        values.put(4, "ghi");
        values.put(5, "jkl");
        values.put(6, "mno");
        values.put(7, "pqrs");
        values.put(8, "tuv");
        values.put(9, "wxyz");

        findCombinations(digits, digits.length(), 0, "", values);
        return ans;
    }

    public static void main(String[] args) {
        new LetterCombinationsOfPhoneNumber().letterCombinations("233");
    }
}
