package com.example.tictoctoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    int turn=1;//نوبت بازیکن


  public static String winner=null;//مشخص کننده برنده

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

    TextView txtTurn;


    Button btnRestart,btnEndGame;

    public static int playedGames=0;//بازی های انجام شده
    public static int firstPlayerWins=0;
    public static int secondPlayerWins=0;

   public static String symbol; //تشخصیص مهره بازیکن اول. هر کدام بود مهره بازیکن دوم بر عکس آن است


    boolean isFinished=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1=findViewById(R.id.btn_one);
        btn2=findViewById(R.id.btn_two);
        btn3=findViewById(R.id.btn_three);
        btn4=findViewById(R.id.btn_four);
        btn5=findViewById(R.id.btn_five);
        btn6=findViewById(R.id.btn_six);
        btn7=findViewById(R.id.btn_seven);
        btn8=findViewById(R.id.btn_eight);
        btn9=findViewById(R.id.btn_nine);
        btnRestart=findViewById(R.id.btn_restart_game);
        btnEndGame=findViewById(R.id.btn_finish_game);

        txtTurn=findViewById(R.id.txt_turn);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnRestart.setOnClickListener(this);
        btnEndGame.setOnClickListener(this);







    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            //وقتی یک دکمه کلیک می شود بررسی میکنیم کدام دکمه هست

            case R.id.btn_one :{
              setButton(btn1);
                break;
            }
            case R.id.btn_two :{
                setButton(btn2);
                break;
            }
            case R.id.btn_three :{
                setButton(btn3);
                break;
            }
            case R.id.btn_four :{
                setButton(btn4);
                break;
            }
            case R.id.btn_five :{
                setButton(btn5);
                break;
            }
            case R.id.btn_six :{
                setButton(btn6);
                break;
            }
            case R.id.btn_seven :{
                setButton(btn7);
                break;
            }
            case R.id.btn_eight :{
                setButton(btn8);
                break;
            }
            case R.id.btn_nine :{
                setButton(btn9);
                break;
            }
            case R.id.btn_finish_game:{
                finishGame();
                break;

            }
            case R.id.btn_restart_game:{
                restartGame();
                break;
            }
            default:break;
        }
    }





    @SuppressLint("SetTextI18n")
    void setButton(Button btn){

        if (!btn.getText().toString().isEmpty()){//چک کردن انتخاب مجدد یک خانه
            Toast.makeText(this,"این خانه قبلا انتخاب شده است",Toast.LENGTH_LONG).show();
            return;
        }

       btn.setText(symbol);
        int color ;
       if (symbol.equals("X")){//تغییر رنگ به قرمز
         color=Color.parseColor("#D81B60");//تبدیل مقدار rgb  رنگ به  int

       }else{//تغییر رنگ به سبز
           color=Color.parseColor("#4CAF50");//تبدیل مقدار rgb  رنگ به  int

       }
        btn.setTextColor(color);



   if (turn==1){//تعیین نوشته نوبت بازیکن برای هر دور
       turn=2;

   }else{
       turn=1;
   }
        txtTurn.setText("نوبت:بازیکن"+turn);

        check();
    }



    private void check()
    {

        int flag=0;//نشان دهنده پایان بازی




        if(btn1.getText().equals(symbol)&&btn2.getText().equals(symbol)&&btn3.getText().equals(symbol)) {


            //اگر محتویات یکی از سه دکمه در یک خط خالی بود شرط پایان بازی درست نیست
            if (!btn1.getText().toString().isEmpty()){

                flag=1;

            }

        }
        else if(btn1.getText().equals(symbol)&&btn5.getText().equals(symbol)&&btn9.getText().equals(symbol))
        {
            if (!btn1.getText().toString().isEmpty())
            {
                flag=1;
            }

        }
        else if(btn3.getText().equals(symbol)&&btn5.getText().equals(symbol)&&btn7.getText().equals(symbol))
        {
            if (!btn3.getText().toString().isEmpty()){
                flag=1;
            }

        }
        else if(btn4.getText().equals(symbol)&&btn5.getText().equals(symbol)&&btn6.getText().equals(symbol))
        {
            if (!btn4.getText().toString().isEmpty()){
                flag=1;
            }

        }
        else if(btn7.getText().equals(symbol)&&btn8.getText().equals(symbol)&&btn9.getText().equals(symbol))
        {

            if (!btn7.getText().toString().isEmpty()){

                flag=1;
            }


        }
        else if(btn1.getText().equals(symbol)&&btn4.getText().equals(symbol)&&btn7.getText().equals(symbol))
        {
            if (!btn1.getText().toString().isEmpty()){
                flag=1;
            }


        }
        else if(btn2.getText().equals(symbol)&&btn5.getText().equals(symbol)&&btn8.getText().equals(symbol))
        {
            if (!btn2.getText().toString().isEmpty()){
                flag=1;
            }


        }
        else if(btn3.getText().equals(symbol)&&btn6.getText().equals(symbol)&&btn9.getText().equals(symbol))
        {
            if (!btn3.getText().toString().isEmpty()){
                flag=1;
            }


        }

        if(flag==1)
        {

            isFinished=true;
           finishGame();

        }else{//بازی تمام نشده . تعیین مهره دور بعدی
            if (symbol.equals("X")){//تغییر رنگ به قرمز

                symbol="O";//برعکس کردن مهره برای بازیکن دور بعدی

            }else{//تغییر رنگ به سبز

                symbol="X";
            }
        }



    }


    void restartGame(){

        finish();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
    void finishGame(){

        playedGames++;

        restartGame();

        Intent i=new Intent(this,ActivityFinishedGame.class);

        if (!isFinished){
            Toast.makeText(this,"بازی تمام نشده",Toast.LENGTH_LONG).show();
        }else{
            //اینجا بازی تمام شده

            if (turn==2){
                winner="1";
                firstPlayerWins++;
            }else{
                winner="2";
                secondPlayerWins++;
            }
            isFinished=false;

         /*   i.putExtra("playedGames",playedGames);
            i.putExtra("winner",winner);
            i.putExtra("wins",winner);
            */
        }
        startActivity(i);
    }
}