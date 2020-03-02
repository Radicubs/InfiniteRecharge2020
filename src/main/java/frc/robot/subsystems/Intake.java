package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.*;

public class Intake extends Subsystem {

  // Have to initialize motors here

  // Right Motors
  private VictorSPX intakeMotor;

  
  public Intake() {

    // constructor
    intakeMotor = new VictorSPX(RobotMap.INTAKE_MOTOR);

    // Set Motors to default and neutral
    intakeMotor.configFactoryDefault();
    intakeMotor.setNeutralMode(NeutralMode.Brake);

  }

  public void takeIn(double speed) {
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IntakeBall(0.5));
  }
}
