package com.example.diy2210.sharebypgp;

import android.content.Intent;
import android.graphics.Paint;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;

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
        progressBar.setVisibility(ProgressBar.GONE);

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
        startActivity(new Intent(SignInActivity.this, MainActivity.class));
    }
}
