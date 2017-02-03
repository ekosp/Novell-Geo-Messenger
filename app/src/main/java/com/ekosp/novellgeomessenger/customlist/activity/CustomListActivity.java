package com.ekosp.novellgeomessenger.customlist.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ekosp.novellgeomessenger.R;
import com.ekosp.novellgeomessenger.customlist.adapter.CountryListAdapter;
import com.ekosp.novellgeomessenger.customlist.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CustomListActivity extends Activity {

    private List<Country> countryList = new ArrayList<>();
    private CountryListAdapter countryListAdapter;

    private ListView listView;

    String[] countryNames = new String[]{
            "India", "Australia","China", "Indonesia", "Japan", "Newzealand","Russia","South Korea",
            "India", "Australia","China", "Indonesia", "Japan", "Newzealand","Russia","South Korea"
    };
    int[] flagId = new int[]{
            R.drawable.bg_circle, R.drawable.bg_circle,R.drawable.bg_circle,R.drawable.bg_circle,
            R.drawable.bg_circle,R.drawable.bg_circle,R.drawable.bg_circle,R.drawable.bg_circle,
            R.drawable.bg_circle, R.drawable.bg_circle,R.drawable.bg_circle,R.drawable.bg_circle,
            R.drawable.bg_circle,R.drawable.bg_circle,R.drawable.bg_circle,R.drawable.bg_circle
    };
    String[] capital = new String[]{
            "New Delhi", "Sydney", "Beijing","Jakarta", "Tokyo", "Wellington", "Moscow", "Seoul",
            "New Delhi", "Sydney", "Beijing","Jakarta", "Tokyo", "Wellington", "Moscow", "Seoul"
    };

    String[] currency = new String[]{
            "Rupee", "Dollar", "Renminbi","Rupiah",
            "Yen","Dollar","Ruble","Won", "Rupee", "Dollar", "Renminbi","Rupiah",
            "Yen","Dollar","Ruble","Won"
    };

    int[] details = new int[]{
            R.string.details_india,R.string.details_australia,R.string.details_china,
            R.string.details_indonesia,R.string.details_japan,R.string.details_newzealand,
            R.string.details_russia,R.string.details_southkorea,  R.string.details_india,R.string.details_australia,R.string.details_china,
            R.string.details_indonesia,R.string.details_japan,R.string.details_newzealand,
            R.string.details_russia,R.string.details_southkorea
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      // setSupportActionBar(toolbar);

        for (int i = 0;i<countryNames.length;i++){
            Country country = new Country();
            country.setName(countryNames[i]);
            country.setCapital(capital[i]);
            country.setFlag(flagId[i]);
            country.setCurrency(currency[i]);
            countryList.add(country);
        }


        listView = (ListView) findViewById(R.id.list);
        //Custom ListAdapter for our android custom listview
        countryListAdapter = new CountryListAdapter(this, countryList);
        //Setting ListView's adapter to the custom list adapter we've created
        listView.setAdapter(countryListAdapter);

        //Open a new activity when a list item from android custom listview is clicked.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Declaring Intent
                Intent i = new Intent(CustomListActivity.this, DetailActivity.class);
                //Putting required data in intent
                i.putExtra("flag",flagId[position]);
                i.putExtra("details", details[position]);
                startActivity(i);
            }
        });


    }


}