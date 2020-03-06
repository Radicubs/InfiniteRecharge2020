package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class IntakeBall extends Command{
  private double speed;
  private static double intakeState = 1.0;
  
  public IntakeBall(double speed) {
    requires(Robot.intake);
    this.speed = speed;
  }

  @Override
  protected void execute() {
      //speed *= intakeState;
      Robot.intake.takeIn(speed*intakeState);

  }

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
  }
  public static void intakeOnOff(){
    if (intakeState == 1.0){
      intakeState = 0;
    } else {
      intakeState = 1.0;
    }
}
  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}