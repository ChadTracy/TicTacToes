package com.example.chadpc.hw_tictactoe;

/**
 * Created by ChadPC on 9/25/2016.
 */
public class Board {
    //tic tac toe board

    private static final String[][] GameBoard = new String[3][3];

    //empty board
    Board()
    {
        for (int x=0; x<3; x++)
        {
            for (int y=0; y<3; y++)
            {
                GameBoard[x][y] = ""; //all squares set to blank
            }
        }
    }

    //creates the board with blank spots. can also be used for clearing the board
    public void Empty()
    {
        for (int x=0; x<3; x++)
        {
            for (int y=0; y<3; y++)
            {
                GameBoard[x][y] = ""; //all squares set to blank
            }
        }
    }



    //returns the results of the board
    public String[][] Return()
    {
        return GameBoard;
    }

    //check if there is a winner (diagonal, vertical, and horizontal
    public boolean CheckGame()
    {
        //Vertical
        for (int y = 0; y < 3; y++)
        {
            if (GameBoard[0][y] == GameBoard[1][y] && GameBoard[1][y] == GameBoard[2][y] && GameBoard[0][y] != "")
            {
                return true;
            }
        }

        //Horizontal
        for (int x = 0; x < 3; x++)
        {
            if (GameBoard[x][0] == GameBoard[x][1] && GameBoard[x][1] == GameBoard[x][2] && GameBoard[x][0] != "")
            {
                return true;
            }
        }

        //Diagonal
        //2 different directions, so 2 different checks
        if (GameBoard[0][2] == GameBoard[1][1] && GameBoard[1][1] == GameBoard[2][2] && GameBoard[0][2] != "")
        {
            return true;
        }
        if (GameBoard[2][2] == GameBoard[1][1] && GameBoard[1][1] == GameBoard[0][0] && GameBoard[2][2] != "")
        {
            return true;
        }

        //if nothing matches return false
        return false;
    }

    //check if something is there or not before placing the icon. so players can toverride each other
    public void SpotCheck(int x, int y, String symbol)
    {
        if (GameBoard[x][y] == "")
        {
            GameBoard[x][y] = symbol;
        }
    }


}
