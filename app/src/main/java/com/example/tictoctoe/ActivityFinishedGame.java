package com.example.tictoctoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityFinishedGame extends AppCompatActivity {
    TextView numberOfGames;
      TextView winnersOfRound;
      TextView firstPlayerWins;
      TextView secondPlayerWins;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_game);

        numberOfGames=findViewById(R.id.games_finished);
        winnersOfRound=findViewById(R.id.winner);
        firstPlayerWins=findViewById(R.id.player1_wins);
        secondPlayerWins=findViewById(R.id.player2_wins);

      numberOfGames.setText("تعداد بازی های انجام شده "+ MainActivity.playedGames);

      winnersOfRound.setText("برنده شدید بازیکن "+MainActivity.winner);

      firstPlayerWins.setText("تعداد برد بازیکن اول"+MainActivity.firstPlayerWins);
        secondPlayerWins.setText("تعداد برد بازیکن دوم"+MainActivity.secondPlayerWins);


    }


}