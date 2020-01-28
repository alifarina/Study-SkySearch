package com.book.skysearch;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.book.skysearch.models.AirportModel;
import com.book.skysearch.models.Payment;
import com.book.skysearch.utilities.AppButton;
import com.book.skysearch.utilities.CustomEdittext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class FlightSearch extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private CustomEdittext dateView, returnDateView;
    private Spinner spinner;
    private TextView res;
    private CustomEdittext src;
    private AppButton btnSearch;
    private String srcIn, url, key, headParam;
    private EditText destinationEdt;
    private ArrayList<AirportModel> list;
    private ImageView calenderReturn, calenderDept;
    private EditText date_edt;
    private EditText re_date_edt;
    private RadioGroup radioGroup;
    private LinearLayout return_layout;
    private EditText source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_flight_search);

        initViews();

        createTextListeners();

        makeDropDown(spinner);

        createHttpClient();


    }

    private void createTextListeners() {
        source.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        destinationEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        calenderDept.setOnClickListener(this);
        calenderReturn.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.one_way) {
                    return_layout.setVisibility(View.GONE);
                } else {
                    return_layout.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    /**
     * createing http client to make an API call
     * - Abhishek Sharma
     */
    private void createHttpClient() {
        //client
        final OkHttpClient client = new OkHttpClient();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                srcIn = source.getText().toString();
                //getAirportList(client,srcIn,res);
                url = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/FR/EUR/en-GB/?query=";
                key = "f427fe1cb3msh666201577d0f4f9p16fc82jsn2987d1b3b0e3";
                headParam = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";
                url = url + srcIn;


                Request request = new Request.Builder()
                        .url(url)
                        .get()
                        .addHeader("x-rapidapi-host", headParam)
                        .addHeader("x-rapidapi-key", key)
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
     */
    private void getAirportList(OkHttpClient client, String srcIn, final TextView res) {

    }

    /**
     * method to initialize views
     * - Farina Ali
     */
    private void initViews() {
        res = findViewById(R.id.result);
        src = findViewById(R.id.source);
        source = src.getEditText();
        CustomEdittext des = findViewById(R.id.destination);
        destinationEdt = des.getEditText();
        btnSearch = findViewById(R.id.btnSearch);
        radioGroup = findViewById(R.id.flight_way);
        return_layout = findViewById(R.id.retun_layout);

        dateView = findViewById(R.id.depDate);
        date_edt = dateView.getEditText();
        date_edt.setFocusable(false);
        date_edt.setFocusableInTouchMode(false);
        date_edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDatePicker(date_edt);
            }
        });

        returnDateView = findViewById(R.id.returnDate);
        re_date_edt = returnDateView.getEditText();
        re_date_edt.setFocusable(false);
        re_date_edt.setFocusableInTouchMode(false);
        re_date_edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDatePicker(re_date_edt);
            }
        });

        spinner = findViewById(R.id.spinn);

        calenderDept = findViewById(R.id.date_click);
        calenderReturn = findViewById(R.id.returndate_click);
    }


    /**
     * function to add dropdown
     *
     * @param spinner - Farina Ali
     */
    private void makeDropDown(Spinner spinner) {

        list = new ArrayList<>();
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
     *
     * @param dateView - Farina Ali
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.date_click:
                setDatePicker(date_edt);
                break;
            case R.id.returndate_click:
                setDatePicker(re_date_edt);
                break;
        }
    }
}
