package com.example.diy2210.sharebypgp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddFileActivity extends AppCompatActivity {

    private EditText nameET;
    private EditText emailET;
    private TextView fileTV;
    private Button nextBtn;
    private Button chooseFileBtn;
    private String fileName;
    private DateFormat dateFormat;
    private ConstraintLayout constraintLayoutContent;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_key);

        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        nameET = findViewById(R.id.nameET);
        emailET = findViewById(R.id.emailET);
        fileTV = findViewById(R.id.fileTV);
        chooseFileBtn = findViewById(R.id.chooseFileBtn);
        nextBtn = findViewById(R.id.nextBtn);
        constraintLayoutContent = findViewById(R.id.constraintLayoutContent);
        progressBar = findViewById(R.id.progressBar);

        chooseFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent, 100);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new android.app.AlertDialog.Builder(AddFileActivity.this);
                builder.setCancelable(false);
                builder.setMessage(R.string.message_create_key);
                builder.setPositiveButton(R.string.ok_button,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Date date = new Date();
                                String time = dateFormat.format(date)+"\n";
                                String name = nameET.getText().toString();
                                String email = emailET.getText().toString();
                                String file = fileTV.getText().toString();
                                SQLHelper sqlHelper = new SQLHelper(AddFileActivity.this);
                                sqlHelper.insertCounterDetails(time, name, email, file);
                                progressBar.setVisibility(ProgressBar.VISIBLE);
                                constraintLayoutContent.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(AddFileActivity.this, MainActivity.class));
                            }
                        })
                        .setNegativeButton(R.string.cancel_button,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        dialog.dismiss();
                                    }
                                }
                        ).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        switch (requestCode) {
            case 100:
                if (resultCode == RESULT_OK) {
                    fileName = data.getData().getPath();
                    fileTV.setVisibility(View.VISIBLE);
                    chooseFileBtn.setVisibility(View.GONE);
                    fileTV.setText(fileName);
                }
                break;
        }
    }
}
