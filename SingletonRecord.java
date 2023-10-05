import java.util.*;

public class SingletonRecord {
    private int num = 0;
    private int num2 = 0;
    private int num3 = 0;
    private Record[] batteryList = new Record[8];
    private int[] speedList = new int[8];
    private int[] backupBatteryList = new int[8];

    private static SingletonRecord instance = new SingletonRecord();

    private SingletonRecord(){}

    public static SingletonRecord getInstance(){
        return instance;
    }  

    public synchronized void recordBattery(Record battery){
        if(battery.status.equals("Almost Empty")){
            battery.status = "Short";
        }
        batteryList[num] = battery;
        num++;
    }

    public synchronized void recordSpeed(int speed){
        speedList[num2] = speed;
        num2++;
    }

    public synchronized void recordBackupBattery(int bb){
        backupBatteryList[num3] = bb;
        num3++;
    }

    public void blackBox(){
        System.out.println(" === Black Box Singleton Output ===");
        System.out.println("Number of Mode Calculation: "+num);
        System.out.println("Hybrid mode with both eletric motor and fuel engine\n");

        for(int i=0; i<batteryList.length; i++){
            System.out.println(i+1 + ": Battery: " + batteryList[i].status + "\t-- " + batteryList[i].carMode + " Mode -- Speed: " + speedList[i]);
        }

        System.out.println(" ==============");
        System.out.println(" Main Bat. Level\tBackup Bat.\tUsage Tracked by Mediator Singleton");

        for(int i=0; i<batteryList.length; i++){
            System.out.print(i+1 + ": " + batteryList[i].level + "\t\t Backup Battery ");
            
            if(backupBatteryList[i]==0){
                System.out.print("Not Used in " + batteryList[i].carMode + "\n");
            }
            else{
                System.out.print("Being Used --> BU Battery Level: " + backupBatteryList[i] + "\n");
            }
        }
        System.out.println(" ==============");

    }

}