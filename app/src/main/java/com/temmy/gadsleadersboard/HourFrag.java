package com.temmy.gadsleadersboard;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class HourFrag extends Fragment {
    View mView;
    ArrayList<String> mName, mDetails, mimageurl;
    HourAdadpter mAdadpter;
    RecyclerView mRecyclerView;
    String extension;
    URL mBuilder;
    String result;
    ProgressBar mProgressBar;

    public HourFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        extension = "/api/hours";
        mBuilder = ApiBuilder.ApiBuilder(extension);
        mProgressBar = mView.findViewById(R.id.progressbr);
        TextView mNetworkmsg = mView.findViewById(R.id.network);
        try {
                result = new Dataquery(mProgressBar, mNetworkmsg).execute(mBuilder).get();
                JSONArray jsonArray = new JSONArray(result);
                mName = new ArrayList<String>();
                mDetails = new ArrayList<String>();
                mimageurl = new ArrayList<String>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String country = jsonObject.getString("country");
                    String badgeurl = jsonObject.getString("badgeUrl");
                    int hour = jsonObject.getInt("hours");
                    String details = hour+ " learning hours, "+country;
                    mName.add(name);
                    mDetails.add(details);
                    mimageurl.add(badgeurl);
            }
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.hour_frag, container, false);
        mRecyclerView = mView.findViewById(R.id.recyclerHr);
        mAdadpter = new HourAdadpter(mName, mDetails, mimageurl, mView.getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdadpter);
        return mView;
    }


}