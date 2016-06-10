package com.magomed.gamzatov.universalmarket.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.magomed.gamzatov.universalmarket.R;

import java.util.Timer;
import java.util.TimerTask;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initFab();
        initListViewCategory();
    }

    @Override
    protected void onStart(){
        super.onStart();

        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(fab!=null){
                    fab.show();
                }
            }
        }, 300);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("Категории");
        }
        setSupportActionBar(toolbar);
    }

    private void initFab() {
        fab = (FloatingActionButton) findViewById(R.id.fab);

        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
            });
        }
    }

    private void initListViewCategory() {
        ListView listViewCategory = (ListView) findViewById(R.id.listViewCategory);
        String[] list = {"Все", "Шорты", "Футболки", "Джинсы"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        if (listViewCategory != null) {
            listViewCategory.setAdapter(arrayAdapter);
            listViewCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(fab!=null){
                        fab.hide();
                    }
                    Intent intent = new Intent(MainActivity.this, ItemsList.class);
                    startActivity(intent);
                    overridePendingTransition(R.animator.push_down_in, R.animator.push_down_out);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
