package com.example.chokwanghwan.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by chokwanghwan on 15. 8. 16..
 */
public class RecyclerViewMyWordsAdapter extends RecyclerView.Adapter {
    private static final String POSITION_KEY = "position_key";
    private List<Word> words;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public int position;
        public TextView tvEnglish;
        public TextView tvMean;
        public Button btnDeleted;

        public ViewHolder(LinearLayout rootView) {
            super(rootView);
            tvEnglish = (TextView) rootView.findViewById(R.id.englishArea);
            tvMean = (TextView) rootView.findViewById(R.id.meanArea);
            btnDeleted = (Button) rootView.findViewById(R.id.delete_button);
            position = (int) ((HashMap)rootView.getTag()).get(POSITION_KEY);

            btnDeleted.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            words.remove(position);
            notifyDataSetChanged();
        }
    }

    public RecyclerViewMyWordsAdapter(List<Word> words) {
        this.words = words;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int position) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_list_for_mywords, viewGroup, false);

        HashMap tagMap = new HashMap(){
            {
                put(POSITION_KEY, position);
            }
        };
        v.setTag(tagMap);
        ViewHolder vh = new ViewHolder((LinearLayout) v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolder vh = (ViewHolder) viewHolder;
        vh.tvEnglish.setText(words.get(position).getEnglish());
        vh.tvMean.setText(words.get(position).getMean());
    }

    @Override
    public int getItemCount() {
        return words.size();
    }
}
