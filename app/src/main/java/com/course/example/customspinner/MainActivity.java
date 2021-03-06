package com.course.example.customspinner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //arrays are set up with dummy first items to avoid selection showing when spinner is initializing
    String[] countryNames={"Select a Country", "Denmark","China","Germany","US", "UK","India","Canada","Norway"};
    int flags[] = {0, R.drawable.denmark, R.drawable.china, R.drawable.germany, R.drawable.us, R.drawable.uk,
                                           R.drawable.india, R.drawable.ca, R.drawable.norway};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);
        spin.setOnItemSelectedListener(this);

        CustomAdapter customAdapter=new CustomAdapter(this,flags,countryNames);
        spin.setAdapter(customAdapter);
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(this, countryNames[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}