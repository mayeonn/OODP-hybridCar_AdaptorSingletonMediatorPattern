import java.util.Random;

public class MainBattery {
    SingletonRecord singleton = SingletonRecord.getInstance();
    Record battery;

    Random random = new Random();
    private int previousLevel = 100;
    private int level;
    private String status;
    private String carMode;
    
    public void generateRandomNumber(){
        level = random.nextInt(100)+1;
    }

    public String getMainBatteryStatus(){
        return status;
    }
    public String getCarMode(){
        return carMode;
    }

    public void determineMainBattery(){
        previousLevel = level;
        generateRandomNumber();

        if(level<25){
            if(previousLevel<25){
                System.out.println("\n* Battery Still Almost Empty * Main Battery Level: " + level);
            }
            else{
                System.out.println("\n* Battery Almost Empty * Main Battery Level: " + level);
            }
            status = "Almost Empty";
            carMode = "fuel";

            battery = new Record(level, status, carMode);
            singleton.recordBattery(battery);

            return;
        }
        else if(level<50){
            status = "Low";
            carMode = "fuel";
        }
        else if(level<75){
            status = "Medium";
            carMode = "hybrid";
        }
        else{
            status = "Full";
            carMode = "electric";
        }
        System.out.println("\n* " + status + " Battery Level *");

        battery = new Record(level, status, carMode);
        singleton.recordBattery(battery);

    }
    
}
