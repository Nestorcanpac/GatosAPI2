package com.example.gatosapi1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Gato {

    @PrimaryKey(autoGenerate = true)
    private String id_real;
    private String id,image;
    private int weight,height;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getId_real() {
        return id_real;
    }

    public void setId_real(String id_real) {
        this.id_real = id_real;
    }
}
