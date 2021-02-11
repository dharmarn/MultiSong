package org.dst.song;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity
{

    EditText  edt_song_t, edt_song_l, edt_tempo,edt_beat,edt_lan;

    Button btn_submit;

    String  stitle, sl, stempo, sbeat, slan;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        edt_song_t = (EditText) findViewById(R.id.edit_song_t);
        edt_song_l = (EditText) findViewById(R.id.edit_song_l);
        edt_tempo = (EditText) findViewById(R.id.edit_tempo);
        edt_beat = (EditText) findViewById(R.id.edit_beat);
        edt_lan = (EditText) findViewById(R.id.edit_lan);
        btn_submit =(Button) findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(edt_song_t.getText().toString().isEmpty() || edt_song_l.getText().toString().isEmpty()  || edt_lan.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please fill the details ",Toast.LENGTH_LONG).show();
                }
                else
                {
                    // Insert Data Roll No, Name, Contact Number , Gender .
                    stitle = edt_song_t.getText().toString().trim();
                    sl = edt_song_l.getText().toString().trim();
                    stempo = edt_tempo.getText().toString().trim();
                    sbeat = edt_beat.getText().toString().trim();
                    slan = edt_lan.getText().toString().trim();

                    SongRepository songRepository  = new SongRepository(getApplicationContext());
                    Song song = new Song(stitle,sl,stempo,sbeat,slan);
                    songRepository.InsertTask(song);

                    edt_song_t.setText("");
                    edt_song_l.setText("");
                    edt_tempo.setText("");
                    edt_beat.setText("");
                    edt_lan.setText("");

                }



            }
        });


    }
}