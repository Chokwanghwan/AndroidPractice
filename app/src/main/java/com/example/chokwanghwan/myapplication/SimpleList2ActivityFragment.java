package com.example.chokwanghwan.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class SimpleList2ActivityFragment extends Fragment {
    ListView listView;
    ArrayList<HashMap<String, String>> hashMapList1 = new ArrayList<HashMap<String, String>>(2);
    SimpleAdapter simpleAdapter2;

    public SimpleList2ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple_list2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView) view.findViewById(R.id.simple_list2_listView);

        for (int i=0; i<10; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("line1", "첫번째 줄의 " +i+ "번");
            map.put("line2", "두번째 줄의 " +i+ "번");
            hashMapList1.add(map);
        }

        String[] from = { "line1", "line2" };
        int[] to = { android.R.id.text1, android.R.id.text2};

        simpleAdapter2 = new SimpleAdapter(getActivity(), hashMapList1, android.R.layout.simple_list_item_2, from, to);

        listView.setAdapter(simpleAdapter2);
    }
}
