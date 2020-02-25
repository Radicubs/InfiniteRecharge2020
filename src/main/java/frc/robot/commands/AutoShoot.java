package frc.robot.commands; 

import edu.wpi.first.wpilibj.command.CommandGroup; 


public class AutoShoot extends CommandGroup {
  public AutoShoot() {

    addSequential(new RotationAlignment());  
    addSequential(new DistanceAlignment());
    addSequential(new OneShoot());

  }
}
