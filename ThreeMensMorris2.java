import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class ThreeMensMorris2 extends JFrame {
    private static final long serialVersionUID = 1L;
    private class GameButton extends JButton {
        private static final long serialVersionUID = 1L;
        private GameButton(int id) {
            this.id = id;
            setFont(new Font(getFont().getClass().getName(), Font.BOLD, 128));
        }
        private int id;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ThreeMensMorris2();
            }
        });
    }
    private ThreeMensMorris2() {
        super("Three Men's Morris - Trevor Summerfield");
        launch();
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
    private boolean isLegalMove(int row, int col) {
        return legalMove[row][col];
    }
    private void clearLegalMoves() {
        legalMove = new boolean[3][3];
    }
    private void setLegalMove(int row,int col) {
        legalMove[row][col] = true;
    }
    private void setAdjacentsLegal(int row, int col){
        if ((row<=1) && (board[row+1][col]==0)){
            legalMove[row+1][col]=true;
        }
        if ((row>=1) && (board[row-1][col]==0)){
            legalMove[row-1][col]=true;
        }
        if ((col<=1) && (board[row][col+1]==0)){
            legalMove[row][col+1]=true;
        }
        if ((col>=1) && (board[row][col-1]==0)){
            legalMove[row][col-1]=true;
        }
        if((((row==0) && (col==0))||((row==0) && (col==2))||((row==2) && (col==0))||((row==2) && (col==2))) && (board[1][1]==0)){
            legalMove[1][1]=true;
        }
        if((row == 1 && col == 1)) {
            if (board[0][0]==0) legalMove[0][0] = true;
            if (board[0][2]==0) legalMove[0][2] = true;
            if (board[2][0]==0) legalMove[2][0] = true;
            if (board[2][2]==0) legalMove[2][2] = true;
        }
    }

    private boolean hasLegalMoves(int row, int col){
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
    private JMenu createGameJMenu() {
        JMenu m = new JMenu("Game");
        m.setMnemonic(KeyEvent.VK_G);
        m.add(createGameNewJMenuItem());
        m.addSeparator();
        m.add(createGameQuitJMenuItem());
        return m;
    }
    private JMenu createOptionsJMenu() {
        JMenu m = new JMenu("Options");
        m.setMnemonic(KeyEvent.VK_O);
        m.add(createGameNameXJMenuItem());
        m.add(createGameNameYJMenuItem());
        m.addSeparator();
        m.add(createXColorMenuItem());
        m.add(createOColorMenuItem());
        return m;
    }
    private JMenuItem createXColorMenuItem() {
        JMenuItem mi = new JMenuItem("Set Player X Color");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performColorXAction();
            }
        });
        return mi;
    }
    private JMenuItem createOColorMenuItem() {
        JMenuItem mi = new JMenuItem("Set Player O Color");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performColorOAction();
            }
        });
        return mi;
    }
    private JMenuItem createGameNameXJMenuItem() {
        JMenuItem mi = new JMenuItem("Set Player X Name");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performNameXAction();
            }
        });
        return mi;
    }
    private JMenuItem createGameNameYJMenuItem() {
        JMenuItem mi = new JMenuItem("Set Player O Name");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performNameYAction();
            }
        });
        return mi;
    }
    private void performNameXAction() {
        String temp = xName;
        xName = JOptionPane.showInputDialog(null, "Player X is currently: " + xName + "\nEnter new Player X Name : ", "Set Player X Name", 1);
        if (xName == null || xName == "") xName = temp;
    }
    private void performNameYAction() {
        String temp = oName;
        oName = JOptionPane.showInputDialog(null, "Player O is currently: " + oName + "\nEnter new Player O Name : ", "Set Player O Name", 1);
        if (oName == null || oName == "") oName = temp;
    }
    private void performColorOAction() {
        Object[] possibilities = {"Red", "Green", "Blue", "Black"};
        String s = (String)JOptionPane.showInputDialog(
                this,
                "Choose Color for Player O:",
                "Color Chooser",
                JOptionPane.PLAIN_MESSAGE,
                null, possibilities,
                null);
        if ((s != null) && (s.length() > 0)) {
            if (s == "Red") oColor = Color.red;
            if (s == "Green") oColor = Color.green;
            if (s == "Blue") oColor = Color.blue;
            if (s == "Black") oColor = Color.black;
        }
    }
    private void performColorXAction() {
        Object[] possibilities = {"Red", "Green", "Blue", "Black"};
        String s = (String)JOptionPane.showInputDialog(
                this,
                "Choose Color for Player X:",
                "Color Chooser",
                JOptionPane.PLAIN_MESSAGE,
                null, possibilities,
                null);
        if ((s != null) && (s.length() > 0)) {
            if (s == "Red") xColor = Color.red;
            if (s == "Green") xColor = Color.green;
            if (s == "Blue") xColor = Color.blue;
            if (s == "Black") xColor = Color.black;
        }
    }
    private JMenuItem createGameNewJMenuItem() {
        JMenuItem mi = new JMenuItem("New");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performNewAction();
            }
        });
        mi.setMnemonic(KeyEvent.VK_N);
        mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        return mi;
    }
    private JMenuItem createGameQuitJMenuItem() {
        JMenuItem mi = new JMenuItem("Quit");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performQuitAction();
            }
        });
        mi.setMnemonic(KeyEvent.VK_Q);
        mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
        return mi;
    }
    private JMenu createHelpJMenu() {
        JMenu m = new JMenu("Help");
        m.setMnemonic(KeyEvent.VK_H);
        m.add(createHowToPlayMenuItem());
        m.add(createHelpAboutJMenuItem());
        return m;
    }
    private JMenuItem createHelpAboutJMenuItem() {
        JMenuItem mi = new JMenuItem("About");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performAboutAction();
            }
        });
        mi.setMnemonic(KeyEvent.VK_A);
        return mi;
    }
    private JMenuItem createHowToPlayMenuItem() {
        JMenuItem mj = new JMenuItem("How To Play");
        mj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                performHTPAction();
            }
        });
        return mj;
    }
    private JMenuBar createJMenuBar() {
        JMenuBar mb = new JMenuBar();
        mb.add(createGameJMenu());
        mb.add(createOptionsJMenu());
        mb.add(createHelpJMenu());
        return mb;
    }
    private void launch() {
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width  = Toolkit.getDefaultToolkit().getScreenSize().width ;
        setBounds(width / 2 - 300, height / 2 - 300, 600, 600);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setJMenuBar(createJMenuBar());
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
        for (int i = 0; i<legalMove.length; i++) {
            for (int j =0; j<legalMove[i].length; j ++){
                legalMove[i][j] = true;
            }
        }
        setVisible(true);
    }
    private void performAboutAction() {
        JOptionPane.showMessageDialog(this, "Three Men's Morris\nAuthor: Trevor Summerfield\n               ts249@njit.edu\nNJIT CS113H Spring 2013\nInstructor: Jonathan Kapleau\nVersion: 1.0\nDate: 18-APR-2013", "About", JOptionPane.INFORMATION_MESSAGE);
    }
    private void performHTPAction() {
        JOptionPane.showMessageDialog(this, "The objective of the game is to get a three-in-a-row.\nOnce a player has placed 3 game pieces, they must remove one in order to make a move.\nX goes first.", "How To Play", JOptionPane.INFORMATION_MESSAGE);
    }
    private void performGameAction(GameButton gb) {
        int row = gb.id%3;
        int col = (int) gb.id/3;
        if (! isLegalMove(row,col)){
            if (gb.getText().equals("X") && player !=1 || gb.getText().equals("O") && player != -1){
                JOptionPane.showMessageDialog(this, "It's not your turn!");
            }
            else {
                JOptionPane.showMessageDialog(this, "That is an illegal move!");
            }
        }
        if (gb.getText().equals("") && tokensLeft!=0 && isLegalMove(row,col)) {
            gb.setText(player == 1 ? "X" : "O");
            gb.setForeground(player == 1 ? xColor: oColor);
            board[row][col] = player;
            legalMove[row][col] = false;
            tokensLeft--;
            if (checkWin()) {
                for (GameButton b : grid) {
                    b.setEnabled(false);
                }
                int choice = JOptionPane.showConfirmDialog(this, (player == 1 ? xName : oName) + " wins! Play again?", "Play again? (Y/N)", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (choice == JOptionPane.YES_OPTION) {
                    performNewAction();
                    return;
                }
            }
            player = -player;
            if (tokensLeft ==0){
                clearLegalMoves();
                String a  = player == 1 ? "X" : "O";
                for (int i =0; i<grid.length; i++){
                    if (grid[i].getText().equals(a)) {
                        int nrow = grid[i].id%3;
                        int ncol = (int) grid[i].id/3;
                        setLegalMove(nrow,ncol);
                    }
                }
            }
        }
        else if (gb.getText().equals("X") && player == 1 && tokensLeft==0 && isLegalMove(row,col)){
            if (! hasLegalMoves(row,col)){
                JOptionPane.showMessageDialog(this, "That piece is blocked!");
                return;
            }
            gb.setText("");
            tokensLeft++;
            board[row][col] = 0;
            legalMove[row][col] = false;
            setAdjacentsLegal(row,col);
        }
        else if (gb.getText().equals("O") && player == -1 && tokensLeft==0 && isLegalMove(row,col)){
            if (! hasLegalMoves(row,col)){
                JOptionPane.showMessageDialog(this, "That piece is blocked!");
                return;
            }
            gb.setText("");
            tokensLeft++;
            board[row][col] = 0;
            legalMove[row][col] = false;
            setAdjacentsLegal(row,col);
        }
    }
    private void performNewAction() {
        player = 1;
        board = new int[3][3];
        tokensLeft = 6;
        for (GameButton gb : grid) {
            gb.setText("");
            gb.setEnabled(true);
        }
        for (int i = 0; i<legalMove.length; i++) {
            for (int j =0; j<legalMove[i].length; j ++){
                legalMove[i][j] = true;
            }
        }
    }
    private void performQuitAction() {
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Quit (Y/N)", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    private GameButton[] grid = new GameButton[9];
    private int[][] board = new int[3][3];
    private boolean[][] legalMove = new boolean[3][3];
    private Color xColor = Color.red;
    private Color oColor = Color.blue;
    private int player = 1;
    private int tokensLeft = 6;
    private String xName = "Player X";
    private String oName = "Player O";
}