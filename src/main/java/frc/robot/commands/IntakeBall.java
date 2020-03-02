package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeBall extends Command{
  private double speed;
  public IntakeBall(double speed) {
    super();
    requires(Robot.colorSensor);
    this.speed = speed;
  }

  // Time to Run command (use it for distance as well)

  @Override
  protected void initialize() {
      } 


  protected void execute() {
    while(Robot.colorSensor.foundBall()){
      Robot.intake.takeIn(speed); // Change to Intake upon merging
  }
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