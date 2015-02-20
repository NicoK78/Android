package com.example.nkervoern.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by nkervoern on 18/02/15.
 */
public class CityFragment extends Fragment implements AdapterView.OnItemClickListener {

    ArrayList<City> cities = new ArrayList<>();
    private ListView lvCities;
    private ArrayAdapter<City> cityArrayAdapter;
    private CityListener mCityListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_city, container, false);
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        lvCities = (ListView)view.findViewById(R.id.lv);
        lvCities.setOnItemClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        generateCities();

        cityArrayAdapter =  new ArrayAdapter<City>(getActivity(), android.R.layout.simple_list_item_1, cities);
        lvCities.setAdapter(cityArrayAdapter);
    }

    private void generateCities() {

        City paris = new City("Paris", "France");
        cities.add(paris);
        City rome = new City("Rome", "Italie");
        cities.add(rome);
        City londres = new City("Londres", "Angleterre");
        cities.add(londres);
        City berlin = new City("Berlin", "Allemagne");
        cities.add(berlin);
        City madrid = new City("Madrid", "Espagne");
        cities.add(madrid);

    }

    public void setCityListener(CityListener mCityListener) {
        this.mCityListener = mCityListener;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mCityListener.cityChanged(cityArrayAdapter.getItem(position));
    }
}
