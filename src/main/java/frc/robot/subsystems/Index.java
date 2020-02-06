package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.IndexDrive;


public class Index extends Subsystem {

  // Have to initialize motors here

  // Right Motors
  private VictorSPX indexMotorOne;

  public Index() { // constructor
    indexMotorOne = new VictorSPX(RobotMap.INDEX_MOTOR);

    indexMotorOne.configFactoryDefault();

  }

  public void indexBall(double speed) {
    indexMotorOne.set(ControlMode.PercentOutput, speed);
}

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IndexDrive());
  }
}
