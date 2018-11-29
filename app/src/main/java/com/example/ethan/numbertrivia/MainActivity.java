package com.example.ethan.numbertrivia;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView numberTextView;
    private TextView factTextView;
    private int random;
    private FactAdapter factAdapter;
    private List<NumberFactItem> numberFacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberTextView = findViewById(R.id.randomNumberTextView);
        factTextView = findViewById(R.id.randomFactTextView);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        numberFacts = new ArrayList<>();
        factAdapter = new FactAdapter(this, numberFacts);
        recyclerView.setAdapter(factAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                random = new Random().nextInt(101);
                requestData();
            }
        });
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


    private void requestData()
    {
        Service.NumbersApiService service = Service.NumbersApiService.retrofit.create(Service.NumbersApiService.class);
        /**
         * Make an a-synchronous call by enqueing and definition of callbacks.
         */
        Call<NumberFactItem> call = service.getNumberFact(random);

        call.enqueue(new Callback<NumberFactItem>() {
            @Override
            public void onResponse(Call<NumberFactItem> call, Response<NumberFactItem> response) {
                NumberFactItem numberFactItem = response.body();
                if(numberFactItem != null) {
                    numberFacts.add(numberFactItem);
                    factAdapter.notifyItemInserted(numberFacts.size() - 1);
                }
            }

            @Override
            public void onFailure(Call<NumberFactItem> call, Throwable t) {
                Log.d("error",t.toString());
            }
        });
    }
}