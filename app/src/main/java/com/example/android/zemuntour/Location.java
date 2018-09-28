package com.example.android.zemuntour;

public class Location {
    private String lName;
    private String lAdress;
    private int lImageId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    private float lStarRate = NO_RATE_PROVIDED;
    private static final float NO_RATE_PROVIDED = -1;
    private float starRate;

    public Location(String name, String adress, int imageId) {
        lName = name;
        lAdress = adress;
        lImageId = imageId;
    }

    public Location(String name, String adress, int imageId, float rate) {
        lName = name;
        lAdress = adress;
        lImageId = imageId;
        starRate = rate;
    }

    public String getLocName() { return lName; }
    public String getLocAdress() { return lAdress; }
    public int getlImageId() { return lImageId; }
    public boolean hasImage() { return lImageId != NO_IMAGE_PROVIDED; }
    public float getStarRate() { return starRate; }
    public boolean hasRate() { return  lStarRate == NO_RATE_PROVIDED; }
}
