package eus.asier.masterdetail;

public class Element {
    String name;
    String description;
    float rating;
    int image;

    public Element(int image, String name, String description) {
        this.name = name;
        this.description = description;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public int getImage() {
        return image;
    }
}