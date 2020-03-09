package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import frc.robot.commands.autonomous.*;

public class Shooter extends Subsystem {

  // Have to initialize motors here

  // Right Motors
  private VictorSPX shooterMotor;

  
  public Shooter() {

    // constructor
    shooterMotor = new VictorSPX(RobotMap.SHOOTER_MOTOR);

    // Set Motors to default and neutral
    shooterMotor.configFactoryDefault();
    shooterMotor.setNeutralMode(NeutralMode.Brake);

  }

  public void shoot(double speed) {
    shooterMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new ShootBallAutomatic(-1.0));
  }
}
