package streetsimulator;

public class Pedestrian extends StreetUser {

    public Pedestrian(int x, int y) {
        locationX = x;
        locationY = y;
        speed = 1;
        sign = '^';

    }

    @Override
    public int getLocationX() {
        return locationX;
    }

    @Override
    public int getLocationY() {
        return locationY;
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
        locationX = x;
    }

    @Override
    public void setLocationY(int y) {
        locationY = y;
    }

}
