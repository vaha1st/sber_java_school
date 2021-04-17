package course.Reflection.example0;

class Car {
    private int horsepower;
    public final String serialNumber="Test";

    public Car() {

    }

    public Car(int horsepower) {
        this.horsepower = horsepower;

    }

    public int getHorsepower() {
        return horsepower;
    }

    private void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void printSerialNumber() {
        System.out.println(serialNumber);
    }
}
