package com.example.kcfapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class locationOBJAdapter extends RecyclerView.Adapter<locationOBJAdapter.ViewHolder> {
    Context context;
    List<locationOBJ> orgList;
    RecyclerView rvPrograms;
    final View.OnClickListener onClickListener = new MyOnClickListener();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView rowName, rowAddress, rowService;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowName = itemView.findViewById(R.id.item_name);
            rowAddress = itemView.findViewById(R.id.item_address);
            rowService = itemView.findViewById(R.id.item_service);
        }
    }

    public locationOBJAdapter(Context context, List<locationOBJ> orgList, RecyclerView rvPrograms) {
        this.context = context;
        this.orgList = orgList;
        this.rvPrograms = rvPrograms;
    }

    @NonNull
    @Override
    public locationOBJAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item, parent, false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull locationOBJAdapter.ViewHolder holder, int position) {
        locationOBJ obj = orgList.get(position);
        holder.rowName.setText(""+obj.getName());
        holder.rowAddress.setText(""+obj.getAddress());
        holder.rowService.setText(""+obj.getService());
    }

    @Override
    public int getItemCount() {
        return orgList.size();
    }

    private class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int itemPosition = rvPrograms.getChildLayoutPosition(view);
            String item = orgList.get(itemPosition).getName();
            Toast.makeText(context, item, Toast.LENGTH_SHORT).show();
        }
    }
}
