package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DistanceAlignment extends Command {
  public DistanceAlignment() {

    requires(Robot.driveBase);
  }

  // Ideal Distacnce for us to be from the target
  private double idealDistance = 81; // needs calibration at plano comp
  private boolean distanceFinished = false;
  private double distanceFromTarget;

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {

    // Get distance from the target
    distanceFromTarget = Robot.limeLight.calculateDistance();

    // If we are too far, then go closer (+3/-3 so that we have an approximate and so our robo doesn't constantly adjust)
    if (idealDistance < distanceFromTarget + 10 || idealDistance < distanceFromTarget - 10) {
      if(Math.abs(idealDistance - distanceFromTarget) < 20){
        Robot.driveBase.drive(Math.abs(idealDistance - distanceFromTarget)/100, -1*Math.abs(idealDistance - distanceFromTarget)/100);

      }else{
      Robot.driveBase.drive(0.3, -0.3);
    }
    // If we are too Close, then move back (+3/-3 so that we have an approximate and so our robo doesn't constantly adjust)
    } else if (idealDistance > distanceFromTarget + 10 || idealDistance > distanceFromTarget - 10) {
      if(Math.abs(idealDistance - distanceFromTarget) < 20){
        Robot.driveBase.drive(-1*Math.abs(idealDistance - distanceFromTarget)/100, Math.abs(idealDistance - distanceFromTarget)/100);

      }else{
      Robot.driveBase.drive(-0.3, 0.3);
    }
    //If we are in the range end the command
    }else if (idealDistance + 10 > distanceFromTarget && idealDistance - 10 < distanceFromTarget){
      distanceFinished = true;
    }
  }

  @Override
  protected boolean isFinished() {
    return distanceFinished;
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
