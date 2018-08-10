package com.example.sunm.when;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {
    private Button cau;
    private EditText moon;
    private EditText work;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cau = (Button)findViewById(R.id.cau);
        moon = (EditText)findViewById(R.id.moon);
        work = (EditText)findViewById(R.id.work);
        result = (TextView)findViewById(R.id.result);
        result.setVisibility(View.GONE);
        cau.setEnabled(false);
        moon.addTextChangedListener(this);
        work.addTextChangedListener(this);
        cau.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cau:
                try {
                    int moonGoal = Integer.parseInt(moon.getText().toString());
                    int workGoal = Integer.parseInt(work.getText().toString());
                    Log.d("XXDF", moonGoal + "");
                    Log.d("XXDF", workGoal + "");
                    result.setVisibility(View.VISIBLE);
                }catch (NumberFormatException e){
                    Toast.makeText(this,"请输入数字", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        cau.setEnabled(false);//在这里重复设置，以保证清除任意EditText中的内容，按钮重新变回不可点击状态
    }


    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }


    public void afterTextChanged(Editable s) {
        if (!(moon.getText().toString().equals("") || work.getText().toString().equals(""))){
            cau.setEnabled(true);
        }
    }
}

