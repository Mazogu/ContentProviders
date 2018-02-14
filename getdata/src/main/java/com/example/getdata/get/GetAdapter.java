package com.example.getdata.get;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.getdata.R;
import com.example.getdata.model.Person;

import java.util.List;

/**
 * Created by micha on 2/13/2018.
 */

public class GetAdapter extends RecyclerView.Adapter<GetAdapter.PersonHolder> {

    public static final String TAG = GetAdapter.class.getSimpleName();
    List<Person> people;

    public GetAdapter(List<Person> list){
        people = list;
    }

    @Override
    public PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_recieved_layout, parent, false);
        return new PersonHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonHolder holder, int position) {
        holder.name.setText(people.get(position).getName());
        holder.middle.setText(people.get(position).getMiddle());
        holder.phone.setText(people.get(position).getPhone());
        holder.email.setText(people.get(position).getEmail());
        holder.company.setText(people.get(position).getCompany());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public class PersonHolder extends RecyclerView.ViewHolder{
        private final TextView name,middle,phone,email,company;
        public PersonHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.fullname);
            middle = itemView.findViewById(R.id.middlename);
            phone = itemView.findViewById(R.id.phoneNo);
            email = itemView.findViewById(R.id.emailaddress);
            company = itemView.findViewById(R.id.companyName);
        }
    }
}
