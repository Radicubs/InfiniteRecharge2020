package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.commands.*;

public class IntakeState extends InstantCommand {
  public IntakeState() {
      
  }

  @Override
  protected void initialize() {    
    IntakeBall.intakeOnOff();
} 

  }