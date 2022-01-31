package swe.nilkhetjai.mobileapp.model;

import java.sql.Timestamp;

public class Post {
    private String imageBase64;
    private String audioBase64;
    private String price;
    private long id;
    private Timestamp timestamp;

    /**
     *
     * @param imageBase64
     * @param audioBase64
     * @param price
     */
    public Post(String imageBase64, String audioBase64, String price) {
        this.imageBase64 = imageBase64;
        this.audioBase64 = audioBase64;
        this.price = price;
    }

    /**
     *
     * @param imageBase64
     * @param audioBase64
     * @param price
     * @param id
     * @param timestamp
     */

    public Post(String imageBase64, String audioBase64, String price, long id, Timestamp timestamp) {
        this.imageBase64 = imageBase64;
        this.audioBase64 = audioBase64;
        this.price = price;
        this.id = id;
        this.timestamp = timestamp;
    }

    /**
     *
     * @return
     */

    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */

    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     *
     * @return
     */

    public String getImageBase64() {
        return imageBase64;
    }

    /**
     *
     * @param imageBase64
     */

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    /**
     *
     * @return
     */

    public String getAudioBase64() {
        return audioBase64;
    }

    public void setAudioBase64(String audioBase64) {
        this.audioBase64 = audioBase64;
    }

    /**
     *
     * @return
     */

    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */

    public void setPrice(String price) {
        this.price = price;
    }
}
