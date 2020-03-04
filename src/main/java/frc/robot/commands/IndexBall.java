package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class IndexBall extends InstantCommand{
  private double speed;
  
  public IndexBall(double speed) {
    requires(Robot.index);
    this.speed = speed;
  }

  // Time to Run command (use it for distance as well)

  @Override
  protected void initialize() {
        Robot.index.index(this.speed);
      } 
}