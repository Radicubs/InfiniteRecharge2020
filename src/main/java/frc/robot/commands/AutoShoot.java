package frc.robot.commands; 

import edu.wpi.first.wpilibj.command.CommandGroup; 


public class AutoShoot extends CommandGroup {

  double times[] = {
    0,
    4, // for one ball, it will take 4 seconds to move everything to top
    3, // for two ball, it will take 3 seconds to move everything to top
    2, // for three ball, it will take 2 seconds to top.
    1
  }
  public AutoShoot(int balls) {
    //addSequential(new IndexBall(0.5), times[balls]);
    // MOVE ALL THE BALLS TO THE TOP
    // TO GET READY FOR SHOOTING BASED
    // ON times[]
    addSequential(new IndexBall(0.5))
    addSequential(new WaitCommand(times[balls]));
    addSequential(new IndexBall(0));

    // WE NEED TO CALCULATE THE TIMEOUT FOR X NUM OF BALLS
    addSequential(new RotationAlignment());  
    addSequential(new DistanceAlignment());
    addSequential(new DynamicShooting(), timeout);
  }

  public AutoShoot() {
    addSequential(new RotationAlignment());  
    addSequential(new DistanceAlignment());
    addSequential(new DynamicShooting(), 3);
  }
}
