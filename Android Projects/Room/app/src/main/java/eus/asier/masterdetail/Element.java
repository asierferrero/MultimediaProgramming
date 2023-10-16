package eus.asier.masterdetail;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Element {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String description;
    @ColumnInfo(name = "rating")
    float rating;
    int image;

    public Element(int image, String name, String description) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
}