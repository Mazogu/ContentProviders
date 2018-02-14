package com.example.micha.contentdata.main;

import com.example.micha.contentdata.BasePresenter;
import com.example.micha.contentdata.BaseView;
import com.example.micha.contentdata.model.Person;

/**
 * Created by micha on 2/12/2018.
 */

public interface MainContract {
    interface MPresenter extends BasePresenter<MView>{
        void addPerson(Person person);
    }

    interface MView extends BaseView{

    }
}
