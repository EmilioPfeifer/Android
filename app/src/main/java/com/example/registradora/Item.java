package com.example.registradora;

public class Item {
    private int mImagen;
    private String mText;
    private String mText2;

    public Item(int imagen, String text1, String text2){
        mImagen = imagen;
        mText = text1;
        mText2 = text2;

    }

    public int getmImagen() {
        return mImagen;
    }

    public String getmText() {
        return mText;
    }

    public String getmText2() {
        return mText2;
    }
}
