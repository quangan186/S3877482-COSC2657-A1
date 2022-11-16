package cosc2657.a1.unicheck.model;

import java.io.Serializable;

public class ImageNote implements Serializable {
    private int image;
    private String note;

    public ImageNote(int image, String note) {
        this.image = image;
        this.note = note;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
