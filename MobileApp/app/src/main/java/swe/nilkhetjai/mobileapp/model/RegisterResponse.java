package swe.nilkhetjai.mobileapp.model;


public class RegisterResponse {
    private String status;
    private String error;
    private String message;

    /**
     *
     * @param status
     * @param error
     * @param message
     */
    public RegisterResponse(String status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    /**
     *
     * @return
     */

    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */

    public void setMessage(String message) {
        this.message = message;
    }
}