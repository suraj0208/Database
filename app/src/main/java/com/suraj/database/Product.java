package com.suraj.database;

/**
 * Created by suraj on 22/7/15.
 */
public class Product {
    private int _id;
    private String _productname;
    private String _number;


    public Product() {

    }

    public Product(String _productname, String number) {
        this._productname = _productname;
        this._number=number;
    }

    public int get_id() {
        return _id;
    }

    public String get_productname() {
        return _productname;
    }

    public String get_number() {
        return _number;
    }

    public void set_productname(String _productname) {
        this._productname = _productname;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
