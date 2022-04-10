//++++++++++++++++++++++++++++++++++++++++++++++++
// Name: locationOBJ.java
// Function: used to store info from db table
// Programmer: Charles Lett Jr.
// Last Updated: 04/10/2022
// reference: https://stackoverflow.com/a/45425764
//++++++++++++++++++++++++++++++++++++++++++++++++

package com.example.kcfapp;

public class locationOBJ {
    private String name;
    private String address;
    private int provFood;
    private int provClothes;
    private int provShelter;
    private int provHealthCare;

    public locationOBJ (String name, String address, int provFood, int provClothes, int provShelter, int provHealthCare){
        this.name = name;
        this.address = address;
        this.provFood = provFood;
        this.provClothes = provClothes;
        this.provShelter = provShelter;
        this.provHealthCare = provHealthCare;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public int getProvFood(){
        return this.provFood;
    }

    public int getProvClothes(){
        return this.provClothes;
    }

    public int getProvShelter(){
        return this.provShelter;
    }

    public int getProvHealthcare(){
        return this.provHealthCare;
    }
}
