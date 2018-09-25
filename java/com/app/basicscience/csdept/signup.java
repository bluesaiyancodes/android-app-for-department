package com.app.basicscience.csdept;

import android.app.ProgressDialog;
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

public class signup extends AppCompatActivity {
    EditText edit_roll;
    EditText edit_semester;
    EditText edit_name;
    EditText edit_password;
    EditText edit_phone;
    EditText edit_email;
    EditText edit_address;
    EditText edit_father;
    EditText edit_mother;
    EditText edit_parentphone;
    Button btn_sign;
    private static final String REGISTER_URL="https://csdeptcbsh.000webhostapp.com/UserRegistration/signup.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_st);
        this.setTitle("Department of Computer Science");
        edit_roll=findViewById(R.id.reg_roll);
        edit_semester=findViewById(R.id.reg_semester);
        edit_name=findViewById(R.id.reg_name);
        edit_password=findViewById(R.id.reg_password);
        edit_phone=findViewById(R.id.reg_phone);
        edit_email=findViewById(R.id.reg_email);
        edit_address=findViewById(R.id.reg_address);
        edit_father=findViewById(R.id.reg_father);
        edit_mother=findViewById(R.id.reg_mother);
        edit_parentphone=findViewById(R.id.reg_parentphone);
        btn_sign=findViewById(R.id.btn_register);

        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String roll=edit_roll.getText().toString().trim().toUpperCase();
        String semester=edit_semester.getText().toString().trim();
        String name=edit_name.getText().toString().trim().toUpperCase();
        String password=edit_password.getText().toString().trim();
        String email=edit_email.getText().toString().trim().toLowerCase();
        String phone=edit_phone.getText().toString().trim();
        String address=edit_address.getText().toString().trim().toLowerCase();
        String father=edit_father.getText().toString().trim().toUpperCase();
        String mother=edit_mother.getText().toString().trim().toUpperCase();
        String parentphone=edit_parentphone.getText().toString().trim();

        register(roll,semester,name,password,phone,email,address,father,mother,parentphone);
    }

    private void register(String roll,String semester,String name,String password,String phone,String email,String address,String father,String mother,String parentphone){
        String urlSuffix = "?roll=" + roll + "&semester=" + semester + "&name=" + name + "&password=" + password + "&phone=" + phone + "&email=" + email + "&address=" + address + "&father=" + father + "&mother=" + mother + "&parentphone=" + parentphone;
         class RegisterUser extends AsyncTask<String, Void, String> {

             ProgressDialog loading;
             String result;
             @Override
             protected void onPreExecute() {
                 super.onPreExecute();
                 loading = ProgressDialog.show(signup.this, "Please Wait", null, true, true);
             }

             @Override
             protected void onPostExecute(String s) {
                 super.onPostExecute(s);
                 loading.dismiss();
                 Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
             }
             @Override
             protected String doInBackground(String... strings) {
                 String s = strings[0];
                 BufferedReader bufferReader=null;
                 try {
                     URL url=new URL(REGISTER_URL+s);
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
         RegisterUser registerUser=new RegisterUser();
         registerUser.execute(urlSuffix);
    }

}
