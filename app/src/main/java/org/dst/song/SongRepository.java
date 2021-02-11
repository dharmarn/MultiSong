package org.dst.song;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.room.Room;

import java.util.List;

public class SongRepository
{


    private String DB_NAME = "songdb";

    private SongDatabase songDatabase;
    Context context;

    public SongRepository(Context context)
    {
        this.context = context;
        songDatabase = Room.databaseBuilder(context, SongDatabase.class, DB_NAME).build();
//         Toast.makeText(context, "Database ready", Toast.LENGTH_LONG).show();
    }

    //Insert function start

    // Insert data into database in background only one at a time .
    public void InsertTask(final Song song)
    {

        new AsyncTask<Void, Void, Void>()
        {

            @Override
            protected Void doInBackground(Void... voids)
            {
                songDatabase.songDAO().insertTask(song);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                Toast.makeText(context, song.song_title + " Is Inserted Success full ", Toast.LENGTH_LONG).show();
            }
        }.execute();


    }

    //Insert Function End


    //******** Get data task start

    public List<Song> getSongs()
    {

        List<Song> songList = songDatabase.songDAO().getAll();

        return songList;

    }


//******** Get data task start



}
