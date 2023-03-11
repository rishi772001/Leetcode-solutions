package com.rishi.Medium;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<Integer, HashSet<Character>> box = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.')
                    continue;
                int boxIndex = 3 * (i / 3) + (j / 3);
                // check for row
                if(rows.containsKey(i)) {
                    if (rows.get(i).contains(board[i][j])){
                        System.out.println("rows" + i);
                        return false;
                    }
                    else
                        rows.get(i).add(board[i][j]);
                } else {
                    rows.put(i, new HashSet<>());
                    rows.get(i).add(board[i][j]);
                }

                // check for col
                if(cols.containsKey(j)) {
                    if (cols.get(j).contains(board[i][j])){
                        System.out.println("cols" + j);
                        return false;
                    }

                    else
                        cols.get(j).add(board[i][j]);
                } else {
                    cols.put(j, new HashSet<>());
                    cols.get(j).add(board[i][j]);
                }

                // check for box
                if(box.containsKey(boxIndex)) {
                    if (box.get(boxIndex).contains(board[i][j])){
                        System.out.println("box" + boxIndex);
                        return false;
                    }

                    else
                        box.get(boxIndex).add(board[i][j]);
                } else {
                    box.put(boxIndex, new HashSet<>());
                    box.get(boxIndex).add(board[i][j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(new ValidSudoku().isValidSudoku(board));
    }
}
