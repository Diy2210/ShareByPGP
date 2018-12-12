package com.example.diy2210.sharebypgp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class TransferFileActivity extends AppCompatActivity implements View.OnClickListener {

    private Button user1Btn;
    private Button user2Btn;
    private ConstraintLayout constraintLayoutContent;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_file);

        constraintLayoutContent = findViewById(R.id.constraintLayoutContent);
        progressBar = findViewById(R.id.progressBar);

        user1Btn = findViewById(R.id.user1Btn);
        user2Btn = findViewById(R.id.user2Btn);

        user1Btn.setOnClickListener(this);
        user2Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user1Btn:
                AlertDialog();
                break;
            case R.id.user2Btn:
                AlertDialog();
                break;
        }
    }

    private void AlertDialog() {
        AlertDialog.Builder builder = new android.app.AlertDialog.Builder(TransferFileActivity.this);
        builder.setCancelable(false);
        builder.setMessage(R.string.message_transfer);
        builder.setPositiveButton(R.string.ok_button,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        constraintLayoutContent.setVisibility(View.GONE);
                        progressBar.setVisibility(ProgressBar.VISIBLE);
                        startActivity(new Intent(TransferFileActivity.this, MainActivity.class));
                        Toast.makeText(TransferFileActivity.this, "Complete!", Toast.LENGTH_LONG).show();
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
}
