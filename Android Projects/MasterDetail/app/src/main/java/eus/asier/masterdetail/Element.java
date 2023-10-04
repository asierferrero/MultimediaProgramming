package eus.asier.masterdetail;

public class Element {
    String name;
    String description;
    String mark;
    int image;

    public Element(int image, String name, String mark, String description) {
        this.name = name;
        this.description = description;
        this.mark = mark;
        this.image=image;
    }
    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}