package com.example.chokwanghwan.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class SimpleList3ActivityFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ArrayList<ListData> listDataArray = new ArrayList<ListData>();
    private ListView listView;

    public SimpleList3ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple_list3, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListData data1 = new ListData("1-첫번째 줄", "1-두번째 줄", "image1.jpeg");
        listDataArray.add(data1);
        ListData data2 = new ListData("2-첫번째 줄", "2-두번째 줄", "image2.jpeg");
        listDataArray.add(data2);
        ListData data3 = new ListData("3-첫번째 줄", "3-두번째 줄", "image3.jpeg");
        listDataArray.add(data3);
        ListData data4 = new ListData("4-첫번째 줄", "4-두번째 줄", "image4.jpeg");
        listDataArray.add(data4);
        ListData data5 = new ListData("5-첫번째 줄", "5-두번째 줄", "image5.jpeg");
        listDataArray.add(data5);

        listView = (ListView) view.findViewById(R.id.simple_list3_listView);

        CustomAdapter customAdapter = new CustomAdapter(getActivity(), R.layout.custom_list_row, listDataArray);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(getActivity(), position + "번 리스트 선택됨", Toast.LENGTH_SHORT).show();
    }
}
