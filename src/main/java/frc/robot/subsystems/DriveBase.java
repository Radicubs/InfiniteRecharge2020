package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;

public class DriveBase extends Subsystem {

  // Have to initialize motors here

  //Right Motors
  private TalonSRX rightMotorMain; 
  private VictorSPX rightMotorTwo;  
  private VictorSPX rightMotorThree;

  private TalonSRX leftMotorMain;
  private VictorSPX leftMotorTwo;
  private VictorSPX leftMotorThree;

  public DriveBase() { // constructor
    rightMotorMain = new TalonSRX(RobotMap.RIGHT_TALON);
    rightMotorTwo = new VictorSPX(RobotMap.RIGHT_FOLLOWER_ONE);
    rightMotorThree = new VictorSPX(RobotMap.RIGHT_FOLLOWER_TWO);
  
    leftMotorMain = new TalonSRX(RobotMap.LEFT_TALON);
    leftMotorTwo = new VictorSPX(RobotMap.LEFT_FOLLOWER_ONE);
    leftMotorThree = new VictorSPX(RobotMap.LEFT_FOLLOWER_TWO);  
  }

  public void drive(double leftSpeed, double rightSpeed) {
    // set motors to these values
  }

  public void initDefaultCommand() {
    setDefaultCommand(new ArcadeDrive());
  }
}
