package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.autonomous.*;
import frc.robot.commands.*;
import frc.robot.commands.automaticcommands.IndexBallAutomatic;

public class Index extends Subsystem {

  // Have to initialize motors here

  // Right Motors
  private VictorSPX indexMotor;

  
  public Index() {

    // constructor
    indexMotor = new VictorSPX(RobotMap.INDEX_MOTOR);

    // Set Motors to default and neutral
    indexMotor.configFactoryDefault();
    indexMotor.setNeutralMode(NeutralMode.Brake);

  }

  public void index(double speed) {
    indexMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new AutomatedBallIndex());
  }
}
