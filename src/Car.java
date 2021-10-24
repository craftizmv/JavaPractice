public class Car {
    public void sum(int a, int b) {
        System.out.println("Car");
    }

    public static void main(String[] args) {
        Car car = new Farrari();
        car.sum(1, 2);
    }
}

class Farrari extends Car {

    @Override
    public void sum(int a, int b) {
        System.out.println("Farrari");
    }

}


