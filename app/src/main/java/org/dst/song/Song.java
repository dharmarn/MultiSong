package org.dst.song;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Song
{
    @PrimaryKey(autoGenerate = true)
    public int songno;

    @ColumnInfo(name ="song_title")
    public String song_title;

    @ColumnInfo (name = "songd")
    public String songd;

    @ColumnInfo(name = "tempo")
    public String tempo;

    @ColumnInfo(name = "beat")
    public String beat;

    @ColumnInfo(name = "language")
    public String language;


    public Song(String song_title, String songd, String tempo, String beat, String language )
    {

        this.song_title = song_title;
        this.songd = songd;
        this.tempo = tempo;
        this.beat = beat;
        this.language = language;
    }

    public int getSongno() {
        return songno;
    }

    public void setSongno(int songno) {
        this.songno = songno;
    }

    public String getSong_title() {
        return song_title;
    }

    public void setSong_title(String song_title)
    {
        this.song_title = song_title;
    }

    public String getSongd()
    {
        return songd;
    }

    public void setSongd(String songd)
    {
        this.songd = songd;
    }

    public String getTempo()
    {
        return tempo;
    }

    public void setTempo(String tempo)
    {
        this.tempo = tempo;
    }

    public String getBeat()
    {
        return beat;
    }

    public void setBeat(String beat)
    {
        this.beat = beat;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }
}
