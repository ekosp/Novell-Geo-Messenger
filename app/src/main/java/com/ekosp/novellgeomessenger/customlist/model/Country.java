package com.ekosp.novellgeomessenger.customlist.model;

/**
 * Created by eko.purnomo on 01/02/2017.
 * You can contact me at : ekosetyopurnomo@gmail.com
 * or for more detail at  : http://ekosp.com
 */

public class Country {

    private String name, capital, currency;
    private int flag;

    public Country() {
    }

    public Country(String name, int flag, String capital, String currency) {
        this.name = name;
        this.flag = flag;
        this.capital = capital;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}