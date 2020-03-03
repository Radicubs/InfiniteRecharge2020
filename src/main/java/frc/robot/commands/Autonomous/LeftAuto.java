package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup; 


public class LeftAuto extends CommandGroup {
  public LeftAuto() {
    System.out.println("Testing");
  
    addSequential(new DriveForward(0.05), 2);  
    addSequential(new DriveBackward(0.05), 2);

  }
}