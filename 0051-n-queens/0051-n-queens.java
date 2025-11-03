class Solution {

    List<List<String>> res = new ArrayList<>();
    boolean[] col;
    boolean[] diag1; // r - c
    boolean[] diag2; // r + c

    public List<List<String>> solveNQueens(int n) {

        col = new boolean[n];
        diag1 = new boolean[2*n - 1];
        diag2 = new boolean[2*n - 1];

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');

        backtrack(0, n, board);
        return res;
    }

    void backtrack(int row, int n, char[][] board) {
        if (row == n) {
            res.add(construct(board));
            return;
        }

        for (int c = 0; c < n; c++) {

            int d1 = row - c + n - 1;
            int d2 = row + c;

            if (col[c] || diag1[d1] || diag2[d2]) continue;

            board[row][c] = 'Q';
            col[c] = diag1[d1] = diag2[d2] = true;

            backtrack(row + 1, n, board);

            board[row][c] = '.';
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }

    List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] r : board) list.add(new String(r));
        return list;
    }
}
