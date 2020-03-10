package frc.robot.commands.onofftoggles;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.commands.*;
import frc.robot.commands.defaultcommands.RunIntake;

public class IntakeState extends InstantCommand {
  public IntakeState() {}

  @Override
  protected void initialize() {
    RunIntake.intakeOnOff();
  }
}
