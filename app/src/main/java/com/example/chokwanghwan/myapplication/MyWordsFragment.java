package com.example.chokwanghwan.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class MyWordsFragment extends Fragment {

    MWApplication mwA;
    private ListView listView;

    public MyWordsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mwA = (MWApplication) getActivity().getApplication();

        return inflater.inflate(R.layout.fragment_my_words, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView) view.findViewById(R.id.myWordslistView);
        mwA.myWordsService.listWords(new Callback<List<Word>>() {
            @Override
            public void success(List<Word> wordses, Response response) {
                MyWordsAdapter myWordsAdapter = new MyWordsAdapter(getActivity(), (ArrayList<Word>) wordses);
                listView.setAdapter(myWordsAdapter);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}