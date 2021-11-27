package mb.ganesh.simpleshoppingapp;

import org.json.JSONArray;

public class MyProductModel {
    String title;
    int image;
    JSONArray array;

    public MyProductModel(String title, int image, JSONArray array) {
        this.title = title;
        this.image = image;
        this.array = array;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public JSONArray getArray() {
        return array;
    }

    public void setArray(JSONArray array) {
        this.array = array;
    }
}
