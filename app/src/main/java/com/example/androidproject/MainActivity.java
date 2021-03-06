package com.example.androidproject;


import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Adapter.CourseAdapter;
import Calendar.*;
import Entity.CourseView;
import Layout.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener/*,NewCalendar.NewCalendarListener*/{

    private ImageButton teacher;
    private ImageButton course;
    private ImageButton account;
    private ImageButton search;
    private TextView text_teacher;
    private TextView text_course;
    private TextView text_account;
    /*private List<CourseView> courseViewList=new ArrayList<>();*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();

        }
        init();


        /*initCourseInfo();
        CourseAdapter adapter=new CourseAdapter(MainActivity.this,R.layout.course_item,courseViewList);
        ListView listView=(ListView)findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CourseView courseView=courseViewList.get(i);
                Toast.makeText(MainActivity.this,courseView.getName(),Toast.LENGTH_SHORT).show();
            }
        });
*/
      /*  NewCalendar calendar =  findViewById(R.id.newCalendar);
        calendar.listener = this;*/


    }
    /*public void onItemLongPress(Date day) {
        DateFormat df = SimpleDateFormat.getDateInstance();
        Toast.makeText(this,df.format(day),Toast.LENGTH_SHORT).show();
    }*/

  /*  private void initCourseInfo(){
        for(int i=0;i<10;i++){
            CourseView courseView1=new CourseView(R.drawable.apple_pic,"马立新",48,96,"安卓开发",99);
            courseViewList.add(courseView1);
        }
    }*/

    private void init() {
        text_teacher = findViewById(R.id.text_teacher);
        text_course = findViewById(R.id.text_course);
        text_account = findViewById(R.id.text_account);
        course = (ImageButton) findViewById(R.id.course);
        course.setOnClickListener(this);
        teacher = (ImageButton)findViewById(R.id.teacher);
        teacher.setOnClickListener(this);
        account = (ImageButton) findViewById(R.id.account);
        account.setOnClickListener(this);
        search = (ImageButton)findViewById(R.id.search);
        search.setOnClickListener(this);
        replaceFragment(new ContentTeacherLayout());
        replaceTitle(new TitleLayout());
       teacher.setImageDrawable(getResources().getDrawable(R.drawable.ic_supervisor_account_orange2_a700_24dp));
       text_teacher.setTextColor(Color.parseColor("#EE7700"));
    }
   /* public void changeFragmentTeacher(){
        replaceFragment(new ContentTeacherLayout());
    }
    public void changeFragmentCourse(){
        replaceFragment(new ContentCourseLayout());
    }
    public void changeFragmentAccount(){
        replaceFragment(new ContentAccountLayout());
    }*/

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content,fragment);
        transaction.commit();
        /*getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .commit();*/

    }
    public void replaceTitle(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.title,fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.teacher :
                Log.d("woaini","teacher");
                replaceFragment(new ContentTeacherLayout());
                replaceTitle(new TitleLayout());

                teacher.setImageDrawable(getResources().getDrawable(R.drawable.ic_supervisor_account_orange2_a700_24dp));
                course.setImageDrawable(getResources().getDrawable(R.drawable.ic_book1_grey_500_24dp));
                account.setImageDrawable(getResources().getDrawable(R.drawable.ic_perm_identity1_grey_500_24dp));
                text_teacher.setTextColor(Color.parseColor("#EE7700"));
                text_course.setTextColor(Color.parseColor("#888888"));
                text_account.setTextColor(Color.parseColor("#888888"));
                break;
            case R.id.course:
                Log.d("woaini","course");
                replaceFragment(new ContentCourseLayout());
                replaceTitle(new TitleCourseLayout());
                teacher.setImageDrawable(getResources().getDrawable(R.drawable.ic_supervisor_account1_grey_500_24dp));
                course.setImageDrawable(getResources().getDrawable(R.drawable.ic_book2_orange_a700_24dp));
                account.setImageDrawable(getResources().getDrawable(R.drawable.ic_perm_identity1_grey_500_24dp));
                text_teacher.setTextColor(Color.parseColor("#888888"));
                text_course.setTextColor(Color.parseColor("#EE7700"));
                text_account.setTextColor(Color.parseColor("#888888"));
                break;
            case R.id.account:
                Log.d("woaini","account");
                replaceFragment(new ContentAccountLayout());
                replaceTitle(new TitleAccountLayout());
                teacher.setImageDrawable(getResources().getDrawable(R.drawable.ic_supervisor_account1_grey_500_24dp));
                course.setImageDrawable(getResources().getDrawable(R.drawable.ic_book1_grey_500_24dp));
                account.setImageDrawable(getResources().getDrawable(R.drawable.ic_perm_identity2_orange_a700_24dp));
                text_teacher.setTextColor(Color.parseColor("#888888"));
                text_course.setTextColor(Color.parseColor("#888888"));
                text_account.setTextColor(Color.parseColor("#EE7700"));
                break;
            case R.id.search:
                Toast toast = Toast.makeText(MainActivity.this, "This is search Button", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                break;
            default:break;
        }

    }
}
