package entity;


public class Flight {
    private int id;
    private Req req;
    private Car car;
    private boolean mark;

    public Flight(Req req) {
        this.req = req;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Req getReq() {
        return req;
    }

    public void setReq(Req req) {
        this.req = req;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    public Flight(int id,Req req, Car car, boolean mark) {
        this.id = id;
        this.req = req;
        this.car = car;
        this.mark = mark;
    }

    public Flight(int id) {
        this.id = id;
    }

    public Flight(int id,boolean mark){
        this.id = id;
        this.mark = mark;
    }

    public Flight() {
    }
}
