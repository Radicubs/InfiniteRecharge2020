package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;

public class DriveBase extends Subsystem {

  // Have to initialize motors here

  // Right Motors
  private TalonSRX rightMotorMain;
  private VictorSPX rightMotorTwo;

  private TalonSRX leftMotorMain;
  private VictorSPX leftMotorTwo;

  public DriveBase() { // constructor
    rightMotorMain = new TalonSRX(RobotMap.RIGHT_TALON);
    rightMotorTwo = new VictorSPX(RobotMap.RIGHT_FOLLOWER_ONE);

    leftMotorMain = new TalonSRX(RobotMap.LEFT_TALON);
    leftMotorTwo = new VictorSPX(RobotMap.LEFT_FOLLOWER_ONE);

    leftMotorMain.configFactoryDefault();
    leftMotorTwo.configFactoryDefault();
    rightMotorMain.configFactoryDefault();
    rightMotorTwo.configFactoryDefault();

    rightMotorTwo.follow(rightMotorMain);

    leftMotorTwo.follow(leftMotorMain);
  }

  public void drive(double leftSpeed, double rightSpeed) {
    rightMotorMain.set(ControlMode.PercentOutput, rightSpeed);
    leftMotorMain.set(ControlMode.PercentOutput, leftSpeed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ArcadeDrive());
  }
}
