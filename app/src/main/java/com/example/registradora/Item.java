package com.example.registradora;

public class Item {
    private int mImagen;
    private int mPrecio;
    private String mDetalle;
    private int mIndex;

    public Item(int imagen, int precio, String detalle, int index){
        mImagen = imagen;
        mPrecio = precio;
        mDetalle = detalle;
        mIndex = index;

    }

    public int getmImagen() {
        return mImagen;
    }

    public int getmPrecio() {
        return mPrecio;
    }

    public String getmDetalle() {
        return mDetalle;
    }

    public int removeItem(){
        return mIndex;
    }
}
