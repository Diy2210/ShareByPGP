package com.example.diy2210.sharebypgp;

import android.content.Intent;
import android.graphics.Paint;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailET;
    private EditText passwordET;
    private CheckBox checkBox;
    private Button passwordBtn;
    private Button enterBtn;
    private Button registerBtn;
    private Button facebookBtn;
    private Button vkBtn;
    private Button googleBtn;
    private ProgressBar progressBar;
    private ConstraintLayout constraintLayoutContent;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        passwordBtn = findViewById(R.id.passwordBtn);
        checkBox = findViewById(R.id.checkBox);
        registerBtn = findViewById(R.id.registerBtn);
        enterBtn = findViewById(R.id.enterBtn);
        facebookBtn = findViewById(R.id.facebookBtn);
        vkBtn = findViewById(R.id.vkBtn);
        googleBtn = findViewById(R.id.googleBtn);
        constraintLayoutContent = findViewById(R.id.constraintLayoutContent);
        progressBar = findViewById(R.id.progressBar);

        passwordBtn.setPaintFlags(passwordBtn.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        registerBtn.setPaintFlags(registerBtn.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        passwordBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        enterBtn.setOnClickListener(this);
        facebookBtn.setOnClickListener(this);
        vkBtn.setOnClickListener(this);
        googleBtn.setOnClickListener(this);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //TODO
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.passwordBtn:
                break;
            case R.id.registerBtn:
                break;
            case R.id.enterBtn:
                startActivity();
                break;
            case R.id.facebookBtn:
                startActivity();
                break;
            case R.id.vkBtn:
                startActivity();
                break;
            case R.id.googleBtn:
                startActivity();
                break;
        }
    }

    private void startActivity() {
        constraintLayoutContent.setVisibility(View.GONE);
        progressBar.setVisibility(ProgressBar.VISIBLE);
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    // Back Button Exit App
    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
        Toast.makeText(this, R.string.click_back_exit, Toast.LENGTH_LONG).show();
        back_pressed = System.currentTimeMillis();
    }
}
