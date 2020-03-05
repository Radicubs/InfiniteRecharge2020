package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.commands.AutomatedBallIndex;

public class ColorSensor extends Subsystem {

  I2C.Port i2cPort = I2C.Port.kOnboard;
  ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);

  private final ColorMatch colorMatcher = new ColorMatch();
  private final Color yellowTarget = ColorMatch.makeColor(0.330, 0.5417, 0.330); //Needs Calibration
  Color detectedColor;
  ColorMatchResult match;

  double redAmount, greenAmount, blueAmount;

  public ColorSensor() {
    i2cPort = I2C.Port.kOnboard;
    colorSensor = new ColorSensorV3(i2cPort);
    colorMatcher.addColorMatch(yellowTarget);
  }

  
  public boolean foundBall() {
     detectedColor = colorSensor.getColor();
     return Math.abs(detectedColor.red - yellowTarget.red) < .05 && Math.abs(detectedColor.green - yellowTarget.green) < .05 && Math.abs(detectedColor.blue - yellowTarget.blue) < .05 ;
  }

  @Override
  public void initDefaultCommand() {
      setDefaultCommand(new AutomatedBallIndex());
  }

}
