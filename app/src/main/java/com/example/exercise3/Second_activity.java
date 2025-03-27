package com.example.exercise3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Second_activity extends AppCompatActivity {

    EditText RawContent;
    Button SubmitBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RawContent = findViewById(R.id.multiLineEditText3);
        SubmitBt = findViewById(R.id.button2);

        Intent myIntent = getIntent();
        String fixedContent = myIntent.getStringExtra("Content");

        if (fixedContent != null) {
            RawContent.setText(fixedContent);
        }

        SubmitBt.setOnClickListener(v -> {
            String editedText = RawContent.getText().toString();

            Intent resultIntent = new Intent();
            resultIntent.putExtra("EditedText", editedText);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
