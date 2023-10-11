package eus.asier.masterdetail;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Element {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String description;
    int image;
    float rating;

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