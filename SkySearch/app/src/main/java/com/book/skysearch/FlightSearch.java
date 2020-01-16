package com.book.skysearch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.transform.Source;

import models.AirportModel;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FlightSearch extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText dateView;
    private Spinner spinner;
    private TextView res;
    private EditText src;
    private Button btnSearch;
    private String srcIn,url,key,headParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_flight_search);
        spinner=findViewById(R.id.spinn);
        makeDropDown(spinner);
        dateView=findViewById(R.id.depDate);

        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDatePicker(dateView);
            }
        });


        res=findViewById(R.id.result);
        src=findViewById(R.id.source);
        btnSearch=findViewById(R.id.btnSearch);


        //client
        final OkHttpClient client= new OkHttpClient();



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                srcIn=src.getText().toString();
                //getAirportList(client,srcIn,res);
                url="https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/FR/EUR/en-GB/?query=";
                key="f427fe1cb3msh666201577d0f4f9p16fc82jsn2987d1b3b0e3";
                headParam="skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";
                url=url+srcIn;



                Request request=new Request.Builder()
                        .url(url)
                        .get()
                        .addHeader("x-rapidapi-host",headParam)
                        .addHeader("x-rapidapi-key",key)
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    res.setText(response.body().string());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * function to get airport List for dropdown suggestion
     *
     */
    private void getAirportList(OkHttpClient client, String srcIn, final TextView res){

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
