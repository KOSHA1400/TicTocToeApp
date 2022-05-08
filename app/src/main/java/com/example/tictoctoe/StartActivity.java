package com.example.tictoctoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    RadioButton btnP1x, btnP2x, btnP1o, btnP2o;
    Button btnStartGame;

    String p1SelectedItem = "";
    String p2SelectedItem = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        btnP1x = findViewById(R.id.p1radioButton_x);
        btnP1o = findViewById(R.id.p1radioButton_o);
        btnP2x = findViewById(R.id.p2radioButton_x);
        btnP2o = findViewById(R.id.p2radioButton_o);


        btnStartGame = findViewById(R.id.btn_start_game);


        btnP1x.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                p1SelectedItem="X";
            }
        });

        btnP1o.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                p1SelectedItem="O";
            }
        });

        btnP2x.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                p2SelectedItem="X";
            }
        });

        btnP2o.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                p2SelectedItem="O";
            }
        });


        btnStartGame.setOnClickListener(v -> {


            if (p1SelectedItem.isEmpty() || p2SelectedItem.isEmpty()) {
                Toast.makeText(StartActivity.this, "نوع مهره هر دو بازیکن را انتخاب نمایید", Toast.LENGTH_SHORT).show();
            } else if (p1SelectedItem.equals(p2SelectedItem)) {
                Toast.makeText(StartActivity.this, "نوع مهره هر دو بازیکن نباید یکسان باشد", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);


                MainActivity.symbol=p1SelectedItem;
                startActivity(intent);
                finish();
            }


        });
    }
}