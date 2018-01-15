import java.util.Scanner;
public class Game {
    public static void CATcheck(char[][] board) {
        boolean[] check = new boolean[9];
        int k = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ' ') {
                    check[k] = true;
                }
                else {
                    check[k] = false;
                }
                k++;
            }
        }
        for (int m = 0; m < check.length; m++) {
            if (check[m] == true) {
                return;
            }
        }
        System.out.println("The game is CAT.");
        System.exit(0);
    }
    
    public static void print(char[][] board) {
        System.out.println("   0  1  2");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println();
        }
    }
    
    public static boolean check(char[][] board) {
        boolean check = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
            else if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != ' ') {
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ') {
            return true;
        }
        else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != ' ') {
            return true;
        }
        return check;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
            }
        }
        boolean check = false;
        System.out.print("Player1, enter your name: ");
        String name1 = scan.nextLine();
        System.out.println();
        System.out.print("Player2, enter your name: ");
        String name2 = scan.nextLine();
        System.out.println();
        int x = 0;
        int y = 0;
        while (!check) {
            print(board);
            System.out.println(name1 + ", it is your turn.");
            do {
                do {
                    scan = new Scanner(System.in);
                    System.out.println("Enter the row");
                    if (scan.hasNextInt()) {
                        x = scan.nextInt();
                        if (x < 3 && x >= 0) {break;}
                        else {System.out.println("Number must be less than 3.");}
                    }
                    else {System.out.println("Enter an integer.");}
                } while (true);
                do {
                    scan = new Scanner(System.in);
                    System.out.println("Enter the column");
                    if (scan.hasNextInt()) {
                        y = scan.nextInt();
                        if (y < 3 && y >= 0) {break;}
                        else {System.out.println("Number must be less than 3.");}
                    }
                    else {System.out.println("Enter an integer.");}
                } while (true);
                if (board[x][y] == 'X' || board[x][y] == 'O') {
                    System.out.println("Enter new coordinates.");
                }
            } while(board[x][y] == 'X' || board[x][y] == 'O');
            board[x][y] = 'X';
            print(board);
            check = check(board);

            if (check) {
                System.out.println(name1 + " wins!");
                break;
            }
            CATcheck(board);
            System.out.println(name2 + ", it is your turn.");
            do {
                do {
                    System.out.println("Enter the row");
                    scan = new Scanner (System.in);
                    if (scan.hasNextInt()) {
                        x = scan.nextInt();
                        if (x < 3 && x >= 0) {break;}
                        else {System.out.println("Number must be less than 3.");}
                    }
                    else {System.out.println("Enter an integer.");}
                } while (true);
                do {
                    scan = new Scanner (System.in);
                    System.out.println("Enter the column");
                    if (scan.hasNextInt()) {
                        y = scan.nextInt();
                        if (y < 3 && y >= 0) {break;}
                        else {System.out.println("Number must be less than 3.");}
                    }
                    else {System.out.println("Enter an integer.");}
                } while (true);
                if (board[x][y] == 'X' || board[x][y] == 'O') {
                    System.out.println("Enter new coordinates.");
                }
            } while(board[x][y] == 'X' || board[x][y] == 'O');
            board[x][y] = 'O';
            check = check(board);
            if (check) {
                print(board);
                System.out.println(name2 + " wins!");
            }
        }
    }
}