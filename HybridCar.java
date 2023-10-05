import javax.swing.JTable.PrintMode;

public class HybridCar extends Car implements HybridInterface{
    public HybridCar(String car_mode) {
        super(car_mode);
    }

    @Override
    public void startMotor(String previousCarMode){
        // when the previous car mode is electric 
        if(previousCarMode.equals("electric")){
            igniteEngine();
        }
    }

    @Override
    public void stopMotor(){}

    @Override
    public void electricToFrontMotor(){
        // only hybrid mode (not fuel mode)
        System.out.println("Supply electricity to front motor of hybrid car");
    }

    @Override
    public void generateElectricPower(){
        keepRunningEngine(); 
    }

    @Override
    public void stopMoving(){
        regenerativeBraking();
    }

    @Override
    public void speedoMeter(){
        System.out.print(printMode());
        measureSpeed();
    }

	@Override
	public void printCarMode() {
		System.out.print(printMode());
	}
}

