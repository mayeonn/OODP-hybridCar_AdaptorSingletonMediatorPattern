public class ElectricVehicle extends Car implements HybridInterface{
    public ElectricVehicle(String car_mode) {
        super(car_mode);
    }

    @Override
    public void startMotor(String previousCarMode){}

    @Override
    public void stopMotor(){
        stopEngine();
    }

    @Override
    public void electricToFrontMotor(){
        System.out.println("Supply electricity to front and rear motors of electric car");
    }

    @Override
    public void generateElectricPower(){}

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
