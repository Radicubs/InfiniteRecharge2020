package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.autonomous.*;
import frc.robot.commands.defaultcommands.*;

public class Elevator extends Subsystem {

  // Have to initialize motors here

  // Right Motors
  private VictorSPX elevatorMotorOne;

  public Elevator() {

    // constructor
    elevatorMotorOne = new VictorSPX(RobotMap.ELEVATOR_MOTOR_ONE);

    // Set Motors to default and neutral
    elevatorMotorOne.configFactoryDefault();
    elevatorMotorOne.setNeutralMode(NeutralMode.Brake);
  }

  public void elevatorRise(double speed) {
    elevatorMotorOne.set(ControlMode.PercentOutput, speed);
    //    elevatorMotorTwo.set(ControlMode.PercentOutput, speed); // Work with mech
  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ClimberControl());
  }
}
