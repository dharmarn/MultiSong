package org.dst.song;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
 import java.util.Random;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyviewHolder>
{
    private ArrayList<Song> dataset;

    Context context;


    // ******************* My View Holder starts

    public static class MyviewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_songno;
        TextView tv_song_title;
        TextView tv_songd;
        TextView tv_song_tempo;
        TextView tv_song_beat;
        TextView tv_song_leng;

        LinearLayout ll_card_song;




        public MyviewHolder(View itemView)
        {
            super(itemView);
            this.tv_songno = (TextView)itemView.findViewById(R.id.tv_songno);
            this.tv_song_title = (TextView)itemView.findViewById(R.id.tv_song_title);
            this.ll_card_song=(LinearLayout)itemView.findViewById(R.id.ll_card_song);

        }

    }
    // ******************* My View Holder Ends



    public CustomAdapter(ArrayList<Song> dataset, Context context)
    {
        this.dataset = dataset;

        this.context = context;

    }


    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_song,parent,false);

        MyviewHolder myViewHolder = new MyviewHolder(view);

        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position)
    {


        TextView tv_songno = holder.tv_songno;
        TextView tv_song_title = holder.tv_song_title;

        LinearLayout ll_card_song=holder.ll_card_song;

        // ********* fields form Song class
        tv_songno.setText(dataset.get(position).songno+"");
        tv_song_title.setText(dataset.get(position).song_title+"");


        ll_card_song.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int song_no = dataset.get(position).songno;
                String song_title = dataset.get(position).song_title;
                String songd = dataset.get(position).songd;
                String beat = dataset.get(position).beat;
                String tempo = dataset.get(position).tempo;
                String language = dataset.get(position).language;


//                Toast.makeText(context,song_no+"\n"+song_title+"\n"+songd+"\n"+beat+"\n"+language,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context,EngsongActivity.class);
                intent.putExtra("song_no",song_no);
                intent.putExtra("song_title",song_title);
                intent.putExtra("songd",songd);
                intent.putExtra("tempo",tempo);
                intent.putExtra("beat",beat);
                intent.putExtra("language",language);
                context.startActivity(intent);



            }
        });


    }

    @Override
    public int getItemCount()
    {
        return dataset.size();
    }


}
