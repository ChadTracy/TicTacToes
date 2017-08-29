package com.example.chadpc.hw_tictactoe;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public int player = 1;
    //public Board board = new Board;
    public Board gameBoard = null;
    public int moveCount = 0;
    public int x = 0;
    public int y = 0;
    public String playerOneSymbol = "X";
    public String playerTwoSymbol = "O";
    public boolean gameOver = false;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //getActionBar().hide();
        gameBoard = new Board(); //creates board on create. since hte actual board is textview
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        // @Override
        // public void onClick(View view) {
        //      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //            .setAction("Action", null).show();
        //     }
        //  });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void AnnounceWinner(boolean end, int player)
    {
        String Message;

        if (end == true)
        {
            Message = "player" + player + " wins!";
        }
        else
        {
            Message = "draw!";
        }


        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, player, Toast.LENGTH_SHORT);
        toast.show();

        //return false;
    }

    public boolean CheckOver(int player)
    {
        if (gameBoard.CheckGame())
        {
            AnnounceWinner(true, player);
            return true;
        }

        else if (moveCount == 9)
        {
            AnnounceWinner(false, player);
            return true;
        }

        return false;
    }



    @Override
    public void onClick(View v) {
        TextView cell = (TextView) findViewById(v.getId()); //determines which cell is clicked by its ID
        String content = (String) cell.getText(); //gets the content of the clicked cell


        if (content == "" && gameOver == false) {
            switch (cell.getId()) {
                case R.id.cellA2:
                    x = 0;
                    y = 2;
                    break;
                case R.id.cellB2:
                    x = 1;
                    y = 2;
                    break;
                case R.id.cellC2:
                    x = 2;
                    y = 2;
                    break;
                case R.id.cellA1:
                    x = 0;
                    y = 1;
                    break;
                case R.id.cellB1:
                    x = 1;
                    y = 1;
                    break;
                case R.id.cellC1:
                    x = 2;
                    y = 1;
                    break;
                case R.id.cellA0:
                    x = 0;
                    y = 0;
                    break;
                case R.id.cellB0:
                    x = 1;
                    y = 0;
                    break;
                case R.id.cellC0:
                    x = 2;
                    y = 0;
                    break;
            }

            if (player == 1) {
                gameBoard.SpotCheck(x, y, playerOneSymbol);
                cell.setText(playerOneSymbol);
            }
            if (player == 2) {
                gameBoard.SpotCheck(x, y, playerTwoSymbol);
                cell.setText(playerTwoSymbol);
            }

            moveCount++;

            gameOver = CheckOver(player);

            if (!gameOver)
            {
                if (player == 1)
                {
                    player = 2;
                }
                else
                {
                    player = 1;
                }
            }

            else if (gameOver)
            {

                gameBoard.Empty();
            }

        }
    }

}
