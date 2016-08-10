package com.marsair.automate.core;

import com.marsair.automate.utils.GetItem;

/**
 * Created by Ganga Hawa on 09-08-2016.
 */
public class Manager {

    private static Manager manager;
    private CRDriver crDriver;
    private FormSubmit formSubmit;
    private GetItem proItem;


    public static Manager getManager() {
        if (manager == null){
            manager = new Manager();
        }
        return manager;
    }

    public CRDriver getCrDriver() {

        if (crDriver == null){
            crDriver = new CRDriver();
        }
        return crDriver;
    }

    public FormSubmit getFormSubmit() {
        if (formSubmit==null){
            formSubmit = new  FormSubmit(this);
        }
        return formSubmit;
    }

    public GetItem getProItem() {
        if (proItem==null){
            proItem = new GetItem();
        }

        return proItem;
    }

    public void kill(){
        if (crDriver !=null){
            crDriver.dismiss();
        }
    }
}
