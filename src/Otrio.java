//Created by Victor Rabinovich
//Created 4/1/2020 

import javax.swing.JOptionPane;

public class Otrio {

    final static String ANSI_RESET = "\u001B[0m";
    final static String ANSI_RED = "\u001B[31m";
    final static String ANSI_GREEN = "\u001B[32m";
    final static String ANSI_BLUE = "\u001B[34m";
    final static String ANSI_PURPLE = "\u001B[35m";
    final static String ANSI_WHITE = "\u001B[37m";
    static String playerColor;

    static String[] b1 = new String[] { ANSI_RESET, " " }, b2 = new String[] { ANSI_RESET, " " },
            b3 = new String[] { ANSI_RESET, " " }, b4 = new String[] { ANSI_RESET, " " },
            b5 = new String[] { ANSI_RESET, " " }, b6 = new String[] { ANSI_RESET, " " },
            b7 = new String[] { ANSI_RESET, " " }, b8 = new String[] { ANSI_RESET, " " },
            b9 = new String[] { ANSI_RESET, " " }, m1 = new String[] { ANSI_RESET, " " },
            m2 = new String[] { ANSI_RESET, " " }, m3 = new String[] { ANSI_RESET, " " },
            m4 = new String[] { ANSI_RESET, " " }, m5 = new String[] { ANSI_RESET, " " },
            m6 = new String[] { ANSI_RESET, " " }, m7 = new String[] { ANSI_RESET, " " },
            m8 = new String[] { ANSI_RESET, " " }, m9 = new String[] { ANSI_RESET, " " },
            s1 = new String[] { ANSI_RESET, " " }, s2 = new String[] { ANSI_RESET, " " },
            s3 = new String[] { ANSI_RESET, " " }, s4 = new String[] { ANSI_RESET, " " },
            s5 = new String[] { ANSI_RESET, " " }, s6 = new String[] { ANSI_RESET, " " },
            s7 = new String[] { ANSI_RESET, " " }, s8 = new String[] { ANSI_RESET, " " },
            s9 = new String[] { ANSI_RESET, " " };

    static int[] player1Pieces = { 3, 3, 3 }, player2Pieces = { 3, 3, 3 }, player3Pieces = { 3, 3, 3 },
            player4Pieces = { 3, 3, 3 };

    static int playerNum, numOfPlayers;// used to talk to the players

    static boolean win = false;

    static String userInput;

    public static void main(String[] args) {
        int i = 1; // iterations of while loop
        int divisor = 0; // number to help determine which player it is

        JOptionPane.showMessageDialog(null,
                "The sub grids and boxes within them go from left to fight as follows\n1|2|3\n-------\n4|5|6\n-------\n7|8|9\n your grid will appear in the terminal");
        JOptionPane.showMessageDialog(null,
                "Your move will be witten as the first letter of the size of your piece (b=big, m=medium, s=small), and them the box you want it in.");

        numOfPlayers = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Pick the number of people playing. This is a 2-4 person game."));

        if (numOfPlayers == 2)
            divisor = 2;
        if (numOfPlayers == 3)
            divisor = 3;
        if (numOfPlayers == 4)
            divisor = 4;

        while (win == false) {
            PlayerTurn(i, numOfPlayers, divisor);
            PrintBoard();
            PlayerPieces(userInput);
            winDecide();
            i++;
        }
        JOptionPane.showMessageDialog(null, "Player " + playerNum + " is the winner!!!!");
    }

