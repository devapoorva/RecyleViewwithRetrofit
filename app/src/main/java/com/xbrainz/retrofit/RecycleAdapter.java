package com.xbrainz.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Viewholder> {

    private Context context;
    private List<ApiModel> apiModelList;

    public RecycleAdapter(Context context, List<ApiModel> apiModelList) {
        this.context = context;
        this.apiModelList = apiModelList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.userid.setText(apiModelList.get(position).getUserId()+"");
        holder.body.setText(apiModelList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return apiModelList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder
    {
        public TextView userid,body;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            userid = itemView.findViewById(R.id.txt_id);
            body = itemView.findViewById(R.id.txt_body);
        }
    }
}
