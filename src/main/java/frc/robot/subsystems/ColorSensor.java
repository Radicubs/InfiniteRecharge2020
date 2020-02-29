package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;

public class ColorSensor extends Subsystem {

  // States of Limelight
  Color rawColor;
  I2C.Port i2cPort = I2C.Port.kOnboard;
  ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);

  double redAmount, greenAmount, blueAmount;

  public ColorSensor() {
    i2cPort = I2C.Port.kOnboard;
    colorSensor = new ColorSensorV3(i2cPort);
  }

  public Color getColor() {
    return colorSensor.getColor();
  }
  /*
  public double[] getRGB() {
    rawColor = getColor();
    System.out.println(rawColor.red);
    System.out.println(rawColor.green);
    System.out.println(rawColor.blue);
    double maxValue = rawColor.red + rawColor.blue + rawColor.green;
    System.out.println(rawColor.red / maxValue);
    System.out.println(rawColor.green / maxValue);
    System.out.println(rawColor.blue / maxValue);
    return (new double[] {0.1, 0.1});
  } */

  public double getRed() {
    return getColor().red;
  }

  public double getGreen() {
    return getColor().green;
  }

  public double getBlue() {
    return getColor().blue;
  }

  @Override
  public void initDefaultCommand() {
    // Default command for limelight subsystem here.

    // setDefaultCommand(new UpdateLimelight());
  }
}
