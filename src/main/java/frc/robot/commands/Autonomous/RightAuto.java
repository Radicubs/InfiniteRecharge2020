package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup; 


public class RightAuto extends CommandGroup {
  public RightAuto() {

    addSequential(new DriveForward(2000));  
    addSequential(new DriveBackward(2000));

  }
}