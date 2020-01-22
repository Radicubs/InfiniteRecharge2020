package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Limelight extends Subsystem {

  double ledState;
  NetworkTable table;
  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry ta;
  double horizonatalOffset;
  double verticalOffset;
  double targetArea;

  public Limelight() {
    // Instantiate Network Table + Entries
    table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");

    // Horizontal Offset From Crosshair To Target (-27 degrees to 27 degrees)
    horizonatalOffset = tx.getDouble(0.0);

    // Vertical Offset From Crosshair To Target (-20.5 degrees to 20.5 degrees)
    verticalOffset = ty.getDouble(0.0);

    // Target Area (0% of image to 100% of image)
    targetArea = ta.getDouble(0.0);

    // Sets LED on at startup
    setLedOn();

  }

  public void setLedOn() {
    // 3.0 = LED ON
    ledState = 3.0;
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(ledState);
  }

  public void setLedOff() {
    // 1.0 = LED OFF
    ledState = 1.0;
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(ledState);
  }

  public void setLedBlink() {
    // 2.0 = LED BLINK
    ledState = 2.0;
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(ledState);
  }

  public double gethorizonatalOffset() {
    return this.horizonatalOffset;
  }

  public double getverticalOffset() {
    return this.horizonatalOffset;
  }

  public double getTargetArea() {
    return this.targetArea;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    // setDefaultCommand(new UpdateLimeLight()); }
  }

}