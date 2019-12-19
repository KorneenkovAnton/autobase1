package entity;


public class Req {
    private int id;
    private Feature feature;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Req(int id, Feature feature) {
        this.id = id;
        this.feature = feature;
    }

    public Req(Feature feature) {
        this.feature = feature;
    }
}
