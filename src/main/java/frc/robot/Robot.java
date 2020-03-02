/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.autonomous.*;
import frc.robot.subsystems.*;

/**
 * The VM is configuRobotd to automatically run this class, and to call the functions corresponding
 * to each mode, as described in the TimedRobot documentation. If you change the name of this class
 * or the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String leftAuto = "Left Auto";
  private static final String rightAuto = "Right Auto";
  private static final String middleAuto = "Middle Auto";

  // Autonomous Declarations
  private String autoSelected;
  private SendableChooser<String> autoChooser = new SendableChooser<>();
  Command rightAutoCommand;
  Command leftAutoCommand;
  Command middleAutoCommand;


  // Declare subsystems
  public static DriveBase driveBase;
  public static Limelight limeLight;
  public static ColorSensor colorSensor;
  public static Index index;
  public static Intake intake;
  public static Shooter shooter;
  public static Elevator elevator;
  public static OI oi;

  @Override
  public void robotInit() {
    autoChooser.addOption("Right Auto", rightAuto);
    autoChooser.addOption("Middle Auto", middleAuto);
    autoChooser.addOption("Left Auto", leftAuto);

    SmartDashboard.putData("Auto choices", autoChooser);

    // Initialize subsystems
    limeLight = new Limelight();
    colorSensor = new ColorSensor();
    driveBase = new DriveBase();
    index = new Index();
    intake = new Intake();
    shooter = new Shooter();
    elevator = new Elevator();
    rightAutoCommand = new RightAuto();
    middleAutoCommand = new MiddleAuto();
    leftAutoCommand = new LeftAuto();
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
    autoSelected = (String) autoChooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (autoSelected) {
      case leftAuto:
        leftAutoCommand.start();
        break;
      case rightAuto:
        rightAutoCommand.start();
      case middleAuto:
        middleAutoCommand.start();
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
