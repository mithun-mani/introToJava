public class KnightsTour {
    public static void main(String[] args) {
        startTour();
    }

    private static int [] [] board = new int [8][8];
    private static int arrayH[] = {-1,-2,-2,-1,1,2,2,1};
    private static int arrayV[] = {2,1,-1,-2,-2,-1,1,2};
    public static void startTour(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = 0;
            }
        }
        if (!path(0,0,0)){
            System.out.println("Solution does not exist");
        }
        else{
            print();
        }
    }

    public static boolean isValid(int row, int col){
        if (row >= 0 && row < 8 && col >= 0 && row < 8){
            return true;
        }
        else return false;
    }

    public static boolean path(int row, int col,int position){
        if (position == 64){
            return true;
        }
        for(int i = 0; i < 8; i++){
            if((isValid(row + arrayH[i], col+arrayV[i]))){
                board[row + arrayH[i]][col + arrayV[i]] = position;
                    if(path(row + arrayH[i], col+arrayV[i], board[row + arrayH[i]][col + arrayV[i]] + 1)){
                        return true;
                }
                    else{
                        board[row + arrayH[i]][col + arrayV[i]] = 0;
                    }

            }

        }
        return false;
    }

    public static void print(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
