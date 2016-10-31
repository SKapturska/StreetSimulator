package streetsimulator;

abstract public class StreetUser {
    
    int locationX;
    int locationY;
    int speed;
    char sign;

    public abstract int getLocationX();

    public abstract int getLocationY();

    public abstract int getSpeed();

    public abstract char getSign();
    
    public abstract void setLocationX(int x);

    public abstract void setLocationY(int y);
    
    @Override
    public abstract String toString();

}
