package entity;


public class Car {
    private int id;
    private CarState carState;
    private User user;
    private Feature feature;

    public Car(Feature feature, User user) {
        this.feature = feature;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarState getCarState() {
        return carState;
    }

    public void setCarState(CarState carState) {
        this.carState = carState;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Car(int id, CarState carState, User user, Feature feature) {
        this.id = id;
        this.carState = carState;
        this.user = user;
        this.feature = feature;
    }

    public Car(int id, Feature feature, User user) {
        this.id = id;
        this.feature = feature;
        this.user = user;
    }

    public Car(int id) {
        this.id = id;
    }

    public Car() {
    }
}
