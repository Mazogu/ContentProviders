package com.example.getdata.get;

import com.example.getdata.BasePresenter;
import com.example.getdata.BaseView;
import com.example.getdata.model.Person;

import java.util.List;

/**
 * Created by micha on 2/13/2018.
 */

public interface GetContract {
    public interface GView extends BaseView{

    }

    public interface GPresenter extends BasePresenter<GView>{
        public List<Person> getPeople();
    }
}
