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

public class Article_Adapter extends RecyclerView.Adapter<Article_Adapter.ViewHolder> {

    Context context;

    ArrayList<Pojo_Article> pojos;

    public Article_Adapter(Context context, ArrayList<Pojo_Article> pojos) {
        this.context = context;
        this.pojos = pojos;
    }

    @NonNull
    @Override
    public Article_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view1 = LayoutInflater.from(context).inflate(R.layout.singlerow_article, parent, false);
        Article_Adapter.ViewHolder viewHolder = new Article_Adapter.ViewHolder(view1);


        return viewHolder;


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Article_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.title.setText("" + pojos.get(position).getTitle());
        holder.smalldesvription.setText("" + pojos.get(position).getSmallDescription());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), Information_ArticleActivity.class);
                intent.putExtra("title",  pojos.get(position).getTitle());
                intent.putExtra("description",  pojos.get(position).getDescription());
                intent.putExtra("partId", pojos.get(position).getPartId());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  pojos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title , smalldesvription;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            smalldesvription = itemView.findViewById(R.id.smallDescription);
            cardView = itemView.findViewById(R.id.card);


        }
    }
}
