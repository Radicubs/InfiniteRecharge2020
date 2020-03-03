package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveBackward extends Command{
  private double speed;
  public DriveBackward(double speed) {
    requires(Robot.driveBase);
    this.speed = speed;
  }

  // Time to Run command (use it for distance as well)

  @Override
  protected void initialize() {
      } 


  protected void execute() {
      Robot.driveBase.drive(speed,-speed);
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
    //super.interrupted();
    System.out.println("Interrupted");
    end();
    }
}