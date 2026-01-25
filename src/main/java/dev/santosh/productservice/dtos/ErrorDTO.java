package dev.santosh.productservice.dtos;

import java.time.Instant;

public class ErrorDTO {

    private final Instant timestamp;
    private final int status;
    private final String message;

    public ErrorDTO(Instant timestamp, int status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
