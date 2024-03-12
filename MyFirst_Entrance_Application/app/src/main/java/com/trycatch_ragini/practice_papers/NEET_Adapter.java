package com.trycatch_ragini.practice_papers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.trycatch_ragini.pratice_paper.R;

import java.util.ArrayList;

public class NEET_Adapter extends RecyclerView.Adapter<NEET_Adapter.ViewHolder> {

    Context context;
    ArrayList<NEET_Pojo> pojos;

    public NEET_Adapter(Context context, ArrayList<NEET_Pojo> pojos) {
        this.context = context;
        this.pojos = pojos;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.neet_singlrow, parent, false);
        ViewHolder viewHolder = new ViewHolder(view1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.id.setText("id: " + pojos.get(position).getId());
        holder.year.setText("year" + pojos.get(position).getYear());

        holder.year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NEET_ButtonActivity.class);
                intent.putExtra("Pdf file", pojos.get(position).getFile());
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return pojos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id, year, file;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            year = itemView.findViewById(R.id.year);
            file = itemView.findViewById(R.id.file);

        }
    }
}
