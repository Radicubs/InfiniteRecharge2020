package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;

public class ColorSensor extends Subsystem {

  I2C.Port i2cPort = I2C.Port.kOnboard;
  ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch colorMatcher = new ColorMatch();
  private final Color yellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113); //Needs Calibration
  Color detectedColor = colorSensor.getColor();
  ColorMatchResult match;

  double redAmount, greenAmount, blueAmount;

  public ColorSensor() {
    i2cPort = I2C.Port.kOnboard;
    colorSensor = new ColorSensorV3(i2cPort);
  }

  public Color getColor() {
    return colorSensor.getColor();
  }
  
  public boolean foundBall() {
     match = colorMatcher.matchClosestColor(detectedColor);
     return match.color == yellowTarget;
  }

  @Override
  public void initDefaultCommand() {
    // Default command for limelight subsystem here.

    // setDefaultCommand(new UpdateLimelight());
  }
}
