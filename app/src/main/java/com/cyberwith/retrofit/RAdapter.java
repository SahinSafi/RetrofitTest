package com.cyberwith.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RAdapter extends RecyclerView.Adapter<RAdapter.MyViewHolder> {

    private Context context;
    private List<DataSet> dataSetList;

    public RAdapter(Context context, List<DataSet> dataSetList) {
        this.context = context;
        this.dataSetList = dataSetList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataSet dataSet = dataSetList.get(position);
        holder.nameText.setText(dataSet.getName());
        holder.hobbyText.setText(dataSet.getHobby());
    }

    @Override
    public int getItemCount() {
        return dataSetList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameText, hobbyText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.nameTextID);
            hobbyText = itemView.findViewById(R.id.hobbyTextID);
        }
    }
}
