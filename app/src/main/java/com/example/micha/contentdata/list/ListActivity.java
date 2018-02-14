package com.example.micha.contentdata.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.micha.contentdata.R;
import com.example.micha.contentdata.model.Person;

import java.util.List;

public class ListActivity extends AppCompatActivity implements ListContract.LView {

    public static final String TAG = ListActivity.class.getSimpleName();
    ListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recycle = findViewById(R.id.recycler);
        presenter = new ListPresenter();
        presenter.attachView(this);
        List<Person> people = presenter.getPeople();
        ListAdapter adapter = new ListAdapter(people);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(manager);
    }

    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
