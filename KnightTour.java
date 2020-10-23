class KnightTour {
    private int [] [] board = new int [8][8];
    private  int nextRow[] = {-1,-2,-2,-1,1,2,2,1};
    private  int nextCol[] = {2,1,-1,-2,-2,-1,1,2};

    public KnightTour(){
    }

    public void startTour() {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                board[i][j] = 0;
        if (!path(0, 0, 1)) {
            System.out.println("Solution does not exist");
        } else
            print();
    }

    public  boolean path(int row, int col, int position) {
        if (position == 64)
            return true;
        for (int i = 0; i < 8; i++) {
            if (isValid(row+nextRow[i], col+nextCol[i])) {
                board[row + nextRow[i]][col + nextCol[i]] = position;
                if (path(row + nextRow[i], col + nextCol[i], board[row + nextRow[i]][col + nextCol[i]] + 1))
                    return true;
                else
                    board[row + nextRow[i]][col + nextCol[i]] = 0;
            }
        }
        return false;
    }

    public  boolean isValid(int row, int col) {
        if (row >= 0 && row < 8 && col >= 0 && col < 8 && board[row][col] == 0){
            return true;
        }
        return false;
    }


    public  void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                System.out.print(board[i][j] + "\t");
            System.out.println();
        }
    }

}


