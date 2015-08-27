package io.mrbenj.recviewtutorial;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This Adapter is used for the RecyclerView.
 *
 * Like the original ListView, RecyclerView takes it's own adapter returning a View. In using
 * RecyclerView, we are extending RecyclerView.Adapter<YourAdapterName.ViewHolder> instead of
 * BaseAdapter. You still need to use the ViewHolder pattern just like before, but the main trade
 * is that you don't require using getTag() on each view to see if it's created or not.
 *
 * Also, the adapter's constructor is much easier, as you just pass in whatever data you're looking
 * for, then set the RecyclerView's adapter in your activity. Boom. Done.
 *
 * While the code isn't quite as fresh, it's still pretty new and hopefully Google will be updating
 * it soon, so the amount of code written isn't so heavy.
 *
 * Created by benjunya on 8/27/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> mDataset;


    public MyAdapter(ArrayList<String> dataset) {
        mDataset = dataset;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;

        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    public void add(int position, String item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final String name = mDataset.get(position);
        holder.txtHeader.setText(mDataset.get(position));
        holder.txtFooter.setText(mDataset.get(position));
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(name);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
