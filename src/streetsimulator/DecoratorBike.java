package streetsimulator;

public class DecoratorBike extends DecoratorVehicle {

    Pedestrian pedestrian;

    DecoratorBike(Pedestrian pedestrian){
        this.pedestrian = pedestrian;
        speed = 2;
        sign = '%';
    }

    @Override
    public int getLocationX() {
        return pedestrian.getLocationX();
    }

    @Override
    public int getLocationY() {
        return pedestrian.getLocationY();
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public char getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return "" + sign;
    }

    @Override
    public void setLocationX(int x) {
        pedestrian.setLocationX(x);
    }

    @Override
    public void setLocationY(int y) {
        pedestrian.setLocationX(y);
    }

    @Override
    public Pedestrian getOff() {
        return pedestrian;
    }

}
