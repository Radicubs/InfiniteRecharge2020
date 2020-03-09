package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


public class RunIntake extends Command{
  private double speed;
  private static double intakeState = 1.0;
  private static String dashboardState = "ON";

  
  public RunIntake(double speed) {
    requires(Robot.intake);
    this.speed = speed;
  }

  @Override
  protected void execute() {
      //speed *= intakeState;
      Robot.intake.takeIn(speed*intakeState);
      SmartDashboard.putString("Intake State", dashboardState);

  }

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
  }
  public static void intakeOnOff(){
    if (intakeState == 1.0){
      intakeState = 0;
      dashboardState = "OFF";
    } else {
      intakeState = 1.0;
      dashboardState = "ON";
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