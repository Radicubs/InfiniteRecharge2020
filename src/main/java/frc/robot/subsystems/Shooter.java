package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ShooterDrive;;


public class Shooter extends Subsystem {

  // Have to initialize motors here

  // Right Motors
  private VictorSPX shooterMotor;

  public Shooter() { // constructor
    shooterMotor = new VictorSPX(RobotMap.RIGHT_RANDOM);

    shooterMotor.configFactoryDefault();
  }

  public void shoot() {
    shooterMotor.set(ControlMode.PercentOutput, 0.2);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ShooterDrive());
  }
}
