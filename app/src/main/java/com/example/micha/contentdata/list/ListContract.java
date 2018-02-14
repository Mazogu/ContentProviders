package com.example.micha.contentdata.list;

import com.example.micha.contentdata.BasePresenter;
import com.example.micha.contentdata.BaseView;
import com.example.micha.contentdata.model.Person;

import java.util.List;

/**
 * Created by micha on 2/13/2018.
 */

public interface ListContract {
    public interface LView extends BaseView{

    }

    public interface LPresenter extends BasePresenter<LView>{

        List<Person> getPeople();
    }
}
