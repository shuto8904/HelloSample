package com.example.hellosample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //表示ボタンのあるButtonオブジェクトを取得
        Button btClick = findViewById(R.id.btClick);
        //リスナクラスのインスタンスを生成
        HelloListener listener = new HelloListener();
        //表示ボタンにリスナ設定
        btClick.setOnClickListener(listener);
        //クリアボタンであるボタンオブジェクトを取得
        Button btClear = findViewById(R.id.btClear);
        //クリアボタンにリスナの設定
        btClear.setOnClickListener(listener);
    }

    //ボタンをクリックしたときのリスナクラス
    private class HelloListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            //名前入力のEditTextオブジェクトを取得
            EditText input = findViewById(R.id.etName);
            //メッセージを表示するTextViewオブジェクトを取得
            TextView output = findViewById(R.id.tvOutput);

             int id = view.getId();
            //idのR値に応じて処理の分岐
            switch(id) {
                //表示ボタンの場合
                case R.id.btClick:

                    //入力された文字列の取得
                    String inputStr = input.getText().toString();
                    //メッセージを表示
                    output.setText(inputStr + "さん、こんにちは");
                break;

                case R.id.btClear:
                    input.setText("");
                    output.setText("");
                    break;
            }
            }

        }
    }
