package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class ArcadeDrive extends Command{
public ArcadeDrive() {

    requires(Robot.driveBase);

}

@Override
    protected void initialize() {

    }

    @Override
    protected void execute() {




}

@Override
protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
}


@Override
protected void end() {

}


@Override
protected void interrupted() {
    super.interrupted();
}
}

