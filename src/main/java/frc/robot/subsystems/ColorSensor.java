package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.commands.defaultcommands.AutomatedBallIndex;

public class ColorSensor extends Subsystem {

  I2C.Port i2cPort = I2C.Port.kOnboard;
  ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);

  private final ColorMatch colorMatcher = new ColorMatch();
  private final Color yellowTarget =
      ColorMatch.makeColor(0.330, 0.5417, 0.108); // Needs Calibration
  Color detectedColor;
  ColorMatchResult match;
  private boolean intakeOn;

  double redAmount, greenAmount, blueAmount;
  boolean redTrue, greenTrue, blueTrue;

  public ColorSensor() {
    i2cPort = I2C.Port.kOnboard;
    colorSensor = new ColorSensorV3(i2cPort);
    colorMatcher.addColorMatch(yellowTarget);
  }

  public boolean foundBall() {
    detectedColor = colorSensor.getColor();
    redTrue = Math.abs(detectedColor.red - yellowTarget.red) < .07;
    greenTrue = Math.abs(detectedColor.green - yellowTarget.green) < .07;
    blueTrue = Math.abs(detectedColor.blue - yellowTarget.blue) < .07;
    //  System.out.println("Blue: " + detectedColor.blue + " Bool:" + blueTrue);
    //  System.out.println("Green: " + detectedColor.green + " Bool:" + greenTrue);
    //  System.out.println("Red: " + detectedColor.red + " Bool:" + redTrue);
    //  System.out.println("Boolean: " + intakeOn);
    //  System.out.println("=========================");
    return redTrue && greenTrue && blueTrue;
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new AutomatedBallIndex());
  }
}
