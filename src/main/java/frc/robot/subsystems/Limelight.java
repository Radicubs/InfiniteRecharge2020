package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.UpdateLimelight;

public class Limelight extends Subsystem {

  double ledState;
  double cameraState;
  NetworkTable table;
  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry ta;
  NetworkTableEntry ts;
  double horizonatalOffset;
  double verticalOffset;
  double targetArea;
  double skewAmount;
  boolean limeLightConnected;

  public Limelight() {
    // Instantiate Network Table + Entries
    table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    ts = table.getEntry("ts");

    // Check Limelight Connection
    checkConnection();

    // Horizontal Offset From Crosshair To Target (-27 degrees to 27 degrees)
    horizonatalOffset = tx.getDouble(0.0);

    // Vertical Offset From Crosshair To Target (-20.5 degrees to 20.5 degrees)
    verticalOffset = ty.getDouble(0.0);

    // Target Area (0% of image to 100% of image)
    targetArea = ta.getDouble(0.0);

    // Sets LED on at startup
    setLedOn();

    // Vision Mode on startup
    visionMode();

  }

  // Used to Check Connection w/Limelight - We can output this to SmartDashboard once we start working on that
  private void checkConnection() {

    if (table.getKeys().size() < 20) {
      // Usually it has 25 keys, it will have 0 if the Limelight hasn't been connected
      // If a key has been set before checking this, the size will not be zero
      limeLightConnected = false;
      System.out.println("Limelight failed to Connect");
    } else {
      if (!limeLightConnected)
        System.out.println("Limelight Connected");
      limeLightConnected = true;
    }
  }

  public void setLedOn() {
    // 3.0 = LED ON
    checkConnection();
    ledState = 3.0;
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(ledState);
  }

  public void setLedOff() {
    // 1.0 = LED OFF
    checkConnection();
    ledState = 1.0;
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(ledState);
  }

  public void setLedBlink() {
    // 2.0 = LED BLINK
    checkConnection();
    ledState = 2.0;
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(ledState);
  }

  public void visionMode() {
    // 0.0 = Set Limelight to do vision processing
    checkConnection();
    cameraState = 0.0;
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(cameraState);
  }

  public void driverMode() {
    // 1.0 = Set Limelight to regular camera mode; usable for the driver
    checkConnection();
    cameraState = 1.0;
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(cameraState);
  }

  public double gethorizonatalOffset() {
    checkConnection();
    return this.horizonatalOffset;
  }

  public double getverticalOffset() {
    checkConnection();
    return this.horizonatalOffset;
  }

  public double getTargetArea() {
    checkConnection();
    return this.targetArea;
  }

  public double getSkew() {
    checkConnection();
    return this.skewAmount;
  }

  @Override
  public void initDefaultCommand() {
    // Default command for limelight subsystem here.

    setDefaultCommand(new UpdateLimelight());
  }
}