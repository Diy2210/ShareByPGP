package com.example.diy2210.sharebypgp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateKeyActivity extends AppCompatActivity {

    private EditText nameET;
    private EditText emailET;
    private TextView fileTV;
    private Button nextBtn;
    private Button chooseFileBtn;
    private String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_key);

        nameET = findViewById(R.id.nameET);
        emailET = findViewById(R.id.emailET);
        fileTV = findViewById(R.id.fileTV);
        chooseFileBtn = findViewById(R.id.chooseFileBtn);
        nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new android.app.AlertDialog.Builder(CreateKeyActivity.this);
                builder.setCancelable(false);
                builder.setMessage(R.string.message_create_key);
                builder.setPositiveButton(R.string.ok_button,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Intent intent = new Intent(CreateKeyActivity.this, ListKeysActivity.class);
                                intent.putExtra("name", nameET.getText().toString());
                                intent.putExtra("email", emailET.getText().toString());
                                startActivity(intent);
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

        chooseFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent, 100);
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
                    Toast.makeText(CreateKeyActivity.this, fileName, Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
