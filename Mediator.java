import java.util.ArrayList;
import java.util.Random;

public class Mediator {
    Random random = new Random();
    SingletonRecord singleton = SingletonRecord.getInstance();
    boolean useBackUpBattery = false;

    public int requestBackupBattery(){
        int randomNumber = random.nextInt(100 - 50 + 1) + 50;
        return randomNumber;
    }

    public void setUsingBackUpBattery(){
        int level = requestBackupBattery();
        if(useBackUpBattery){
            System.out.println("Continue to Backup Battery -- BU Battery Level: " + level);
        }
        else{
            System.out.println("Switching to Backup Battery -- BU Battery Level: " + level);
        }
        useBackUpBattery = true;

        recordBackupBattery(level);
    }

    public void setNotUsingBackUpBattery(){
        singleton.recordBackupBattery(0);
    }
    
    public void OffUsingBackUpBattery(){
        useBackUpBattery = false;
    }

    public Boolean UseOfBackUpBattery(){
        return useBackUpBattery;
    }

    public void recordBackupBattery(int level){
        int bb = 0;
        if(useBackUpBattery){
            bb = level;
        }
        singleton.recordBackupBattery(bb);
    }
}
