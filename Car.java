import java.util.Random;

public class Car {
    Random random = new Random();
    String car_mode;
    
    public Car(String car_string){
        this.car_mode = car_string;
    }

    public void igniteEngine(){
        System.out.println(printMode() + "Fuel/gas Engine started.");
    }

    public void stopEngine(){
        System.out.println(printMode() + "Cut fuel to engine");
    }

    public void keepRunningEngine(){
        System.out.println("Fuel engine keeps running.");
        System.out.println("Electric Generator is charging battery.");

    }

    public void measureSpeed(){
        int randomNumber = random.nextInt(70 - 40 + 1) + 40;
        System.out.println("Current Speed: " + randomNumber);
        SingletonRecord singletonRecord = SingletonRecord.getInstance();
        singletonRecord.recordSpeed(randomNumber);
    }

    public String printMode(){
        return "(Now " + car_mode + " Mode) ";
    }

    public void regenerativeBraking(){
        System.out.println("Regenerative braking system runs to charge battery.");
    }
    
}
