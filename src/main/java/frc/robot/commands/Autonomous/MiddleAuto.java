package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup; 


public class MiddleAuto extends CommandGroup {
  public MiddleAuto() {

    addSequential(new DriveForward(0.05), 2);  
    addSequential(new DriveBackward(0.05),2);

  }
}