    public static void PlayerTurn(int i, int numOfPlayers, int divisor) {
        int player = i % divisor;

        if (player == 1) {
            playerColor = ANSI_RED;
            playerNum = 1;
        } else if (player == 2) {
            playerColor = ANSI_GREEN;
            playerNum = 2;
        } else if (player == 3) {
            playerColor = ANSI_BLUE;
            playerNum = 3;
        } else if (player == 0 && divisor == 2) {
            playerColor = ANSI_GREEN;
            playerNum = 2;
        } else if (player == 0 && divisor == 3) {
            playerColor = ANSI_BLUE;
            playerNum = 3;
        } else if (player == 0 && divisor == 4) {
            playerColor = ANSI_PURPLE;
            playerNum = 4;
        }

        userInput = JOptionPane.showInputDialog(null, "Player " + playerNum + " place your move");
        userInput = userInput.toLowerCase();

        if (userInput.equals("b1") && b1[1] == " ") {
            b1[0] = playerColor;
            b1[1] = "O";
        } else if (userInput.equals("b2") && b2[1] == " ") {
            b2[0] = playerColor;
            b2[1] = "O";
        } else if (userInput.equals("b3") && b3[1] == " ") {
            b3[0] = playerColor;
            b3[1] = "O";
        } else if (userInput.equals("b4") && b4[1] == " ") {
            b4[0] = playerColor;
            b4[1] = "O";
        } else if (userInput.equals("b5") && b5[1] == " ") {
            b5[0] = playerColor;
            b5[1] = "O";
        } else if (userInput.equals("b6") && b6[1] == " ") {
            b6[0] = playerColor;
            b6[1] = "O";
        } else if (userInput.equals("b7") && b7[1] == " ") {
            b7[0] = playerColor;
            b7[1] = "O";
        } else if (userInput.equals("b8") && b8[1] == " ") {
            b8[0] = playerColor;
            b8[1] = "O";
        } else if (userInput.equals("b9") && b9[1] == " ") {
            b9[0] = playerColor;
            b9[1] = "O";
        }

        else if (userInput.equals("m1") && m1[1] == " ") {
            m1[0] = playerColor;
            m1[1] = "o";
        } else if (userInput.equals("m2") && m2[1] == " ") {
            m2[0] = playerColor;
            m2[1] = "o";
        } else if (userInput.equals("m3") && m3[1] == " ") {
            m3[0] = playerColor;
            m3[1] = "o";
        } else if (userInput.equals("m4") && m4[1] == " ") {
            m4[0] = playerColor;
            m4[1] = "o";
        } else if (userInput.equals("m5") && m5[1] == " ") {
            m5[0] = playerColor;
            m5[1] = "o";
        } else if (userInput.equals("m6") && m6[1] == " ") {
            m6[0] = playerColor;
            m6[1] = "o";
        } else if (userInput.equals("m7") && m7[1] == " ") {
            m7[0] = playerColor;
            m7[1] = "o";
        } else if (userInput.equals("m8") && m8[1] == " ") {
            m8[0] = playerColor;
            m8[1] = "o";
        } else if (userInput.equals("m9") && m9[1] == " ") {
            m9[0] = playerColor;
            m9[1] = "o";
        }

        else if (userInput.equals("s1") && s1[1] == " ") {
            s1[0] = playerColor;
            s1[1] = ".";
        } else if (userInput.equals("s2") && s2[1] == " ") {
            s2[0] = playerColor;
            s2[1] = ".";
        } else if (userInput.equals("s3") && s3[1] == " ") {
            s3[0] = playerColor;
            s3[1] = ".";
        } else if (userInput.equals("s4") && s4[1] == " ") {
            s4[0] = playerColor;
            s4[1] = ".";
        } else if (userInput.equals("s5") && s5[1] == " ") {
            s5[0] = playerColor;
            s5[1] = ".";
        } else if (userInput.equals("s6") && s6[1] == " ") {
            s6[0] = playerColor;
            s6[1] = ".";
        } else if (userInput.equals("s7") && s7[1] == " ") {
            s7[0] = playerColor;
            s7[1] = ".";
        } else if (userInput.equals("s8") && s8[1] == " ") {
            s8[0] = playerColor;
            s8[1] = ".";
        } else if (userInput.equals("s9") && s9[1] == " ") {
            s9[0] = playerColor;
            s9[1] = ".";
        } else {
            JOptionPane.showMessageDialog(null, "Player " + playerNum + " is a cheater");
            System.exit(0);
        }

    }

