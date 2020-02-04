package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.IndexBall;

public class Index extends Subsystem {

  // Have to initialize motors here

  // Right Motors
  private VictorSPX indexMotor;


  public Index() { // constructor
    indexMotor = new VictorSPX(RobotMap.LEFT_RANDOM);

    indexMotor.configFactoryDefault();
  }

  public void drive(double leftSpeed, double rightSpeed) {
    indexMotor.set(ControlMode.PercentOutput, rightSpeed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IndexBall());
  }
}
