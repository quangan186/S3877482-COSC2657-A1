package cosc2657.a1.unicheck.model;

import java.io.Serializable;

public class University implements Serializable {
    private int id;
    private int introImage;
    private String name;
    private String title;
    private int logo;
    private String address;
    private double tuitionFee;
    private String description;
    private String link;
    private ImageNote[] imageNotes;

    public University(int id, int introImage, String name, String title, int logo, String address, double tuitionFee, String description, String link, ImageNote[] imageNotes) {
        this.id = id;
        this.introImage = introImage;
        this.name = name;
        this.title = title;
        this.logo = logo;
        this.address = address;
        this.tuitionFee = tuitionFee;
        this.description = description;
        this.link = link;
        this.imageNotes = imageNotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntroImage() {
        return introImage;
    }

    public void setIntroImage(int introImage) {
        this.introImage = introImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ImageNote[] getImageNotes() {
        return imageNotes;
    }

    public void setImageNotes(ImageNote[] imageNotes) {
        this.imageNotes = imageNotes;
    }
}
