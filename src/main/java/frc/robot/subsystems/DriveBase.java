package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Holonomic;;

public class DriveBase extends Subsystem {

  // Have to initialize motors here

  public DriveBase() { //constructor
    //Assign motors based off of RobotMap
  }

  public void drive(double leftSpeed, double rightSpeed) {
    // set motors to these values
  }

  public void initDefaultCommand() {
    setDefaultCommand(new Holonomic());
  }
}
