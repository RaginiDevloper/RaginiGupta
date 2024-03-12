package com;

import android.annotation.SuppressLint;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.constiutionofindia.R;

import java.util.ArrayList;
import java.util.Locale;

public class Preamble_Adapter extends RecyclerView.Adapter<Preamble_Adapter.ViewHolder> {

    Context context;
    ArrayList<Pojo_Preamble> pojos;

    public Preamble_Adapter(Context context, ArrayList<Pojo_Preamble> pojos) {
        this.context = context;
        this.pojos = pojos;
    }

    @NonNull
    @Override
    public Preamble_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.singlerow_preamble, parent, false);
        return new ViewHolder(view1);
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull Preamble_Adapter.ViewHolder holder, int position) {

        Glide.with(context).load(pojos.get(position).getImage())
                .placeholder(R.drawable.ic_launcher_background).into(holder.imageView);

        holder.title.setText("" + pojos.get(position).getTitle());
        holder.description.setText("" + pojos.get(position).getDescription());

        holder.textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    // If there is no error, set language
                    holder.textToSpeech.setLanguage(Locale.UK);
                } else {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titleToSpeak = holder.title.getText().toString().trim();
                String descriptionToSpeak = holder.description.getText().toString().trim();

                if (!titleToSpeak.isEmpty()) {
                    holder.textToSpeech.speak(titleToSpeak, TextToSpeech.QUEUE_FLUSH, null, null);
                }
                if (!descriptionToSpeak.isEmpty()) {
                    holder.textToSpeech.speak(descriptionToSpeak, TextToSpeech.QUEUE_FLUSH, null, null);
                }

                // Use the context to get resources and set the background color
                resetButtonColors(holder);
                holder.playbutton.setBackgroundColor(context.getResources().getColor(android.R.color.black));
            }
        });

        holder.stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.textToSpeech.isSpeaking()) {
                    holder.textToSpeech.stop();
                }
                resetButtonColors(holder);
                holder.stopbutton.setBackgroundColor(context.getResources().getColor(android.R.color.black));
            }
        });

        holder.pausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.textToSpeech.isSpeaking()) {
                    holder.textToSpeech.stop();
                }
                resetButtonColors(holder);
                holder.pausebutton.setBackgroundColor(context.getResources().getColor(android.R.color.black));
            }
        });
    }

    private void resetButtonColors(ViewHolder holder) {
        holder.playbutton.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
        holder.stopbutton.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
        holder.pausebutton.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
    }

    @Override
    public int getItemCount() {
        return pojos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, description;
        ImageView imageView, playbutton, stopbutton, pausebutton;
        ImageButton blackplay, blackpause, blackstop;

        TextToSpeech textToSpeech;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.Title);
            description = itemView.findViewById(R.id.Description);
            imageView = itemView.findViewById(R.id.Preimg);
            playbutton = itemView.findViewById(R.id.Playbutton);
            stopbutton = itemView.findViewById(R.id.Stopbutton);
            pausebutton = itemView.findViewById(R.id.Pausebutton);
         //   blackplay = itemView.findViewById(R.id.blackplay);
          //  blackpause = itemView.findViewById(R.id.blackpause);
           // blackstop = itemView.findViewById(R.id.blackstop);
        }
    }
}
