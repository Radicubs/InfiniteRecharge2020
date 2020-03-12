package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.autonomous.*;

public class Winch extends Subsystem {

  // Have to initialize motors here

  // Right Motors
  private VictorSPX winch;

  public Winch() {

    // constructor
    winch = new VictorSPX(RobotMap.ELEVATOR_MOTOR_TWO);

    // Set Motors to default and neutral
    winch.configFactoryDefault();
    winch.setNeutralMode(NeutralMode.Brake);
  }

  public void winchRise(double speed) {
    winch.set(ControlMode.PercentOutput, speed);
    //    elevatorMotorTwo.set(ControlMode.PercentOutput, speed); // Work with mech
  }
  
  @Override
  public void initDefaultCommand() {
    //    setDefaultCommand(new WinchControl());
  }
}
