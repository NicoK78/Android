package com.example.nkervoern.fragmentapp;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by nkervoern on 18/02/15.
 */
public class OneCityFrag extends Fragment {

    private TextView tv;

    public static OneCityFrag cityDetails(City city){

        OneCityFrag frag = new OneCityFrag();


        Bundle bundle = new Bundle();
        bundle.putParcelable("city", city);

        frag.setArguments(bundle);

        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv = (TextView)view.findViewById(R.id.tv);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        City tmp = getArguments().getParcelable("city");

        new MyAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tmp.name );

        //City city = getArguments().getParcelable("city");
        //tv.setText(tmp.country);
    }


    class MyAsyncTask extends AsyncTask<String, Void, City> {

        @Override
        protected City doInBackground(String... params) {

            String request = "http://api.openweathermap.org/data/2.5/weather?q="+params[0];

            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response;
            City cityResponse = null;
            try {

                response = httpclient.execute(new HttpGet(request));
                StatusLine statusLine = response.getStatusLine();
                if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    response.getEntity().writeTo(out);
                    String resp = out.toString();

                    JSONObject jsonObject = new JSONObject(resp);
                    cityResponse = new City(params[0], jsonObject.getJSONObject("sys").getString("country"));

                    out.close();
                } else{
                    //Closes the connection.
                    response.getEntity().getContent().close();
                    throw new IOException(statusLine.getReasonPhrase());
                }
            } catch (ClientProtocolException e) {
                //TODO Handle problems..
            } catch (IOException e) {
                //TODO Handle problems..
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return cityResponse;

            // requête            params[0];            return null;
        }

        @Override
        protected void onPostExecute(City city) {
            super.onPostExecute(city);
            Log.i("city", city.country);

            // modifier le fragment
            tv.setText(city.country);

        }
    }

}
