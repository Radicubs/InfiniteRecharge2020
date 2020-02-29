/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorSensorV3;

import frc.robot.commands.Autonomous.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Limelight;

/**
 * The VM is configuRobotd to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String leftAuto = "Left Auto";
  private static final String rightAuto = "Right Auto";
  private static final String middleAuto = "Middle Auto";
  private static final String defaultAuto = "Default Auto";

  private Color detectedColor;
  private double redAmount, greenAmount, blueAmount;

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);

  private Command rightAutoCommand = new RightAuto();

  private String autoSelected;
  private SendableChooser<String> autoChooser = autoChooser = new SendableChooser<>();

  // Declare subsystems
  public static DriveBase driveBase;
  public static Limelight limeLight;
  public static OI oi;

  @Override
  public void robotInit() {
    autoChooser.setDefaultOption("Default Auto", defaultAuto);
    autoChooser.addOption("My Auto", rightAuto);
    SmartDashboard.putData("Auto choices", autoChooser);

    // Initialize subsystems
    limeLight = new Limelight();
    driveBase = new DriveBase();
    oi = new OI();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    detectedColor = colorSensor.getColor();
    redAmount = detectedColor.red;
    greenAmount = detectedColor.green;
    blueAmount = detectedColor.blue;

    System.out.println("RED" + redAmount);
    System.out.println("GREEN" + greenAmount);
    System.out.println("BLUE" + blueAmount);
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    autoSelected = (String)autoChooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (autoSelected) {
      case leftAuto:
        break;
      case rightAuto:
        rightAutoCommand.start();
      case middleAuto:
        break;
      case defaultAuto:
        break;
      default:
        break;
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
