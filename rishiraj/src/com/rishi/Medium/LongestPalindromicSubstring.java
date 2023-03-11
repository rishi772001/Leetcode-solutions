package com.rishi.Medium;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        /*
        initially fill the diagonal and diagonal + 1
          b a b a d
        b 1 0
        a   1 0
        b     1 0
        a       1 0
        d         1

        CONDITION:

        palindrome => first_char == last_char and in between string is palindrome
         */
        int n = s.length();
        int[][] dp = new int[n][n];
        int start = 0, end = 0, maxLength = 1;

        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if(i < n - 1){
                if (s.charAt(i) == s.charAt(i + 1)){
                    dp[i][i + 1] = 1;
                    if(maxLength < 2){
                        start = i;
                        end = i + 1;
                        maxLength = 2;
                    }
                }
            }
        }

        for(int count = 2; count < n; count++){
            for(int i = 0; i < n - count; i++){
                int j = i + count;
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1){
                    dp[i][j] = 1;
                    if(maxLength < (j - i + 1)){
                        start = i;
                        end = j;
                        maxLength = j - i + 1;
                    }
                }

            }
        }

        System.out.println(maxLength);

        for (int[] ints : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }
}
