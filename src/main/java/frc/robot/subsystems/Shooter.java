package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ShootBall;

public class Shooter extends Subsystem {

  // Have to initialize motors here

  // Right Motors
  private VictorSPX shooterMotor;


  public Shooter() { // constructor
    shooterMotor = new VictorSPX(RobotMap.SHOOTER_MOTOR);

    shooterMotor.configFactoryDefault();
  }

  public void drive(double leftSpeed, double rightSpeed) {
    shooterMotor.set(ControlMode.PercentOutput, rightSpeed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ShootBall());
  }
}
