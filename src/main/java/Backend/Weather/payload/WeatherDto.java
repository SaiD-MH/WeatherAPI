package Backend.Weather.payload;

import java.util.List;

public class WeatherDto {

    private String description;
    private String resolvedAddress;
    private String address;
    private String timezone;
    private List<Days> days;

    public List<Days> getDays() {
        return days;
    }

    public void setDays(List<Days> days) {
        this.days = days;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolvedAddress() {
        return resolvedAddress;
    }

    public void setResolvedAddress(String resolvedAddress) {
        this.resolvedAddress = resolvedAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public static class Days {

        private String datetime;
        private double tempmax;
        private double tempmin;

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public double getTempmax() {
            return tempmax;
        }

        public void setTempmax(double tempmax) {
            this.tempmax = tempmax;
        }

        public double getTempmin() {
            return tempmin;
        }

        public void setTempmin(double tempmin) {
            this.tempmin = tempmin;
        }
    }
}


