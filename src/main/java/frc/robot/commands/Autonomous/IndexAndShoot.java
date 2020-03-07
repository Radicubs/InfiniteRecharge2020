package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IndexAndShoot extends Command{

  public IndexAndShoot() {
    requires(Robot.colorSensor);
    requires(Robot.shooter);
    requires(Robot.index);
  }

  // Time to Run command (use it for distance as well)

  @Override
  protected void initialize() {
      } 

@Override
  protected void execute() {
    // if(Robot.colorSensor.foundBall()){
      Robot.index.index(1.0);
      Robot.shooter.shoot(1.0);
      //  }else{
      //  Robot.index.index(0);
 //}
}

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
  }

  @Override
  protected void end() {
    Robot.shooter.shoot(0);
    Robot.index.index(0);
  }

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}