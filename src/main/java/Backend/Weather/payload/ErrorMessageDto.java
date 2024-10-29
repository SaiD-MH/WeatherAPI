package Backend.Weather.payload;

import java.util.Date;

public class ErrorMessageDto {


    private String message;
    private Date timestamp;

    private String errorDetails;

    public ErrorMessageDto() {
    }

    public ErrorMessageDto(String message, Date timestamp, String errorDetails) {
        this.message = message;
        this.timestamp = timestamp;
        this.errorDetails = errorDetails;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

}
