package com.example.chokwanghwan.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chokwanghwan on 15. 8. 12..
 */
public class CustomAdapter extends ArrayAdapter<ListData>{
    private Context context;
    private int layoutResourceId;
    private ArrayList<ListData> listData;


    public CustomAdapter(Context context, int resource, ArrayList<ListData> listData) {
        super(context, resource, listData);

        this.context = context;
        this.layoutResourceId = resource;
        this.listData = listData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();

            row = inflater.inflate(layoutResourceId, parent, false);
        }

        TextView tvText1 = (TextView) row.findViewById(R.id.title);
        TextView tvText2 = (TextView) row.findViewById(R.id.subtitle);

        tvText1.setText(listData.get(position).getText1());
        tvText2.setText(listData.get(position).getText2());

        ImageView imageView = (ImageView) row.findViewById(R.id.imageView);

        try {
            InputStream is = context.getAssets().open(listData.get(position).getImgName());

            Drawable d = Drawable.createFromStream(is, null);
            imageView.setImageDrawable(d);
        } catch (IOException e) {
            Log.e("ERROR", "ERROR:" + e);
        }

        return row;
    }
}