    public static void PrintBoard() {
        System.out.println("\t" + b1[0] + b1[1] + " " + m1[0] + m1[1] + " " + s1[0] + s1[1] + ANSI_RESET + " | " + b2[0]
                + b2[1] + " " + m2[0] + m2[1] + " " + s2[0] + s2[1] + ANSI_RESET + " | " + b3[0] + b3[1] + " " + m3[0]
                + m3[1] + " " + s3[0] + s3[1] + ANSI_RESET);
        System.out.println("\t----- | ----- | ------");
        System.out.println("\t" + b4[0] + b4[1] + " " + m4[0] + m4[1] + " " + s4[0] + s4[1] + ANSI_RESET + " | " + b5[0]
                + b5[1] + " " + m5[0] + m5[1] + " " + s5[0] + s5[1] + ANSI_RESET + " | " + b6[0] + b6[1] + " " + m6[0]
                + m6[1] + " " + s6[0] + s6[1] + ANSI_RESET);
        System.out.println("\t----- | ----- | ------");
        System.out.println("\t" + b7[0] + b7[1] + " " + m7[0] + m7[1] + " " + s7[0] + s7[1] + ANSI_RESET + " | " + b8[0]
                + b8[1] + " " + m8[0] + m8[1] + " " + s8[0] + s8[1] + ANSI_RESET + " | " + b9[0] + b9[1] + " " + m9[0]
                + m9[1] + " " + s9[0] + s9[1] + ANSI_RESET + "\n\n");

    }

