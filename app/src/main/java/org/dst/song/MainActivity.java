package org.dst.song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button  btn_all;


    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_all = (Button)findViewById(R.id.buttonAll);




        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, ViewallActivity.class);
                startActivity(i);

            }
        });



    }

    public void moveToLogin(View view)
    {
        startActivity(new Intent(getApplicationContext(),Login.class));

    }
}