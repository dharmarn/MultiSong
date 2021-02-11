package org.dst.song;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Song.class}, version = 1, exportSchema = false)
public abstract class SongDatabase extends RoomDatabase
{

    public abstract SongDAO songDAO();

}
