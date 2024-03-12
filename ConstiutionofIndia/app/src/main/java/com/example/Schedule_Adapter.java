package com.example;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.Information_ScheduleActivity;
import com.Pojo_Preamble;
import com.Pojo_Schedule;
import com.Preamble_Adapter;
import com.example.constiutionofindia.R;

import java.util.ArrayList;

public class Schedule_Adapter extends RecyclerView.Adapter<Schedule_Adapter.ViewHolder> {

    Context context;

    ArrayList<Pojo_Schedule> pojos;

    public Schedule_Adapter(Context context, ArrayList<Pojo_Schedule> pojos) {
        this.context = context;
        this.pojos = pojos;
    }

    @NonNull
    @Override
    public Schedule_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view1 = LayoutInflater.from(context).inflate(R.layout.singlerow_schedule, parent, false);
        Schedule_Adapter.ViewHolder viewHolder = new ViewHolder(view1);


        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull Schedule_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.idname.setText("" + pojos.get(position).getTitle());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(), Information_ScheduleActivity.class);
                intent.putExtra("title",  pojos.get(position).getTitle());
                intent.putExtra("description",  pojos.get(position).getSmallDescription());
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return  pojos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView idname;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idname = itemView.findViewById(R.id.idname);
            cardView = itemView.findViewById(R.id.card);

        }
    }
}
