package com.ekosp.novellgeomessenger.navdrawer.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ekosp.novellgeomessenger.R;
import com.ekosp.novellgeomessenger.customlist.activity.CustomListActivity;
import com.ekosp.novellgeomessenger.customlist.activity.DetailActivity;
import com.ekosp.novellgeomessenger.customlist.adapter.CountryListAdapter;
import com.ekosp.novellgeomessenger.customlist.model.Country;

import java.util.ArrayList;
import java.util.List;


public class InboxFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //TODO : file tambahan custom
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

    // end tambahan

    private InboxFragment.OnFragmentInteractionListener mListener;

    public InboxFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InboxFragment newInstance(String param1, String param2) {
        InboxFragment fragment = new InboxFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        for (int i = 0;i<countryNames.length;i++){
            Country country = new Country();
            country.setName(countryNames[i]);
            country.setCapital(capital[i]);
            country.setFlag(flagId[i]);
            country.setCurrency(currency[i]);
            countryList.add(country);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inbox, container, false);
        listView=(ListView) view.findViewById(R.id.list);

        //custom
        for (int i = 0;i<countryNames.length;i++){
            Country country = new Country();
            country.setName(countryNames[i]);
            country.setCapital(capital[i]);
            country.setFlag(flagId[i]);
            country.setCurrency(currency[i]);
            countryList.add(country);
        }

        //Custom ListAdapter for our android custom listview
        countryListAdapter = new CountryListAdapter(getActivity(), countryList);
        //Setting ListView's adapter to the custom list adapter we've created
        listView.setAdapter(countryListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Declaring Intent
                //  Intent i = new Intent(CustomListActivity.this, DetailActivity.class);
                //Putting required data in intent
                //   i.putExtra("flag",flagId[position]);
                //   i.putExtra("details", details[position]);
                // startActivity(i);
                Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
            }
        });


        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String string) {
        if (mListener != null) {
            mListener.onInboxFragmentInteraction(string);
        }
    }

// di komen karena error MainActivity : OnFragmentInteractionListener error
   @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       if (context instanceof OnFragmentInteractionListener) {
           mListener = (OnFragmentInteractionListener) context;
       } else {
           throw new RuntimeException(context.toString()
                   + " must implement OnFragmentInteractionListener");
       }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
                public void onInboxFragmentInteraction(String string);

    }
}
