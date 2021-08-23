package fiek.unipr.stayfit;


import android.graphics.drawable.Drawable;

public class Workouts {

    String name;
    String descripton;


    int imageUrl;
    int bigimageurl;

    public Workouts(String name, String descripton, int imageUrl, int bigimageurl) {
        this.name = name;
        this.descripton = descripton;
        this.imageUrl = imageUrl;
        this.bigimageurl = bigimageurl;
    }

    public int getBigimageurl() {
        return bigimageurl;
    }

    public void setBigimageurl(int bigimageurl) {
        this.bigimageurl = bigimageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
