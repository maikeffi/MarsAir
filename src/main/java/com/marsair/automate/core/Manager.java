package com.marsair.automate.core;

import com.marsair.automate.utils.GetItem;

/**
 * Created by Kannan Maikeffi on 09-08-2016.
 */
public class Manager {

    private static Manager manager;
    private CRDriver crDriver;
    private FFDriver ffDriver;
    private FormSubmit formSubmit;
    private GetItem proItem;
    private FindLinks findLinks;


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

    public FFDriver getFfDriver() {

        if (ffDriver == null){
            ffDriver = new FFDriver();
        }
        return ffDriver;
    }

    public FormSubmit getFormSubmit() throws Exception {
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

    public FindLinks getFindLinks() throws Exception {
        if (findLinks==null){
            findLinks = new FindLinks(this);

        }

        return findLinks;
    }

    public void kill(){
        if (crDriver !=null){
            crDriver.dismiss();
        }
    }
}
