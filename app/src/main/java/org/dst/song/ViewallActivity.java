package org.dst.song;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.text.TextWatcher;
import android.util.Log;
import android.text.Editable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ViewallActivity extends AppCompatActivity
{

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    ArrayList<Song> songArrayList,songArrayList_search;

    CustomAdapter customAdapter;
    EditText edt_search;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall);

        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        edt_search =(EditText)findViewById(R.id.edt_search);

        edt_search.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                String text =s.toString();
                Filter(text);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        new LoadDataTask().execute();
    }

    class LoadDataTask extends AsyncTask<Void,Void,Void>
    {

        SongRepository studentRepository;
        List<Song> studentList;

        @Override
        protected void onPreExecute()

        {
            super.onPreExecute();
            studentRepository = new SongRepository(getApplicationContext());
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            studentList = studentRepository.getSongs();
            songArrayList = new ArrayList<>();

            songArrayList_search = new ArrayList<>();

            for(int i=0; i<studentList.size(); i++)
            {

                songArrayList.add(studentList.get(i));
                songArrayList_search.add(studentList.get(i));

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);

            customAdapter = new CustomAdapter(songArrayList,ViewallActivity.this);
            recyclerView.setAdapter(customAdapter);


        }
    }


    //************************** Filter Logic By Name Start **********************//


    public void Filter(String charText)
    {

        charText =charText.toLowerCase(Locale.getDefault());
        Log.d("filter",charText+"");

        songArrayList.clear();

        if(charText.length()==0)
        {
            songArrayList.addAll(songArrayList_search);
            Log.d("Load Data","All");
        }
        else
        {
            Log.d("Load","Filtered");
            for(Song song:songArrayList_search)
            {
                // for Interger to lower case conversion automatic type casting  (Clase Object.field name + "") (student.rollno+"").toLowerCase()
                 // 1 ) String.copyValueOf(song.songno) normal way
                if(song.song_title.toLowerCase(Locale.getDefault()).contains(charText) || (song.songno+"").toLowerCase(Locale.getDefault()).contains(charText))
                {
                    songArrayList.add(song);
                }

            }

        }

        customAdapter.notifyDataSetChanged();

    }

    //************************** Filter Logic By Name End **********************//







}