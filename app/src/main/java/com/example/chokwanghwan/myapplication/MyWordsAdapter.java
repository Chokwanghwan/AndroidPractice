package com.example.chokwanghwan.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chokwanghwan on 15. 8. 13..
 */
public class MyWordsAdapter extends ArrayAdapter<Word> {
    static int resourceId = R.layout.custom_list_for_mywords;
    private Context context;
    private ArrayList<Word> listData;

    public MyWordsAdapter(Context context, ArrayList<Word> listData) {
        super(context, resourceId, listData);
        this.context = context;
        this.listData = listData;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null)
            row = onCreateView(position, parent);
        onBindView(position, row);

        return row;
    }

    @NonNull
    private View onCreateView(int position, ViewGroup parent) {
        View row;
        ViewHolder viewHolder;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        row = inflater.inflate(resourceId, parent, false);
        TextView tvText1 = (TextView) row.findViewById(R.id.englishArea);
        TextView tvText2 = (TextView) row.findViewById(R.id.meanArea);
        Button btn = (Button) row.findViewById(R.id.delete_button);

        viewHolder = new ViewHolder(position, tvText1, tvText2, btn);
        row.setTag(viewHolder);
        return row;
    }

    private void onBindView(int position, View row) {
        ViewHolder viewHolder;
        viewHolder = (ViewHolder) row.getTag();
        viewHolder.tvEnglish.setText(listData.get(position).getEnglish());
        viewHolder.tvMean.setText(listData.get(position).getMean());
    }

    private class ViewHolder implements View.OnClickListener {

        public int position;
        public TextView tvEnglish;
        public TextView tvMean;
        public Button btnDelete;

        public ViewHolder(int position, TextView tvEnglish, TextView tvMean, Button btnDelete) {
            this.tvEnglish = tvEnglish;
            this.tvMean = tvMean;
            this.btnDelete = btnDelete;
            this.position = position;

            btnDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listData.remove(position);
            notifyDataSetChanged();
        }
    }
}