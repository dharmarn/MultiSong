package org.dst.song;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity
{
    Button btn_log,btn_insert, btn_all;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        btn_insert = (Button)findViewById(R.id.buttonEng1);
        btn_all = (Button)findViewById(R.id.dbuttonAll);



        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Dashboard.this, InsertActivity.class);
                startActivity(i);

            }
        });

        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Dashboard.this, ViewallActivity.class);
                startActivity(i);

            }
        });


    }

    public void logOut(View view)
    {
         btn_log =(Button)findViewById(R.id.btn_logout);
//        Logout = (Button) findViewById(R.id.buttonLogout);

        Intent in = getIntent();
        String string = in.getStringExtra("message");
        btn_log.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
                builder.setTitle("Confirmation PopUp!").
                        setMessage("You sure, that you want to logout?");
                builder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(getApplicationContext(),
                                        MainActivity.class);
                                startActivity(i);
                            }
                        });
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        });


    }


}