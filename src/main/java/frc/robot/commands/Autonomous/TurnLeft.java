package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TurnLeft extends Command{
  private double speed;

  public TurnLeft(double speed) {
    requires(Robot.driveBase);
    this.speed = speed;
    //System.out.println("Called");
  }


  @Override
  protected void initialize() {

  } 

  @Override
  protected void execute() {
      Robot.driveBase.drive(speed,speed);
      //System.out.println("Called");

  }

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
  }

  @Override
  protected void end() {
    Robot.driveBase.drive(0,0);
  }

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}