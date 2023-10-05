public interface HybridInterface {
    void startMotor(String previousCarMode);
    void stopMotor();
    void electricToFrontMotor();
    void generateElectricPower();
    void stopMoving();
    void speedoMeter();
    void printCarMode();
}
