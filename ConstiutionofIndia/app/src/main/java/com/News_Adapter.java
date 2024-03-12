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

import com.example.Schedule_Adapter;
import com.example.constiutionofindia.R;

import java.util.ArrayList;

public class News_Adapter extends RecyclerView.Adapter<News_Adapter.ViewHolder> {

    Context context;

    ArrayList<Pojo_NewsArticles> pojos;

    public News_Adapter(Context context, ArrayList<Pojo_NewsArticles> pojos) {
        this.context = context;
        this.pojos = pojos;
    }

    @NonNull
    @Override
    public News_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view1 = LayoutInflater.from(context).inflate(R.layout.singlerow_newsaraticles, parent, false);
        News_Adapter.ViewHolder viewHolder = new News_Adapter.ViewHolder(view1);


        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull News_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.title.setText("" + pojos.get(position).getTitle());
        holder.date.setText("" + pojos.get(position).getDate()); // Corrected line

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Information_NewActivity.class);
                intent.putExtra("date", pojos.get(position).getDate());
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

        TextView title, date;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            cardView = itemView.findViewById(R.id.card);


        }
    }
}

