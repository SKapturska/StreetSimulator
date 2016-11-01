package streetsimulator;

public class DecoratorBike extends DecoratorVehicle {

    Pedestrian pedestrian;
    /*

    public DecoratorBike() {
        locationX = 0;
        locationY = 0;
        speed = 2;
        sign = '%';
    }
*/
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

}
