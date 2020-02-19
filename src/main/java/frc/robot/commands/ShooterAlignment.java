package frc.robot.commands; 

import edu.wpi.first.wpilibj.command.CommandGroup; 


public class ShooterAlignment extends CommandGroup {
  public ShooterAlignment() {

    addSequential(new RotationAlignment());  
    addSequential(new DistanceAlignment());

  }
}