    public static Boolean winDecide() {
        // single size win
        if (b1 == b2 && b2 == b3 && b1[1] != " ")
            win = true;
        else if (m1 == m2 && m2 == m3 && m1[1] != " ")
            win = true;
        else if (s1 == s2 && s2 == s3 && s1[1] != " ")
            win = true;
        else if (b4 == b5 && b5 == b6 && b4[1] != " ")
            win = true;
        else if (m4 == m5 && m5 == m6 && m4[1] != " ")
            win = true;
        else if (s4 == s5 && s5 == s6 && s4[1] != " ")
            win = true;
        else if (b7 == b8 && b8 == b9 && b7[1] != " ")
            win = true;
        else if (m7 == m8 && m8 == m9 && m7[1] != " ")
            win = true;
        else if (s7 == s8 && s8 == s9 && s7[1] != " ")
            win = true;
        else if (b1 == b4 && b4 == b7 && b1[1] != " ")
            win = true;
        else if (m1 == m4 && m4 == m7 && m1[1] != " ")
            win = true;
        else if (s1 == s4 && s4 == s7 && s1[1] != " ")
            win = true;
        else if (b2 == b5 && b5 == b8 && b2[1] != " ")
            win = true;
        else if (m2 == m5 && m5 == m8 && m2[1] != " ")
            win = true;
        else if (s2 == s5 && s5 == s8 && s2[1] != " ")
            win = true;
        else if (b3 == b6 && b6 == b8 && b3[1] != " ")
            win = true;
        else if (m3 == m6 && m6 == m8 && m3[1] != " ")
            win = true;
        else if (s3 == s6 && s6 == s8 && s3[1] != " ")
            win = true;
        else if (b1 == b5 && b5 == b9 && b1[1] != " ")
            win = true;
        else if (m1 == m5 && m5 == m9 && m1[1] != " ")
            win = true;
        else if (s1 == s5 && s5 == s9 && s1[1] != " ")
            win = true;
        else if (b3 == b5 && b5 == b7 && b3[1] != " ")
            win = true;
        else if (m1 == m5 && m5 == m7 && m1[1] != " ")
            win = true;
        else if (s1 == s5 && s5 == s7 && s1[1] != " ")
            win = true;
        // All in one win
        else if (b1[1] == "O" && m1[1] == "o" && s1[1] == "." && b1[0] == m1[0] && m1[0] == s1[0])
            win = true;
        else if (b2[1] == "O" && m2[1] == "o" && s2[1] == "." && b2[0] == m2[0] && m2[0] == s2[0])
            win = true;
        else if (b3[1] == "O" && m3[1] == "o" && s3[1] == "." && b3[0] == m3[0] && m3[0] == s3[0])
            win = true;
        else if (b4[1] == "O" && m4[1] == "o" && s4[1] == "." && b4[0] == m4[0] && m4[0] == s4[0])
            win = true;
        else if (b5[1] == "O" && m5[1] == "o" && s5[1] == "." && b5[0] == m5[0] && m5[0] == s5[0])
            win = true;
        else if (b6[1] == "O" && m6[1] == "o" && s6[1] == "." && b6[0] == m6[0] && m6[0] == s6[0])
            win = true;
        else if (b7[1] == "O" && m7[1] == "o" && s7[1] == "." && b7[0] == m7[0] && m7[0] == s7[0])
            win = true;
        else if (b8[1] == "O" && m8[1] == "o" && s8[1] == "." && b8[0] == m8[0] && m8[0] == s8[0])
            win = true;
        else if (b9[1] == "O" && m9[1] == "o" && s9[1] == "." && b9[0] == m9[0] && m9[0] == s9[0])
            win = true;
        // large to small win
        else if (m2[1] == "o" && ((b1[1] == "O" && s3[1] == "." && b1[0] == m2[0] && m2[0] == s3[0])
                || (s1[1] == "." && b3[1] == "O" && s1[0] == m2[0] && m2[0] == b3[0])))// top row
            win = true;
        else if (m5[1] == "o" && ((b4[1] == "O" && s6[1] == "." && b4[0] == m5[0] && m5[0] == s6[0])
                || (s4[1] == "." && b6[1] == "O" && s4[0] == m5[0] && m5[0] == b6[0])))// second row
            win = true;
        else if (m8[1] == "o" && ((b7[1] == "O" && s9[1] == "." && b7[0] == m8[0] && m8[0] == s9[0])
                || (s7[1] == "." && b9[1] == "O" && s7[0] == m8[0] && m8[0] == b9[0])))// bottom row
            win = true;
        else if (m4[1] == "o" && ((b1[1] == "O" && s7[1] == "." && b1[0] == m4[0] && m4[0] == s7[0])
                || (s1[1] == "." && b7[1] == "O" && s1[0] == m4[0] && m4[0] == b7[0])))// first column
            win = true;
        else if (m5[1] == "o" && ((b2[1] == "O" && s8[1] == "." && b2[0] == m5[0] && m5[0] == s8[0])
                || (s2[1] == "." && b8[1] == "O" && s2[0] == m5[0] && m5[0] == b8[0])))// Second column
            win = true;
        else if (m6[1] == "o" && ((b3[1] == "O" && s9[1] == "." && b3[0] == m6[0] && m6[0] == s9[0])
                || (s3[1] == "." && b9[1] == "O" && s3[0] == m6[0] && m6[0] == b9[0])))// Third column
            win = true;
        else if (m5[1] == "o" && ((b3[1] == "O" && s7[1] == "." && b3[0] == m5[0] && m5[0] == s7[0])
                || (s3[1] == "." && b7[1] == "O" && s3[0] == m5[0] && m5[0] == b7[0])))// Diagnol
            win = true;
        else if (m5[1] == "o" && ((b1[1] == "O" && s9[1] == "." && b1[0] == m5[0] && m5[0] == s9[0])
                || (s1[1] == "." && b9[1] == "O" && s1[0] == m5[0] && m5[0] == b9[0])))// Diagnol
            win = true;
        else if (b1[1] != " " && m1[1] != " " && s1[1] != " " && b2[1] != " " && m2[1] != " " && s2[1] != " "
                && b3[1] != " " && m3[1] != " " && s3[1] != " " && b4[1] != " " && m4[1] != " " && s4[1] != " "
                && b5[1] != " " && m5[1] != " " && s5[1] != " " && b6[1] != " " && m6[1] != " " && s6[1] != " "
                && b7[1] != " " && m7[1] != " " && s7[1] != " " && b8[1] != " " && m8[1] != " " && s8[1] != " "
                && b9[1] != " " && m9[1] != " " && s9[1] != " ") {
            JOptionPane.showMessageDialog(null, "It is a " + numOfPlayers + " way tie");
            System.exit(0);
        }
        return win;
    }

