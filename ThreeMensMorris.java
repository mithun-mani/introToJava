import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ThreeMensMorris extends JFrame {
    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new ThreeMensMorris();
        }
        });
    }
    
    private GameButton[] grid = new GameButton[9];
    private int[][] board = new int[3][3];
    private boolean[][] ValidMove = new boolean[3][3];
    private Color xColor = Color.red;
    private Color oColor = Color.blue;
    private int player = 1;
    private int tokensLeft = 6;
    private String xName = "Player X";
    private String oName = "Player O";

    private ThreeMensMorris() {
        launch();
    }

    private static final long serialVersionUID = 1L;
    private class GameButton extends JButton {
        private static final long serialVersionUID = 1L;
        private GameButton(int id) {
            this.id = id;
            setFont(new Font(getFont().getClass().getName(), Font.BOLD, 128));
        }
        private int id;
    }

    private boolean checkWin() {
        return board[0][0] == player && board[0][1] == player && board[0][2] == player ||
                board[1][0] == player && board[1][1] == player && board[1][2] == player ||
                board[2][0] == player && board[2][1] == player && board[2][2] == player ||
                board[0][0] == player && board[1][0] == player && board[2][0] == player ||
                board[0][1] == player && board[1][1] == player && board[2][1] == player ||
                board[0][2] == player && board[1][2] == player && board[2][2] == player ||
                board[0][0] == player && board[1][1] == player && board[2][2] == player ||
                board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }
    private boolean isValidMove(int row, int col) {
        return ValidMove[row][col];
    }
    private void clearValidMoves() {
        ValidMove = new boolean[3][3];
    }
    private void setValidMove(int row,int col) {
        ValidMove[row][col] = true;
    }
    private void setAdjacentsValid(int row, int col){
        if ((row<=1) && (board[row+1][col]==0)){
            ValidMove[row+1][col]=true;
        }
        if ((row>=1) && (board[row-1][col]==0)){
            ValidMove[row-1][col]=true;
        }
        if ((col<=1) && (board[row][col+1]==0)){
            ValidMove[row][col+1]=true;
        }
        if ((col>=1) && (board[row][col-1]==0)){
            ValidMove[row][col-1]=true;
        }
        if((((row==0) && (col==0))||((row==0) && (col==2))||((row==2) && (col==0))||((row==2) && (col==2))) && (board[1][1]==0)){
            ValidMove[1][1]=true;
        }
        if((row == 1 && col == 1)) {
            if (board[0][0]==0) ValidMove[0][0] = true;
            if (board[0][2]==0) ValidMove[0][2] = true;
            if (board[2][0]==0) ValidMove[2][0] = true;
            if (board[2][2]==0) ValidMove[2][2] = true;
        }
    }

    private boolean hasValidMoves(int row, int col){
        if ((row<=1) && (board[row+1][col]==0)){
            return true;
        }
        if ((row>=1) && (board[row-1][col]==0)){
            return true;
        }
        if ((col<=1) && (board[row][col+1]==0)){
            return true;
        }
        if ((col>=1) && (board[row][col-1]==0)){
            return true;
        }
        if((((row==0) && (col==0))||((row==0) && (col==2))||((row==2) && (col==0))||((row==2) && (col==2))) && (board[1][1]==0)){
            return true;
        }
        if((row == 1 && col == 1)) {
            if (board[0][0]==0) return true;
            if (board[0][2]==0) return true;
            if (board[2][0]==0) return true;
            if (board[2][2]==0) return true;
        }
        return false;
    }

    private void launch() {
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width  = Toolkit.getDefaultToolkit().getScreenSize().width ;
        setBounds(width / 2 - 300, height / 2 - 300, 600, 600);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new GridLayout(3, 0));
        setResizable(false);
        for (int i = 0; i < 9; ++i) {
            add(grid[i] = new GameButton(i));
            grid[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    performGameAction((GameButton)ae.getSource());
                }
            });
        }
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                performQuitAction();
            }
        });
        for (int i = 0; i<ValidMove.length; i++) {
            for (int j =0; j<ValidMove[i].length; j ++){
                ValidMove[i][j] = true;
            }
        }
        setVisible(true);
    }

    private void performGameAction(GameButton gb) {
        int row = gb.id%3;
        int col = (int) gb.id/3;
        if (! isValidMove(row,col)){
            if (gb.getText().equals("X") && player !=1 || gb.getText().equals("O") && player != -1){
                JOptionPane.showMessageDialog(this, "It's not your turn!");
            }
            else {
                JOptionPane.showMessageDialog(this, "That is an invalid move!");
            }
        }
        if (gb.getText().equals("") && tokensLeft!=0 && isValidMove(row,col)) {
            gb.setText(player == 1 ? "X" : "O");
            gb.setForeground(player == 1 ? xColor: oColor);
            board[row][col] = player;
            ValidMove[row][col] = false;
            tokensLeft--;
            if (checkWin()) {
                for (GameButton b : grid) {
                    b.setEnabled(false);
                }
                JOptionPane.showMessageDialog(this, (player == 1 ? xName : oName) + " wins!");

            }
            player = -player;
            if (tokensLeft ==0){
                clearValidMoves();
                String a  = player == 1 ? "X" : "O";
                for (int i =0; i<grid.length; i++){
                    if (grid[i].getText().equals(a)) {
                        int nrow = grid[i].id%3;
                        int ncol = (int) grid[i].id/3;
                        setValidMove(nrow,ncol);
                    }
                }
            }
        }
        else if (gb.getText().equals("X") && player == 1 && tokensLeft==0 && isValidMove(row,col)){
            if (! hasValidMoves(row,col)){
                JOptionPane.showMessageDialog(this, "That piece is blocked!");
                return;
            }
            gb.setText("");
            tokensLeft++;
            board[row][col] = 0;
            ValidMove[row][col] = false;
            setAdjacentsValid(row,col);
        }
        else if (gb.getText().equals("O") && player == -1 && tokensLeft==0 && isValidMove(row,col)){
            if (! hasValidMoves(row,col)){
                JOptionPane.showMessageDialog(this, "That piece is blocked!");
                return;
            }
            gb.setText("");
            tokensLeft++;
            board[row][col] = 0;
            ValidMove[row][col] = false;
            setAdjacentsValid(row,col);
        }
    }

    private void performQuitAction() {
            System.exit(0);
    }
}