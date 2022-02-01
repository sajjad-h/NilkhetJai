package swe.nilkhetjai.mobileapp.model;

import java.util.ArrayList;
import java.util.List;

public class GetAllPostResponse {
    private String message;
    private String status;
    private ArrayList<Post>data;

    /**
     * GetAllPostResponse object
     * @param message
     * @param status
     * @param data
     */

    public GetAllPostResponse(String message, String status, ArrayList<Post> data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    /**
     * To get message
     * @return
     */

    public String getMessage() {
        return message;
    }

    /**
     * To set message
     * @param message
     */

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * To get status
     *
     * @return
     */

    public String getStatus() {
        return status;
    }

    /**
     * To set status
     * @param status
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */

    public ArrayList<Post> getData() {
        return data;
    }

    /**
     * 
     * @param data
     */

    public void setData(ArrayList<Post> data) {
        this.data = data;
    }
}
