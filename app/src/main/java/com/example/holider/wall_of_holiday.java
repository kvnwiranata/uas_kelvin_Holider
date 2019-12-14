package com.example.holider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.holider.ui.main.SectionsPagerAdapter;

public class wall_of_holiday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_of_holiday);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    public void submitOrder(View view) {

        EditText fromField = findViewById(R.id.isiFrom);
        Editable fromEditable = fromField.getText();
        String isiFrom = fromEditable.toString();

        EditText kritikField = findViewById(R.id.isiKritik);
        Editable kritikEditable = kritikField.getText();
        String isiKritik = kritikEditable.toString();

        EditText saranField = findViewById(R.id.isiSaran);
        Editable saranEditable = saranField.getText();
        String isiSaran = saranEditable.toString();

        String message = createOrderSummary(isiFrom, isiKritik, isiSaran);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: HoliDer@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT,
                getString(R.string.summary_email_subject, isiFrom));
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    private String createOrderSummary(String isiForm, String isiKritik, String isiSaran) {
        String feedback = getString(R.string.summary_from, isiForm);
        feedback += "\n" + getString(R.string.summary_kritik, isiKritik);
        feedback += "\n" + getString(R.string.summary_saran, isiSaran);

        return feedback;
    }
}