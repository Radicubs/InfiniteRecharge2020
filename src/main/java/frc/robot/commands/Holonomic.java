package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Holonomic extends Command {
    // Multiplies a vector and a scalar
    public static double[] scalMult(double scalar, double[] vector) {
        double[] newVec = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            newVec[i] = scalar * vector[i];
        }
        return newVec;
    }

    // Add two vectors
    public static double[] vecAdd(double[] vector1, double[] vector2) {
        if (vector1.length != vector2.length) {
            throw new java.lang.Error("Add vectors of the same dimension");
        }
        double[] newVec = new double[vector1.length];
        for (int i = 0; i <= vector1.length; i++) {
            newVec[i] = vector1[i] + vector2[i];
        }
        return newVec;
    }

    //
    public Holonomic() {

        requires(Robot.driveBase);

    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute()
    {
        // Might make cubic in future
        double xRawAxis = Robot.oi.controller.getRawAxis(RobotMap.LEFT_X_AXIS);
        double yRawAxis = Robot.oi.controller.getRawAxis(RobotMap.LEFT_Y_AXIS);
        double rRawAxis = Robot.oi..controller.getRawAxis(RobotMap.RIGHT_X_AXIS);

        double[] strafeForwardVec = {1., 1., -1., -1.}; // TOP LEFT, TOP RIGHT, BOTTOM LEFT, BOTTOM RIGHT
        double[] strafeRightVec = {1., -1., 1, -1.};
        double[] rotateClockwiseVec = {1., -1., -1., 1.};

        double[] strafeControl = vecAdd(scalMult(xRawAxis, strafeRightVec), scalMult(yRawAxis, strafeForwardVec));
        double[] rotControl = scalMult(rRawAxis, rotateClockwiseVec);
        double[] totalControl = scalMult(1 / 3, vecAdd(strafeControl, rotControl));
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
