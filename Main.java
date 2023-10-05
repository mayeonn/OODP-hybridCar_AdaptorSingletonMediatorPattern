public class Main {
    public static void main(String[] args) {
      MainBattery mainBattery = new MainBattery();
      String currentBatteryStatus = "";
      String previousCarMode = "";
      String currentCarMode = "";

      HybridInterface vehicle;
      Mediator mediator = new Mediator();
      SingletonRecord singleton = SingletonRecord.getInstance();

      try {

          for(int i=0; i<8; i++){
            // Set battery status and car mode
            mainBattery.determineMainBattery();
            currentBatteryStatus = mainBattery.getMainBatteryStatus();
            previousCarMode = currentCarMode;
            currentCarMode = mainBattery.getCarMode();

            // Almost Empty : Backup battery
            if(currentBatteryStatus.equals("Almost Empty")){
              mediator.setUsingBackUpBattery();
            }
            else{
              mediator.OffUsingBackUpBattery();
              mediator.setNotUsingBackUpBattery();
            }

            // Print car mode
            if(previousCarMode.isEmpty()){
              System.out.println("Starts with the " + currentCarMode + " car mode.");
            }
            else if(previousCarMode==currentCarMode){
              System.out.println("Keep " + currentCarMode + " car mode.");
            }
            else{
              System.out.println("Convert from " + previousCarMode + " to " + currentCarMode + " car mode.");
            }

            switch(currentBatteryStatus){
              case("Almost Empty"):
                vehicle= new HybridCar(currentCarMode);
                vehicle.startMotor(previousCarMode);
                vehicle.generateElectricPower();
                vehicle.speedoMeter();
                break;

              case("Low"):
                vehicle= new HybridCar(currentCarMode);
                vehicle.startMotor(previousCarMode);
                vehicle.generateElectricPower();
                vehicle.speedoMeter();
                break;

              case("Medium"):
                vehicle= new HybridCar(currentCarMode); 
                vehicle.startMotor(previousCarMode);
                vehicle.electricToFrontMotor();
                vehicle.generateElectricPower();
                vehicle.stopMoving();
                vehicle.speedoMeter();
                break; 

              case("Full"):
                vehicle = new ElectricVehicle(currentCarMode);
                vehicle.stopMotor();
                vehicle.electricToFrontMotor();
                vehicle.stopMoving();
                vehicle.speedoMeter();
                break;
            }
        }
        singleton.blackBox();
      } 
      catch (Exception e) {
        System.out.println("Error: " + e); 
      }
    }

}
