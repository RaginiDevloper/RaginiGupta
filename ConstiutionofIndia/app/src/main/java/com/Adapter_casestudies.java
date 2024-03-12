package com;

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

import com.example.constiutionofindia.R;

import java.util.ArrayList;

public class Adapter_casestudies extends RecyclerView.Adapter<Adapter_casestudies.ViewHolder> {

    Context context;

    ArrayList<Pojo_CaseStudy> pojos;

    public Adapter_casestudies(Context context, ArrayList<Pojo_CaseStudy> pojos) {
        this.context = context;
        this.pojos = pojos;
    }

    @NonNull
    @Override
    public Adapter_casestudies.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view1 = LayoutInflater.from(context).inflate(R.layout.singlerow_casestudy, parent, false);
        Adapter_casestudies.ViewHolder viewHolder = new Adapter_casestudies.ViewHolder(view1);


        return viewHolder;



    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_casestudies.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText("" + pojos.get(position).getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Information_Case_Studies.class);
                intent.putExtra("title", pojos.get(position).getTitle());
                intent.putExtra("description", pojos.get(position).getSmallDescription());
                view.getContext().startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return pojos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


        textView =itemView.findViewById(R.id.titlecase);
        cardView =itemView.findViewById(R.id.card);

    }
    }
}
