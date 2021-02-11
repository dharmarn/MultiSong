package org.dst.song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity
{

    EditText  edt_user_name, edt_pwd;

    Button btn_login;

    String username, pwd;





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            edt_user_name = (EditText)findViewById(R.id.et_usernmae);
               edt_pwd= (EditText)findViewById(R.id.et_pwd);
        btn_login= (Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(edt_user_name.getText().toString().isEmpty() || edt_pwd.getText().toString().isEmpty() )
                {
                    Toast.makeText(getApplicationContext(),"Please fill the details ",Toast.LENGTH_LONG).show();
                }
                else
                {
                    // Insert Data Roll No, Name, Contact Number , Gender .
//                    username = edt_user_name.getText().toString().trim();
//                    pwd = edt_pwd.getText().toString().trim();

                    if(edt_user_name.getText().toString().equals("admin") && edt_pwd.getText().toString().equals("admin123"))
                    {
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));

                    }
                    else if (edt_user_name.getText().toString().equals("dharmar") && edt_pwd.getText().toString().equals("dharmar123"))
                    {
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Please enter the correct details ",Toast.LENGTH_LONG).show();
                    }


//                    StudentRepository studentRepository = new StudentRepository(getApplicationContext());
//                    Student student = new Student(Integer.parseInt(sno),sname,sphone,sgender);
//                    studentRepository.InsertTask(student);
//
//                    edt_rollno.setText("");
//                    edt_studen_name.setText("");
//                    edt_contactno.setText("");
//                    edt_gender.setText("");

                }



            }
        });


    }

    public void moveToDashboard(View view)
    {
        startActivity(new Intent(getApplicationContext(),Dashboard.class));
    }
}