package ru.minilan.helloworldlab;

public class WeatherCard {

    private final String tempMorning, tempDay, tempEvening, tempNight;
    private final String pressure;
    private final String humidity;
    private final String date;




    public WeatherCard(String tempMorning, String tempDay, String tempEvening, String tempNight,
                       String pressure, String humidity, String date) {
        this.tempMorning = tempMorning;
        this.tempDay = tempDay;
        this.tempEvening = tempEvening;
        this.tempNight = tempNight;
        this.pressure = pressure;
        this.humidity = humidity;
        this.date = date;
    }

    public String getTempMorning() {
        return tempMorning;
    }

    public String getTempEvening() {
        return tempEvening;
    }

    public String getTempDay() {
        return tempDay;
    }

    public String getTempNight() {
        return tempNight;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }
    public String getDate() {
        return date;
    }
}
