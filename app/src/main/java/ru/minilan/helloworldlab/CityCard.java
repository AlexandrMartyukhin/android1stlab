package ru.minilan.helloworldlab;


public class CityCard {

    private final int citypic;
    private final String city;

    public CityCard(String city,int citypic) {
        this.city = city;
        this.citypic = citypic;
    }

    public int getCityPic() {
        return citypic;
    }

    public String getCity() {
        return city;
    }
}
