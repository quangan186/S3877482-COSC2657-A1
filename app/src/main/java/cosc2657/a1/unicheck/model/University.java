package cosc2657.a1.unicheck.model;

import java.io.Serializable;

public class University implements Serializable {
    private int id;
    private String name;
    private String title;
    private int logo;
    private String address;
    private double tuitionFee;
    private String description;
    private String link;

    public University(int id, String name, String title, int logo, String address, double tuitionFee, String description, String link) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.logo = logo;
        this.address = address;
        this.tuitionFee = tuitionFee;
        this.description = description;
        this.link = link;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", logo='" + logo + '\'' +
                ", address='" + address + '\'' +
                ", tuitionFee=" + tuitionFee +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
