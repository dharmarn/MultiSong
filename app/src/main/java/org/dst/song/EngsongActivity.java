package org.dst.song;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EngsongActivity extends AppCompatActivity
{
    TextView tv_songno,tv_song_title,tv_songd,tv_tempo,tv_beat;

    int song_no;
    String song_title="";
    String songd="";
    String tempo="";
    String beat="";



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engsong);

        //============================= Find view by ids

         tv_songno = (TextView)findViewById(R.id.tv_songno);
        tv_song_title = (TextView)findViewById(R.id.tv_song_title);
        tv_tempo = (TextView)findViewById(R.id.tv_tempo);
        tv_beat = (TextView)findViewById(R.id.tv_beat);
        tv_songd = (TextView)findViewById(R.id.tv_song);

        //===============================

      //=================================== Getting values from Custom adapter starts ==================

         Bundle data = getIntent().getExtras();

         if (data!=null)
         {
             song_no = data.getInt("song_no");
             song_title = data.getString("song_title");
             songd = data.getString("songd");
             tempo = data.getString("tempo");
             beat = data.getString("beat");
         }

      //=================================== Getting values from Custom adapter starts ===================


        //==================================== Set Values to UI starts =====================================


          tv_songno.setText(song_no+"");
         tv_song_title.setText(song_title+"");
           tv_beat.setText("Beat : " +beat+"");
           tv_tempo.setText("Tempo : "+tempo+"");
           tv_songd.setText(songd+"");


        //==================================== Set Values to UI starts =====================================

    }

}