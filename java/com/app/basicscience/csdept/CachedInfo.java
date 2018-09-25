package com.app.basicscience.csdept;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by bishalblue on 05/03/18.
 */

public class CachedInfo {
    static String studentname;
    static String rollnumber;
    static String facultyname;
    static String facultyemail;
    static String user;
    static String semester;

    static String att_sub1;
    static String att_sub2;
    static String att_sub3;
    static String att_sub4;
    static String att_sub5;
    static String att_sub6;
    static String att_sub7;
    static String att_skill1;
    static String att_sub8;
    static String att_sub9;
    static String att_sub10;
    static String att_skill2;
    static String att_sub11;
    static String att_sub12;
    static String att_dis1;
    static String att_dis2;
    static String att_sub13;
    static String att_sub14;
    static String att_dis3;

    private static final String LOGIN_URL="https://csdeptcbsh.000webhostapp.com/UserRegistration/getname.php";


    void setfaculty(String facemail){
        facultyemail=facemail;
        user="faculty";
        this.getname();
    }

    void setstudent( String roll){
        rollnumber=roll;
        user="student";
        this.getname();

    }


    String returnstudentname(){
        return studentname;
    }
    String returnfacultyname(){
        return facultyname;
    }
    String returnsemester(){
        return semester;
    }
    String returnstudentattsub1(){
        return att_sub1;
    }
    String returnstudentattsub2(){
        return att_sub2;
    }
    String returnstudentattsub3(){
        return att_sub3;
    }
    String returnstudentattsub4(){
        return att_sub4;
    }
    String returnstudentattsub5(){
        return att_sub5;
    }
    String returnstudentattsub6(){
        return att_sub6;
    }
    String returnstudentattsub7(){
        return att_sub7;
    }
    String returnstudentattskill1(){
        return att_skill1;
    }
    String returnstudentattsub8(){
        return att_sub8;
    }
    String returnstudentattsub9(){
        return att_sub9;
    }
    String returnstudentattsub10(){
        return att_sub10;
    }
    String returnstudentattskill2(){
        return att_skill2;
    }
    String returnstudentattsub11(){
        return att_sub11;
    }
    String returnstudentattsub12(){
        return att_sub12;
    }
    String returnstudentattdis1(){
        return att_dis1;
    }
    String returnstudentattdis2(){
        return att_dis2;
    }
    String returnstudentattsub13(){
        return att_sub13;
    }
    String returnstudentattsub14(){
        return att_sub14;
    }
    String returnstudentattdis3(){
        return att_dis3;
    }








    private void getname() {
        if(user=="student"){

            String url_suffix="?roll=" + rollnumber + "&user=" + user;
            class LoginUser extends AsyncTask<String, Void, String> {

                String result;
                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    studentname=result;
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
        else if(user=="faculty"){
            String url_suffix="?email=" + facultyemail + "&user=" + user;
            class LoginUser extends AsyncTask<String, Void, String> {

                String result;
                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    facultyname=result;
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

    void setsemester(){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/UserRegistration/getsemester.php?roll=" + rollnumber;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                semester=result;
                setsubs();
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    private void setsubs(){
        switch(semester){
            case "1":
                setStudent_sub1("sub1");

                break;
            case "2":
                setStudent_sub3("sub3");

                break;
            case "3":
                setStudent_sub5("sub5");

                break;
            case "4":
                setStudent_sub8("sub8");

                break;
            case "5":
                setStudent_sub11("sub11");

                break;
            case "6":
                setStudent_sub13("sub13");

                break;
        }
    }

    void setStudent_sub1(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub1=result;
                setStudent_sub2("sub2");
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_sub2(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub2=result;
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_sub3(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub3=result;
                setStudent_sub4("sub4");
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }
    void setStudent_sub4(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub4=result;
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_sub5(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub5=result;
                setStudent_sub6("sub6");

            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_sub6(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub6=result;
                setStudent_sub7("sub7");

            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_sub7(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub7=result;
                setStudent_skill1("skill1");
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_skill1(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_skill1=result;
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_sub8(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub8=result;
                setStudent_sub9("sub9");

            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_sub9(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub9=result;
                setStudent_sub10("sub10");

            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_sub10(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub10=result;
                setStudent_skill2("skill2");
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_skill2(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_skill2=result;
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_sub11(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub11=result;
                setStudent_sub12("sub12");

            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_sub12(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub12=result;
                setStudent_dis1("dis1");

            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_dis1(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_dis1=result;
                setStudent_dis2("dis2");
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_dis2(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_dis2=result;
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_sub13(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub13=result;
                setStudent_sub14("sub14");

            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_sub14(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_sub14=result;
                setStudent_dis3("dis3");
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }

    void setStudent_dis3(String subject){

        String URL_SEMESTER="https://csdeptcbsh.000webhostapp.com/Attendance/studatt.php?roll=" + rollnumber + "&subject=" + subject + "&semester=" + semester;
        class LoginUser extends AsyncTask<String, Void, String> {

            String result;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                att_dis3=result;
            }
            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(s);
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
        loginUser.execute(URL_SEMESTER);
    }
}