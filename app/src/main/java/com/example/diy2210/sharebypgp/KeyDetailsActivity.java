package com.example.diy2210.sharebypgp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class KeyDetailsActivity extends AppCompatActivity {

    private Button transferBtn;
    private TextView nameTV;
    private TextView emailTV;
    private TextView fileTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_details);

        transferBtn = findViewById(R.id.transferBtn);
        transferBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new android.app.AlertDialog.Builder(KeyDetailsActivity.this);
                builder.setCancelable(false);
                builder.setMessage(R.string.message_transfer_file);
                builder.setPositiveButton(R.string.ok_button,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
//                                startActivity(new Intent(CreateKeyActivity.this, MainActivity.class));
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
