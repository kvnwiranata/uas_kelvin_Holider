package com.example.holider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button wallOfHolider;
    private Button wallOfHolidays;
    CalendarView calendarView;
    TextView ourDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendar_view);
        ourDate = findViewById(R.id.our_date);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + " - " + month + " - " + year;
                ourDate.setText(date);
            }
        });

        wallOfHolider = findViewById(R.id.wallOfHolider);
        wallOfHolider.setOnClickListener(this);

        wallOfHolidays = findViewById(R.id.wallOfHolidays);
        wallOfHolidays.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.wallOfHolider:
                startActivity(new Intent(this, wall_of_holider.class));
                break;
            case R.id.wallOfHolidays:
                startActivity(new Intent(this, wall_of_holiday.class));
                break;
        }
    }
}