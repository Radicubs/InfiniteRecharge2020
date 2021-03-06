/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
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
  private static final String shootingAuto = "Shooting Auto";
  private static final String initiationAuto = "Just Initiation Auto";

  // Autonomous Declarations
  private String autoSelected;
  private SendableChooser<String> autoChooser = new SendableChooser<>();
  Command autonomous;

  // Declare subsystems
  public static DriveBase driveBase;
  public static Limelight limeLight;
  public static ColorSensor colorSensor;
  public static Index index;
  public static Intake intake;
  public static Shooter shooter;
  public static Elevator elevator;
  public static Winch winch;
  public static OI oi;

  @Override
  public void robotInit() {
    autoChooser.setDefaultOption("Shooting Auto", shootingAuto);
    autoChooser.addOption("Initiation Auto", initiationAuto);
    SmartDashboard.putData("Auto choices", autoChooser);
    SmartDashboard.updateValues();

    // Initialize subsystems
    limeLight = new Limelight();

    colorSensor = new ColorSensor();
    driveBase = new DriveBase();
    index = new Index();
    intake = new Intake();
    shooter = new Shooter();
    elevator = new Elevator();
    winch = new Winch();
    CameraServer.getInstance().startAutomaticCapture();

    // Initialize OI Last
    oi = new OI();

    // shoootingAuto = new ShootingAuto();
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
    Scheduler.getInstance().run();
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
    System.out.println("Auto selected: " + autoSelected);
    switch (autoSelected) {
      case shootingAuto:
        autonomous = new ShootingAuto();
        break;
      case initiationAuto:
        autonomous = new InitiationAuto();
        break;
      default:
        break;
    }
    if (autonomous != null) {
      autonomous.start();
    }
    // middleAuto.start();
  }

  /** This function is called periodically during autonomous. */
  // WRITE AUTONOMOUS CODE HERE
  @Override
  public void autonomousPeriodic() {

    /*
    switch (autoSelected) {
      case leftAuto:
        leftAutoCommand.start();
        break;
      case rightAuto:
        rightAutoCommand.start();
      case middleAuto:
        middleAutoCommand.start();
        break;
    }*/
    /*
    if (!autonRunning) {
      switch (autoSelected) {
        case leftAuto:
          autonomous = new LeftAuto();
          break;
        case rightAuto:
          autonomous = new RightAuto();
        case middleAuto:
          autonomous = new MiddleAuto();
          break;
      }
    } */
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    // Scheduler.getInstance().run(); // <--- VERY IMPORTANT DON'T REMOVE
 }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
      double rt = Robot.oi.controller.getRawAxis(RobotMap.RT_AXIS);
    double lt = Robot.oi.controller.getRawAxis(RobotMap.LT_AXIS);
    System.out.println(rt);
    System.out.println(lt);
  }
}
