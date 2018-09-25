package com.app.basicscience.csdept;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by bishalblue on 20/02/18.
 */

public class signin_faculty extends AppCompatActivity {

    EditText editemail;
    EditText editpassword;
    Button btn_signin;
    private static final String LOGIN_URL="https://csdeptcbsh.000webhostapp.com/UserRegistration/signin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_faculty);
        this.setTitle("Department of Computer Science");

        editemail=findViewById(R.id.email_signin);
        editpassword=findViewById(R.id.password_signin);
        btn_signin=findViewById(R.id.btn_signin);

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


    }

    private void login() {
        String email=editemail.getText().toString().trim().toLowerCase();
        String password=editpassword.getText().toString().trim();

        CachedInfo cachedInfo=new CachedInfo();
        cachedInfo.setfaculty(email);

        logintodb(email,password);
    }

    private void logintodb(String email, String password) {
        String url_suffix="?email=" + email + "&password=" + password;
        class LoginUser extends AsyncTask<String, Void, String> {

            ProgressDialog loading;
            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(signin_faculty.this, "Checking Credentials","Just a sec!", true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
                if(result.equalsIgnoreCase("login success")){
                    final ProgressDialog dialog = new ProgressDialog(signin_faculty.this);
                    dialog.setTitle("Awaiting Confirmation");
                    dialog.setMessage("Indexing");
                    dialog.setIndeterminate(true);
                    dialog.setCancelable(false);
                    dialog.show();
                    long delayInMillis = 500;
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                        }
                    }, delayInMillis);
                    Intent intent = new Intent(signin_faculty.this, FacultyNavigation.class);
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
                    // String result;
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
