package com.example.androiditproger;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView info = findViewById(R.id.textView);
        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showInfo(info.getText().toString(), btn2);

                showInfoAlert("Вы хотите закрыть приложение?");
            }
        });
    }

    public void btnClick(View v) {
        showInfo(((Button) v).getText().toString(), ((Button) v));
    }

    private void showInfo(String info, Button btn) {
        btn.setText("Уже нажали");
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.CYAN));
        Toast.makeText(this, info, Toast.LENGTH_LONG).show();
    }

    private void showInfoAlert(String info) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Большая подсказка")
                .setMessage(info)
                .setCancelable(false)
                .setPositiveButton("Конечно!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Нет!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}