    public static void PlayerPieces(String userInput) {
        char pieceSize = userInput.charAt(0);
        if (playerNum == 1) {
            if (pieceSize == 'b')
                player1Pieces[0] = player1Pieces[0] - 1;
            else if (pieceSize == 'm')
                player1Pieces[1] = player1Pieces[1] - 1;
            else if (pieceSize == 's')
                player1Pieces[2] = player1Pieces[2] - 1;
        } else if (playerNum == 2) {
            if (pieceSize == 'b')
                player2Pieces[0] = player2Pieces[0] - 1;
            else if (pieceSize == 'm')
                player2Pieces[1] = player2Pieces[1] - 1;
            else if (pieceSize == 's')
                player2Pieces[2] = player2Pieces[2] - 1;
        } else if (playerNum == 3) {
            if (pieceSize == 'b')
                player3Pieces[0] = player3Pieces[0] - 1;
            else if (pieceSize == 'm')
                player3Pieces[1] = player3Pieces[1] - 1;
            else if (pieceSize == 's')
                player3Pieces[2] = player3Pieces[2] - 1;
        } else if (playerNum == 4) {
            if (pieceSize == 'b')
                player4Pieces[0] = player4Pieces[0] - 1;
            else if (pieceSize == 'm')
                player4Pieces[1] = player4Pieces[1] - 1;
            else if (pieceSize == 's')
                player4Pieces[2] = player4Pieces[2] - 1;
        }
        if (player1Pieces[0] < 0 || player1Pieces[1] < 0 || player1Pieces[2] < 0 || player2Pieces[0] < 0
                || player2Pieces[1] < 0 || player2Pieces[2] < 0 || player3Pieces[0] < 0 || player3Pieces[1] < 0
                || player3Pieces[2] < 0 || player4Pieces[0] < 0 || player4Pieces[1] < 0 || player4Pieces[2] < 0) {
            JOptionPane.showMessageDialog(null, "Player " + playerNum + " is a cheater");
            System.exit(0);
        }

        if (numOfPlayers == 2)

        {
            System.out.println("Player 1 has " + player1Pieces[0] + " big remaining, " + player1Pieces[1]
                    + " medium remaining, " + player1Pieces[2] + " small remaining");
            System.out.println("Player 2 has " + player2Pieces[0] + " big remaining, " + player2Pieces[1]
                    + " medium remaining, " + player2Pieces[2] + " small remaining");
        } else if (numOfPlayers == 3) {
            System.out.println("Player 1 has " + player1Pieces[0] + " big remaining, " + player1Pieces[1]
                    + " medium remaining, " + player1Pieces[2] + " small remaining");
            System.out.println("Player 2 has " + player2Pieces[0] + " big remaining, " + player2Pieces[1]
                    + " medium remaining, " + player2Pieces[2] + " small remaining");
            System.out.println("Player 3 has " + player3Pieces[0] + " big remaining, " + player3Pieces[1]
                    + " medium remaining, " + player3Pieces[2] + " small remaining");
        } else if (numOfPlayers == 4) {
            System.out.println("Player 1 has " + player1Pieces[0] + " big remaining, " + player1Pieces[1]
                    + " medium remaining, " + player1Pieces[2] + " small remaining");
            System.out.println("Player 2 has " + player2Pieces[0] + " big remaining, " + player2Pieces[1]
                    + " medium remaining, " + player2Pieces[2] + " small remaining");
            System.out.println("Player 3 has " + player3Pieces[0] + " big remaining, " + player3Pieces[1]
                    + " medium remaining, " + player3Pieces[2] + " small remaining");
            System.out.println("Player 4 has " + player4Pieces[0] + " big remaining, " + player4Pieces[1]
                    + " medium remaining, " + player4Pieces[2] + " small remaining");
        }

    }
}