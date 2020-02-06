package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ClimberDrive;
import frc.robot.commands.ShooterDrive;;


public class Climber extends Subsystem {

  // Have to initialize motors here

  // Right Motors
  private VictorSPX climberMotorOne;
  private VictorSPX climberMotorTwo;

  public Climber() { // constructor
    climberMotorOne = new VictorSPX(RobotMap.CLIMB_MOTOR_ONE);
    climberMotorTwo = new VictorSPX(RobotMap.CLIMB_MOTOR_TWO);

    climberMotorOne.configFactoryDefault();
    climberMotorTwo.configFactoryDefault();

  }

  public void climb(double speed) {
     climberMotorTwo.set(ControlMode.PercentOutput, speed);
}

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ClimberDrive());
  }
}
