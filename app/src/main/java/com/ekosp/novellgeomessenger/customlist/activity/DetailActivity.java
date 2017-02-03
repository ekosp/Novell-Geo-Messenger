package com.ekosp.novellgeomessenger.customlist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ekosp.novellgeomessenger.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView tvDetails = (TextView) findViewById(R.id.tvDetails);
        ImageView ivDetails = (ImageView) findViewById(R.id.ivDetails);

        Intent i = getIntent();
        //retriving data from intents and setting it to textview and imageview
        ivDetails.setImageResource(i.getIntExtra("flag", R.drawable.ic_local_movies_black_24dp));
        tvDetails.setText(i.getIntExtra("details", R.string.details_india));
    }
}