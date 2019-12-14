package com.example.holider;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class wall_of_holider extends AppCompatActivity implements View.OnClickListener {
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_of_holider);

        btnBack = findViewById(R.id.home);
        btnBack.setOnClickListener(this);

        Button openIg = findViewById(R.id.openIg);
        openIg.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.openIg:
                Uri uri = Uri.parse("http://instagram.com/_u/klvnwiranata");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.instagram.android");
                try
                {
                    Toast.makeText(wall_of_holider.this, "Instagram", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                catch (ActivityNotFoundException e)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/instagram")));
                }
                break;
            case R.id.home:
                finish();
                break;
        }
    }
}
