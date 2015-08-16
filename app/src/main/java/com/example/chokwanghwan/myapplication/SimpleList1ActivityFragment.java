package com.example.chokwanghwan.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class SimpleList1ActivityFragment extends Fragment {

    private ListView listView;
    ArrayList<String> arrayList = new ArrayList<String>();
    ArrayAdapter<String> simpleAdapter1;

    public SimpleList1ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple_list1, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView) view.findViewById(R.id.simple_list1_listView);

        arrayList = getActivity().getIntent().getExtras().getStringArrayList("testData");

        simpleAdapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(simpleAdapter1);
    }
}