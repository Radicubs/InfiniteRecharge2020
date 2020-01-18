package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ArcadeDrive extends Command
{
    public ArcadeDrive()
    {

        requires(Robot.driveBase);

    }

    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        double rawSpeed = Robot.oi.controller.getRawAxis(RobotMap.LEFT_Y_AXIS);
        double rawRotation = Robot.oi.controller.getRawAxis(RobotMap.RIGHT_X_AXIS);

        double scaledSpeed = Math.pow(rawSpeed, 3);
        double scaledRotation = Math.pow(rawSpeed, 3);

        double leftOut = 0.5 * (scaledSpeed + scaledRotation);
        double rightOut = 0.5 * (scaledSpeed - scaledRotation);

        Robot.driveBase.drive(leftOut, rightOut);
    }

    @Override
    protected boolean isFinished()
    {
        // Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    protected void end()
    {

    }

    @Override
    protected void interrupted()
    {
        super.interrupted();
    }
}
