package com.example.micha.contentdata.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.micha.contentdata.R;
import com.example.micha.contentdata.list.ListActivity;
import com.example.micha.contentdata.model.Person;

public class MainActivity extends AppCompatActivity implements MainContract.MView {

    private EditText name, mname,phone,email,company;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter();
        presenter.attachView(this);

        name = findViewById(R.id.firstName);
        mname = findViewById(R.id.lastName);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        company = findViewById(R.id.company);
    }

    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    public void addPerson(View view) {
        String name = this.name.getText().toString();
        String middle = mname.getText().toString();
        String pPhone = phone.getText().toString();
        String pEmail = email.getText().toString();
        String pCompany = company.getText().toString();
        presenter.addPerson(new Person(name, middle, pPhone, pEmail, pCompany));

    }

    public void goToList(View view) {
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(intent);
    }
}
