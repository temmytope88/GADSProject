package com.temmy.gadsleadersboard;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class IQFrag extends Fragment {

    ArrayList<String> mname;
    ArrayList<String> mdetails;
    ArrayList<String> mImageUrl;
    RecyclerView mRecyclerView;
    SkillAdapter mAdapter;
    View mView;
    String extension;
    URL mBuilder;

    String result;

    public IQFrag() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        extension = "/api/skilliq";
        mBuilder = ApiBuilder.ApiBuilder(extension);
        try {
            result = new Dataquery().execute(mBuilder).get();
            JSONArray jsonArray = new JSONArray(result);
            mname = new ArrayList<String>();
            mdetails = new ArrayList<String>();
            mImageUrl = new ArrayList<String>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String country = jsonObject.getString("country");
                String badge = jsonObject.getString("badgeUrl") ;
                int score = jsonObject.getInt("score");
                String details = score+ " Skill IQ Score, "+country;
                mname.add(name);
                mdetails.add(details);
                mImageUrl.add(badge);
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
        mView = inflater.inflate(R.layout.iq_frag, container, false);

        mRecyclerView = mView.findViewById(R.id.recycler);
        mAdapter = new SkillAdapter(mname, mdetails, mImageUrl, mView.getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        return mView;
    }
}