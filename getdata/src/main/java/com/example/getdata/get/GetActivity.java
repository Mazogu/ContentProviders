package com.example.getdata.get;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.getdata.R;
import com.example.getdata.model.Person;

import java.util.List;

public class GetActivity extends AppCompatActivity implements GetContract.GView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        GetPresenter presenter = new GetPresenter();
        presenter.attachView(this);
        List<Person> people = presenter.getPeople();
        GetAdapter adapter = new GetAdapter(people);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
