package com;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Pojo_Parts;
import com.example.constiutionofindia.R;

import java.util.ArrayList;

public class Parts_Adapter extends RecyclerView.Adapter<Parts_Adapter.ViewHolder> {

    Context context;
    ArrayList<Pojo_Parts> pojos;
    private OnClickAdapter listener;

    public Parts_Adapter(Context context, ArrayList<Pojo_Parts> pojos, OnClickAdapter listener) {
        this.context = context;
        this.pojos = pojos;
        this.listener = listener;
    }
    private int selectedPosition = -1; // To keep track of the selected position

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.singlerow_parts, parent, false);
        return new ViewHolder(view1);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.partno.setText("" + pojos.get(position).getTitle());

        if (position == selectedPosition) {
            holder.imageView2.setVisibility(View.VISIBLE);

        } else {
            holder.imageView2.setVisibility(View.GONE);
        }


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                if (listener != null) {

                    selectedPosition = position;
                    notifyDataSetChanged();

                    listener.onPartItemClick(pojos.get(position).getId(), pojos.get(position).getSmallDescription());
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return pojos.size();
    }

    public interface OnPartItemClickListener {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView partno;
        ImageView imageView, imageView2;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            partno = itemView.findViewById(R.id.partno);
            imageView = itemView.findViewById(R.id.circle);
            cardView = itemView.findViewById(R.id.cardView);
            imageView2 = itemView.findViewById(R.id.circle2);
        }

    }

    public interface OnPartItemClick {
        void onPartItemClick(Pojo_Parts part);
    }

}
