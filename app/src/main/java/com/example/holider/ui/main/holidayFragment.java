package com.example.holider.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.holider.R;

public class holidayFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewholidays = inflater.inflate(R.layout.activity_holiday_fragment, container, false);
        String[] ListHolidays = {"01 Januari 2020",
                "17 Aguistus 2020",
                "17 Aguistus 2020",
                "17 Aguistus 2020",
                "17 Aguistus 2020",
                "17 Aguistus 2020",
                "17 Aguistus 2020",
                "17 Aguistus 2020",
                "17 Aguistus 2020",};

        ListView listView = viewholidays.findViewById(R.id.listHolidays);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                ListHolidays
        );
        listView.setAdapter(listViewAdapter);
        return viewholidays;
    }
}