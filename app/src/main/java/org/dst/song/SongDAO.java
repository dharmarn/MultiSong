package org.dst.song;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SongDAO
{

    @Insert
    Long insertTask(Song song);

    @Update
    Void updateTask(Song song);

    @Delete
    Void delete(Song song);


    @Query("select * from song order by songno asc")
    List<Song> getAll();



}
