package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup; 


public class MiddleAuto extends CommandGroup {
  public MiddleAuto() {

    addSequential(new DriveForward(2000, 0.3));  
    addSequential(new DriveBackward(2000,0.3));

  }
}