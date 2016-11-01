package streetsimulator;

public class DecoratorCar extends DecoratorVehicle {
    
    Pedestrian pedestrian;
    
    /* public DecoratorCar() {
        locationX = 0;
        locationY = 0;
        speed = 5;
        sign = '$';
    }
     */

    DecoratorCar(Pedestrian pedestrian) {
        this.pedestrian = pedestrian;     
        speed = 5;
        sign = '$';
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
        return ""+sign;
    }

   @Override
    public void setLocationX(int x) {
        pedestrian.setLocationX(x);
    }

    @Override
    public void setLocationY(int y) {
        pedestrian.setLocationY(y);
    }
    

}
