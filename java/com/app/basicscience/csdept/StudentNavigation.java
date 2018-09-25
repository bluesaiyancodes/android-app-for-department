package com.app.basicscience.csdept;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class StudentNavigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_navigation);

        this.setTitle("Department of Computer Science");
        Toolbar toolbar = (Toolbar) findViewById(R.id.student_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.student_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.student_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displayselectedscreen(R.id.student_nav_home);
    }
    private static long back_pressed= System.currentTimeMillis();

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.student_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (back_pressed + 2000 > System.currentTimeMillis()) {
                //System.exit(1);
                super.onBackPressed();
            } else {
                Toast.makeText(getBaseContext(), "Press once again to exit", Toast.LENGTH_SHORT).show();
                back_pressed = System.currentTimeMillis();
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.student_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.student_action_settings) {
            new AlertDialog.Builder(this)
                    .setTitle("Warning")
                    .setMessage("Are you sure you want to Log Out?")
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {

                            Intent intent = new Intent(StudentNavigation.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }).create().show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayselectedscreen(int id){

        Fragment fragment=null;
        switch(id){
            case R.id.student_nav_home:
                fragment=new HomeStudent();
                break;
            case R.id.student_nav_sylb:
                fragment=new SyllabusStudent();
                break;
            case R.id.student_nav_attendance:
                fragment=new AttendanceStudent();
                break;
            case R.id.student_nav_timetable:
                fragment=new TimetableStudent();
                break;
            case R.id.nav_registration:
              //  Intent intent=new Intent(FacultyNavigation.this,signup.class);
              //  startActivity(intent);
                break;
            case R.id.student_nav_facinfo:
                fragment =new stud_facinfo();
                break;
        }
        if (fragment!=null){
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_left);
            fragmentTransaction.replace(R.id.content_student,fragment);
            fragmentTransaction.commit();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.student_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        displayselectedscreen(id);

        return true;
    }
}
