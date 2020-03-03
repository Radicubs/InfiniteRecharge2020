package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup; 


public class RightAuto extends CommandGroup {
  public RightAuto() {

    addSequential(new DriveForward(0.05),2);  
    addSequential(new DriveBackward(0.05),2);

  }
}