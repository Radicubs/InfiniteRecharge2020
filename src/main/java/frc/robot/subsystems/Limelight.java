package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.UpdateLimelight;

public class Limelight extends Subsystem {

  // States of Limelight
  double ledState;
  double cameraState;
  String ledStateWord;
  String cameraStateWord;
  double pipelineNumber;

  // Network Table
  NetworkTable table;

  // Network Table Entries
  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry ta;
  NetworkTableEntry ts;
  NetworkTableEntry ledMode;
  NetworkTableEntry pipeline;
  NetworkTableEntry camMode;

  // Values we can get from Limelight
  double horizonatalOffset;
  double verticalOffset;
  double targetArea;
  double skewAmount;

  double llAngle = 35; // angle of the limelight in degrees
  double targetHeight = 90.75 - 40.25; // height of the target in inches

  // Check Connection
  boolean limeLightConnected;

  // Instance of limelight
  private static Limelight limelightInstance;

  int debugVal = 0;

  public Limelight() {
    // Instantiate Network Table + Entries
    table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    ts = table.getEntry("ts");
    ledMode = table.getEntry("ledMode");
    pipeline = table.getEntry("pipeline");
    camMode = table.getEntry("camMode");

    // Check Limelight Connection
    checkConnection();
  }

  public static Limelight getInstance() {

    if (limelightInstance == null) {
      limelightInstance = new Limelight();
    }
    return limelightInstance;
  }

  public NetworkTable getTable() {
    return table;
  }

  public double calculateDistance() {
    double targetAngle = llAngle + ty.getDouble(0.0);
    targetAngle = Math.toRadians(targetAngle);
    double distance = targetHeight / Math.tan(targetAngle);
    return distance;
  }

  // Update Limelight values in UpdateLimelight.java
  public void setValues() {
    ledMode.setNumber(ledState);
    pipeline.setNumber(pipelineNumber);
    camMode.setNumber(cameraState);
  }

  public void readValues() {
    // Horizontal Offset From Crosshair To Target (-27 degrees to 27 degrees)
    horizonatalOffset = tx.getDouble(0.0);
    // Vertical Offset From Crosshair To Target (-20.5 degrees to 20.5 degrees)
    verticalOffset = ty.getDouble(0.0);
    // Target Area (0% of image to 100% of image)
    targetArea = ta.getDouble(0.0);
    // Sets LED on at startup
    ledState = ledMode.getDouble(3.0);
    ledStateWord = "ON";
    // Vision Mode on startup
    cameraState = camMode.getDouble(0.0);
    // Establish Pipeline
    pipelineNumber = pipeline.getDouble(0.0);
    // Display limelight Statistics on Smart Dashboard
    SmartDashboard.putNumber("Horizontal Offset", horizonatalOffset);
    SmartDashboard.putNumber("Vertical Offset", verticalOffset);
    SmartDashboard.putNumber("Target Area", targetArea);
    SmartDashboard.putNumber("Skew Amount", skewAmount);
    SmartDashboard.putString("LED State", ledStateWord);
    SmartDashboard.putNumber("Pipeline", pipelineNumber);
    SmartDashboard.putNumber("Distance", calculateDistance());
    // SmartDashboard.putString("Camera State", cameraStateWord);

    // System.out.println("Horizontal Offset: " + horizonatalOffset);

    // Display Connection
    if (checkConnection()) {
      SmartDashboard.putString("Connection", "Connected");
    } else {
      SmartDashboard.putString("Connection", "Not Connected");
    }

    // return tx;

    if (debugVal > 200) {
      // System.out.println("Horizontal Offset: " + horizonatalOffset);
      // System.out.println("Vertical Offset: " + verticalOffset);
      // System.out.println("Target Area: " + targetArea);
      // // System.out.println("Skew Area: " + skewAmount);
      // System.out.println("Distance: " + calculateDistance());
      // System.out.println("===========================");
      // System.out.println();
      debugVal = 0;
    }
    debugVal++;
  }

  // Used to Check Connection w/Limelight - This outputs to SmartDashboard
  // once we start working on that
  private boolean checkConnection() {

    if (table.getKeys().size() < 20) {
      // Usually it has 25 keys, it will have 0 if the Limelight hasn't been connected
      // If a key has been set before checking this, the size will not be zero
      limeLightConnected = false;
    } else {
      if (!limeLightConnected) limeLightConnected = true;
    }
    return limeLightConnected;
  }

  public void setLedOn() {
    // 3.0 = LED ON
    checkConnection();
    ledState = 3.0;
    ledStateWord = "ON";
  }

  public void setLedOff() {
    // 1.0 = LED OFF
    checkConnection();
    ledState = 1.0;
    ledStateWord = "OFF";
  }

  public void setLedBlink() {
    // 2.0 = LED BLINK
    checkConnection();
    ledState = 2.0;
    ledStateWord = "BLINK";
  }

  public void visionMode() {
    // 0.0 = Set Limelight to do vision processing
    checkConnection();
    cameraState = 0.0;
    cameraStateWord = "Vision Mode";
  }

  public void driverMode() {
    // 1.0 = Set Limelight to regular camera mode; usable for the driver
    checkConnection();
    cameraState = 1.0;
    cameraStateWord = "Driver Mode";
  }

  public double getHorizonatalOffset() {
    checkConnection();
    return this.horizonatalOffset;
  }

  public double getVerticalOffset() {
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
