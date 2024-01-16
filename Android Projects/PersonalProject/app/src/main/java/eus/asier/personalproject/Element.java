package eus.asier.personalproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Element {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String description;
    int image;
    boolean isFavorite; // Added isFavorite field

    public Element(int image, String name, String description) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.isFavorite = false; // By default, it's not a favorite
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
