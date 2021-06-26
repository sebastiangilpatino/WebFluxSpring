package Fluxy.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Chat {

    private String message;

    public Chat(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
