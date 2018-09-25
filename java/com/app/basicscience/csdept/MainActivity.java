package com.app.basicscience.csdept;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_faculty;
    Button btn_student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        btn_faculty=(Button)findViewById(R.id.faculty_sign);
        btn_student=(Button)findViewById(R.id.student_sign);

        btn_faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,signin_faculty.class);
                startActivity(intent);
                finish();
            }
        });

        btn_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,signin_student.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
