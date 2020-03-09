package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutomatedBallIndex extends Command{

  public AutomatedBallIndex() {
    requires(Robot.colorSensor);
    requires(Robot.index);
  }

  // Time to Run command (use it for distance as well)

  @Override
  protected void initialize() {
      } 

@Override
  protected void execute() {
    if(Robot.colorSensor.foundBall()){
      Robot.index.index(0.4);
       }else{
       Robot.index.index(0);
 }
}

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}