package com.book.skysearch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

import models.AirportModel;

public class FlightSearch extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText dateView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_search);
        //OkHttpClient client = new OkHttpClient();
        spinner=findViewById(R.id.spinn);
        makeDropDown(spinner);
        dateView=findViewById(R.id.depDate);
        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDatePicker(dateView);
            }
        });

    }

    /**
     * function to add dropdown
     * @param spinner
     */
    private void makeDropDown(Spinner spinner) {

        ArrayList<AirportModel> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            AirportModel model = new AirportModel();
            model.setId(i);
            model.setName("Airport " + i);
            list.add(model);
        }

        ArrayAdapter<AirportModel> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    /**
     * function to add datePicker
     * @param dateView
     */
    private void setDatePicker(final EditText dateView) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        int monthDisplay = month + 1;
                        String date = year + "-";
                        if (monthDisplay <= 9) {
                            date = date + "0" + monthDisplay + "-";
                        } else {
                            date = date + monthDisplay + "-";
                        }
                        if (dayOfMonth <= 9) {
                            date = date + "0" + dayOfMonth;
                        } else {
                            date = date + dayOfMonth;
                        }
                        //Todo : add edittext reference here
                        dateView.setText(date);
//                        selectedDate = date;
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void goToPay(View view) {
        Intent main = new Intent(this, Payment.class);
        startActivity(main);
    }
}
