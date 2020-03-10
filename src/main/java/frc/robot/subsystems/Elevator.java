package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.autonomous.*;

public class Elevator extends Subsystem {

  // Have to initialize motors here

  // Right Motors
  private VictorSPX elevatorMotorOne;
  private VictorSPX elevatorMotorTwo;

  public Elevator() {

    // constructor
    elevatorMotorOne = new VictorSPX(RobotMap.ELEVATOR_MOTOR_ONE);
    elevatorMotorTwo = new VictorSPX(RobotMap.ELEVATOR_MOTOR_TWO);

    // Set Motors to default and neutral
    elevatorMotorOne.configFactoryDefault();
    elevatorMotorTwo.configFactoryDefault();
    elevatorMotorOne.setNeutralMode(NeutralMode.Brake);
    elevatorMotorTwo.setNeutralMode(NeutralMode.Brake);
  }

  public void rise(double speed) {
    elevatorMotorOne.set(ControlMode.PercentOutput, speed);
    elevatorMotorTwo.set(ControlMode.PercentOutput, speed); // Work with mech
  }

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new IntakeBall());
  }
}
