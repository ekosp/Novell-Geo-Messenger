package com.ekosp.novellgeomessenger.customlist.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ekosp.novellgeomessenger.R;
import com.ekosp.novellgeomessenger.customlist.model.Country;

import java.util.List;

/**
 * Created by eko.purnomo on 01/02/2017.
 * You can contact me at : ekosetyopurnomo@gmail.com
 * or for more detail at  : http://ekosp.com
 */

public class CountryListAdapter extends BaseAdapter {

    private Activity activity;
    private List<Country> countryList;
    private LayoutInflater inflater;

    public CountryListAdapter(Activity activity, List<Country> countryList){
       this.activity = activity;
        this.countryList = countryList;
    }




    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null){
            inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item_custom, null);
        }
        ImageView flag = (ImageView) convertView.findViewById(R.id.ivFlag);
        TextView name  = (TextView) convertView.findViewById(R.id.tvCountryName);
        TextView capital = (TextView) convertView.findViewById(R.id.tvCapital);
        TextView currency = (TextView) convertView.findViewById(R.id.tvCurrency);

        Country country = countryList.get(position);
        flag.setImageResource(country.getFlag());
        name.setText(country.getName());
        capital.setText(country.getCapital());
        currency.setText(country.getCurrency());

        return convertView;
    }
}