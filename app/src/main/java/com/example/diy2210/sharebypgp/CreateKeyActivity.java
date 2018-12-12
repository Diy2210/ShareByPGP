package com.example.diy2210.sharebypgp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateKeyActivity extends AppCompatActivity {

    private EditText nameET;
    private EditText emailET;
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_key);

        nameET = findViewById(R.id.nameET);
        emailET = findViewById(R.id.emailET);

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
    }
}
