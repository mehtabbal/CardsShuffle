package com.example.cardsshuffle;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView resultTv;
    ImageView resultImageView;
    FloatingActionButton play;
    MenuItem resetDeck;

    int[] deck = {
            R.drawable.ace_of_clubs,
            R.drawable.ace_of_diamonds,
            R.drawable.ace_of_hearts,
            R.drawable.ace_of_spades,
            R.drawable.eight_of_clubs,
            R.drawable.eight_of_diamonds,
            R.drawable.eight_of_hearts,
            R.drawable.eight_of_spades,
            R.drawable.five_of_clubs,
            R.drawable.five_of_diamonds,
            R.drawable.five_of_hearts,
            R.drawable.four_of_spades,
            R.drawable.four_of_clubs,
            R.drawable.four_of_diamonds,
            R.drawable.four_of_hearts,
            R.drawable.four_of_spades,
            R.drawable.jack_of_clubs,
            R.drawable.jack_of_diamonds,
            R.drawable.jack_of_hearts,
            R.drawable.jack_of_spades,
            R.drawable.king_of_clubs,
            R.drawable.king_of_diamonds,
            R.drawable.king_of_hearts,
            R.drawable.king_of_spades,
            R.drawable.nine_of_clubs,
            R.drawable.nine_of_diamonds,
            R.drawable.nine_of_spades,
            R.drawable.nine_of_spades,
            R.drawable.queen_of_clubs2,
            R.drawable.queen_of_diamonds2,
            R.drawable.queen_of_hearts2,
            R.drawable.queen_of_spades2,
            R.drawable.seven_of_clubs,
            R.drawable.seven_of_diamonds,
            R.drawable.seven_of_hearts,
            R.drawable.seven_of_spades,
            R.drawable.six_of_clubs,
            R.drawable.six_of_diamonds,
            R.drawable.six_of_hearts,
            R.drawable.six_of_spades,
            R.drawable.ten_of_clubs,
            R.drawable.ten_of_diamonds,
            R.drawable.ten_of_hearts,
            R.drawable.ten_of_spades,
            R.drawable.two_of_clubs,
            R.drawable.two_of_diamonds,
            R.drawable.two_of_hearts,
            R.drawable.two_of_spades,
            R.drawable.three_of_clubs,
            R.drawable.three_of_clubs,
            R.drawable.three_of_diamonds,
            R.drawable.three_of_hearts,
            R.drawable.three_of_spades
    };

    int numOfCards = 52;
    Random rand;
    int cardDrawn;
    ArrayList<Integer> cardList = new ArrayList<Integer>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        resultTv = (TextView)findViewById(R.id.cardRem);
        resultImageView = (ImageView)findViewById(R.id.card);
        resultImageView.setImageResource(R.drawable.red_joker);
        resetDeck = (MenuItem) findViewById(R.id.resetDeck);
        play = findViewById(R.id.play);


        resultTv.setText("Cards Remaining: "+numOfCards);

        populate_array();




        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rand = new Random();
                cardDrawn = rand.nextInt(numOfCards);
                resultImageView.setImageResource(cardList.get(cardDrawn));
                cardList.remove(cardDrawn);
                numOfCards--;
                resultTv.setText("Cards remaining : " + numOfCards);

                if (numOfCards == 0) {
                    numOfCards = 52;
                    resultTv.setText("Remaining Cards : " + numOfCards);
                    resultImageView.setImageResource(R.drawable.red_joker);
                    populate_array();
                }
            }
        });
    }
    public void populate_array() {
        for(int i=0; i<deck.length; i++){
            cardList.add(deck[i]);
        }
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
        switch (item.getItemId()) {

            case R.id.resetDeck:

                numOfCards = 52;
                resultTv.setText("Remaining Cards : " + numOfCards);
                resultImageView.setImageResource(R.drawable.red_joker);
                populate_array();
                Toast.makeText(getApplicationContext(),"Deck Reset", Toast.LENGTH_SHORT).show();
                break;

        }

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.resetDeck) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
