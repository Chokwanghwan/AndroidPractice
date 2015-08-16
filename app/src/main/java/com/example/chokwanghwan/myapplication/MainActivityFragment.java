package com.example.chokwanghwan.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {
    private Button simpleList1;
    private Button simpleList2;
    private Button simpleList3;
    private Button myWordsBtn;
    private Button myWordsRecyclerViewTestBtn;

    ArrayList<String> arrayList = new ArrayList<String>();

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        makeTestArray();

        simpleList1 = (Button) view.findViewById(R.id.simpleListBtn1);
        simpleList2 = (Button) view.findViewById(R.id.simpleListBtn2);
        simpleList3 = (Button) view.findViewById(R.id.simpleListBtn3);
        myWordsBtn = (Button) view.findViewById(R.id.myWordsBtn);
        myWordsRecyclerViewTestBtn = (Button) view.findViewById(R.id.recyclerTestBtn);

        simpleList1.setOnClickListener(this);
        simpleList3.setOnClickListener(this);
        simpleList2.setOnClickListener(this);
        myWordsBtn.setOnClickListener(this);
        myWordsRecyclerViewTestBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simpleListBtn1:
                Intent intentSimpleList1 = new Intent(getActivity(), SimpleList1Activity.class);
                intentSimpleList1.putExtra("testData", arrayList);
                startActivity(intentSimpleList1);
                break;
            case R.id.simpleListBtn2:
                Intent intentSimpleList2 = new Intent(getActivity(), SimpleList2Activity.class);
                startActivity(intentSimpleList2);
                break;
            case R.id.simpleListBtn3:
                Intent intentSimpleList3 = new Intent(getActivity(), SimpleList3Activity.class);
                startActivity(intentSimpleList3);
                break;
            case R.id.myWordsBtn:
                Intent intentMyWords = new Intent(getActivity(),MyWords.class);
                startActivity(intentMyWords);
                break;
            case R.id.recyclerTestBtn:
                Intent intentRecyclerViewTest = new Intent(getActivity(), MyWordsRecyclerViewActivity.class);
                startActivity(intentRecyclerViewTest);
                break;
        }
    }

    public void makeTestArray() {
        arrayList.add("데이터1");
        arrayList.add("데이터2");
        arrayList.add("데이터3");
        arrayList.add("데이터4");
        arrayList.add("데이터5");
        arrayList.add("데이터6");
        arrayList.add("데이터7");
    }
}