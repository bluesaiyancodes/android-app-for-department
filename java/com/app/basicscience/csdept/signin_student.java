package com.app.basicscience.csdept;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class signin_student extends AppCompatActivity {
    EditText editpassword;
    EditText editroll;
    Button btn_signin;
    private static final String LOGIN_URL="https://csdeptcbsh.000webhostapp.com/UserRegistration/signin_student.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_student);
        this.setTitle("Department of Computer Science");

        editpassword=findViewById(R.id.student_password_signin);
        btn_signin=findViewById(R.id.student_btn_signin);
        editroll=findViewById(R.id.student_roll);

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    private void login() {
        String password=editpassword.getText().toString().trim();
        String roll=editroll.getText().toString().trim().toUpperCase();

        CachedInfo cachedInfo =new CachedInfo();
        cachedInfo.setstudent(roll);
        cachedInfo.setsemester();

        logintodb(roll,password);
    }
    private void logintodb(String roll, String password) {
        String url_suffix="?roll=" + roll + "&password=" + password;
        class LoginUser extends AsyncTask<String, Void, String> {

            ProgressDialog loading;
            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(signin_student.this, "Checking Credentials","Just a sec!", true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
                if(result.equalsIgnoreCase("login success")){

                    Intent intent = new Intent(signin_student.this, StudentNavigation.class);
                    startActivity(intent);
                    finish();
                }
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(LOGIN_URL+s);
                    HttpURLConnection con=(HttpURLConnection)url.openConnection();
                    bufferReader=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    result=bufferReader.readLine();
                    return  result;

                }catch (Exception e){
                    return null;
                }

            }
        }
        LoginUser loginUser=new LoginUser();
        loginUser.execute(url_suffix);


    }
}
