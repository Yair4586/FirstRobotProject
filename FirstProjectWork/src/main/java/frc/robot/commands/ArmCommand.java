// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;

public class ArmCommand extends CommandBase {

  private final Arm arm = Arm.getInstance();
  
  private double setPoint;

  public ArmCommand(double setPoint) {
    this.setPoint = setPoint;
    this.addRequirements(arm);
  }


  @Override
  public void initialize() {
    if (this.setPoint < arm.getPosArm()){
      arm.moveArm(-1 * Constants.ArmConstants.CollectMotorSpeed);
    }
    else {
      arm.moveArm(Constants.ArmConstants.CollectMotorSpeed);
    }
    
  }


  @Override
  public void execute() {
  }


  @Override
  public void end(boolean interrupted) {
    arm.moveArm(0.0);

  }


  @Override
  public boolean isFinished() {
    if (arm.getPosArm() == Constants.ArmConstants.setPoint){
      return true;
    }
    return false;
  }
}
