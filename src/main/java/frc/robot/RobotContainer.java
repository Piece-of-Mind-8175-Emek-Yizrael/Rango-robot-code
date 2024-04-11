// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import static frc.robot.Constants.DriveConstants.*;
import static frc.robot.Constants.DriveConstants.RAMSETE_B;
import static frc.robot.Constants.DriveConstants.RAMSETE_ZETA;
import static frc.robot.Constants.JoystickConstants.A;
import static frc.robot.Constants.JoystickConstants.*;
import static frc.robot.Constants.JoystickConstants.LEFT_JOYSTICK_Y;
import static frc.robot.Constants.JoystickConstants.OPERATE_JOYSTICK;
import static frc.robot.Constants.JoystickConstants.RIGHT_JOYSTICK_CLICK;
import static frc.robot.Constants.JoystickConstants.THRESHOLD;
import static frc.robot.Constants.JoystickConstants.Y;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.LiftConstants;
import frc.robot.commands.armCommands.CloseArmSlowCommand;
import frc.robot.commands.armCommands.LiftToPointCommand;
import frc.robot.commands.armCommands.LiftToPointOnceCommand;
import frc.robot.commands.armCommands.OpenArmSlowForResetCommand;
import frc.robot.commands.armCommands.liftByButtonCommand;
import frc.robot.commands.autonomous.AutonomousCommand;
import frc.robot.commands.autonomous.PushInAndGetOut;
import frc.robot.commands.autonomous.PutCubeUpAndOutCommand;
import frc.robot.commands.autonomous.PutPieceAndOutCommand;
import frc.robot.commands.autonomous.TrajectoryFactory;
import frc.robot.commands.autonomous.putConeAndGetOut;
import frc.robot.commands.driveCommands.BalanceAutomationCommand;
import frc.robot.commands.driveCommands.DriveBackAndEject;
import frc.robot.commands.driveCommands.DriveByJoystickArcadeCommand;
import frc.robot.commands.driveCommands.DriveConstantSpeedCommand;
import frc.robot.commands.driveCommands.DriveMeasuredDistance;
import frc.robot.commands.driveCommands.StopRobotDrive;
import frc.robot.commands.driveCommands.TurnByDegreeCommand;
import frc.robot.commands.gripperCommands.GripperCommand;
import frc.robot.commands.gripperCommands.GripperOnceCommand;
import frc.robot.commands.positioningCommands.ConePositioningCommand;
import frc.robot.subsystems.ColorSensorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.subsystems.LiftSubsystem;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  
  
  private static RobotContainer m_robotContainer = new RobotContainer();
  
  public Joystick driveJoystick = new Joystick(DRIVE_JOYSTICK);
  public Joystick operateJoystick = new Joystick(OPERATE_JOYSTICK);
  
  public CommandJoystick driverCommandJoystick = new CommandJoystick(DRIVE_JOYSTICK);
  public CommandJoystick operateCommandJoystick = new CommandJoystick(OPERATE_JOYSTICK);


  public DriveSubsystem mDriveSubsystem = new DriveSubsystem();
  public DriveByJoystickArcadeCommand mDriveByJoystickArcadeCommand = new DriveByJoystickArcadeCommand(mDriveSubsystem, () -> driveJoystick.getRawAxis(RIGHT_JOYSTICK_Y), () -> driveJoystick.getRawAxis(LEFT_TRIGGER) - driveJoystick.getRawAxis(RIGHT_TRIGGER), () -> driveJoystick.getRawButtonReleased(LB));
  public StopRobotDrive mStopRobotDrive = new StopRobotDrive(mDriveSubsystem);

  public ColorSensorSubsystem mColorSensorSubsystem = new ColorSensorSubsystem();
  
  public LiftSubsystem mLiftSubsystem = new LiftSubsystem();
  public LiftToPointCommand mLiftToPointCommand = new LiftToPointCommand(mLiftSubsystem, () -> operateJoystick.getPOV() == POV_DOWN, () -> operateJoystick.getPOV() == POV_LEFT, () -> operateJoystick.getPOV() == POV_UP, () -> operateJoystick.getPOV() == POV_RIGHT, () -> operateJoystick.getRawButtonReleased(LB), () -> operateJoystick.getRawButtonReleased(RB));
  public liftByButtonCommand mLiftByButtonCommand = new liftByButtonCommand(mLiftSubsystem);
  public CloseArmSlowCommand mCloseArmSlowCommand = new CloseArmSlowCommand(mLiftSubsystem, () -> operateJoystick.getRawButton(B));
  public OpenArmSlowForResetCommand mOpenArmSlowForResetCommand = new OpenArmSlowForResetCommand(mLiftSubsystem, () -> operateJoystick.getRawButton(B));
  
  
  public  GripperSubsystem mGripperSubsystem = new GripperSubsystem();
  public  GripperCommand mGripperCommand = new GripperCommand(mGripperSubsystem, () -> operateJoystick.getRawAxis(LEFT_TRIGGER) > THRESHOLD, () -> operateJoystick.getRawButton(X), () -> operateJoystick.getRawAxis(RIGHT_TRIGGER) > THRESHOLD);
  
  public DriveBackAndEject mDriveBackAndEject = new DriveBackAndEject(mDriveSubsystem, mGripperSubsystem);
  public BalanceAutomationCommand mBalanceAutomationCommand = new BalanceAutomationCommand(mDriveSubsystem);

  public TrajectoryFactory mTrajectoryFactory = new TrajectoryFactory();
  public PushInAndGetOut mPushInAndGetOut = new PushInAndGetOut(mDriveSubsystem);
  public PutCubeUpAndOutCommand mCubeUpAndOutCommand = new PutCubeUpAndOutCommand(mDriveSubsystem, mGripperSubsystem, mLiftSubsystem);

  public ConePositioningCommand mConstructAndScheduleConePositioningCommand = new ConePositioningCommand(mDriveSubsystem, mTrajectoryFactory);

  public Command mPieceRampCommand = new LiftToPointOnceCommand(mLiftSubsystem, LiftConstants.CUBE_UP).andThen(
                          new GripperOnceCommand(mGripperSubsystem, 1).withTimeout(0.1).andThen(
                            new DriveConstantSpeedCommand(mDriveSubsystem, -3).withTimeout(4.05).alongWith(new GripperOnceCommand(mGripperSubsystem, 0.9).withTimeout(4),new LiftToPointOnceCommand(mLiftSubsystem, 0)).andThen(
                                  new DriveConstantSpeedCommand(mDriveSubsystem, 2).withTimeout(1.3).andThen(
                                    new WaitCommand(0.4).andThen(
                                      new BalanceAutomationCommand(mDriveSubsystem).andThen(
                                          new WaitCommand(0.5).andThen(
                                            new BalanceAutomationCommand(mDriveSubsystem))))))));


  public Command mPutCollectCommand = new DriveMeasuredDistance(mDriveSubsystem, -310).andThen(
                                new TurnByDegreeCommand(mDriveSubsystem, 70).andThen(
                                  new LiftToPointOnceCommand(mLiftSubsystem, LiftConstants.GROUND).andThen(
                                    new DriveMeasuredDistance(mDriveSubsystem, 80).alongWith(new GripperOnceCommand(mGripperSubsystem, -0.7)).andThen(
                                      new LiftToPointOnceCommand(mLiftSubsystem, LiftConstants.FOLD).andThen(
                                        new DriveMeasuredDistance(mDriveSubsystem, -80).andThen(
                                          new TurnByDegreeCommand(mDriveSubsystem, -70).andThen(
                                            new DriveMeasuredDistance(mDriveSubsystem, 310)
                                      )
                                    ))
                                  )
                                ))
  );

  public DriveMeasuredDistance mDriveMeter = new DriveMeasuredDistance(mDriveSubsystem, 1);


   
  // public AutomationPositioningCubeMidCommand mAutomationPositioningCubeMidCommand = new AutomationPositioningCubeMidCommand(mDriveSubsystem, mTrajectoryFactory);
  // public AutomationPositioningCubeUpCommand mAutomationPositioningCubeUpCommand = new AutomationPositioningCubeUpCommand(mDriveSubsystem, mTrajectoryFactory);
  // public AutomationPositioningHybridCommand mAutomationPositioningHybridCommand = new AutomationPositioningHybridCommand(mDriveSubsystem, mTrajectoryFactory);



    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems

// Joysticks

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {

    
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("piece - out", new PutPieceAndOutCommand(mDriveSubsystem, mGripperSubsystem, mLiftSubsystem));
    m_chooser.addOption("push and out", mPushInAndGetOut);
    m_chooser.addOption("cube up - out", mCubeUpAndOutCommand);
    m_chooser.addOption("piece - ramp", mPieceRampCommand);

    mDriveSubsystem.setDefaultCommand(mDriveByJoystickArcadeCommand);
    // mLiftSubsystem.setDefaultCommand(mLiftToPointCommand);
    mLiftSubsystem.setDefaultCommand(mLiftSubsystem.resistGravity());
    mGripperSubsystem.setDefaultCommand(mGripperCommand);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    /**closes the arm until it reaches to the fold limit switch*/
     Trigger aTrigger = operateCommandJoystick.button(A);
     aTrigger.onTrue(mCloseArmSlowCommand);
    /**opens the arm until it reaches to the ground limit switch*/
     Trigger yTrigger = operateCommandJoystick.button(Y);
     yTrigger.onTrue(mOpenArmSlowForResetCommand);

     /** drives back end ejects the game piece while the button is preesed */
     Trigger driveBackAndEjectTrigger = driverCommandJoystick.axisGreaterThan(LEFT_JOYSTICK_Y, THRESHOLD);
     driveBackAndEjectTrigger.whileTrue(mDriveBackAndEject);

     /** stops the drive motors until yhe button is released */
     Trigger stopDriveTrigger = driverCommandJoystick.button(RIGHT_JOYSTICK_CLICK);
     stopDriveTrigger.whileTrue(mStopRobotDrive);

     /** drives the robot for ballance while the button is pressed */
     Trigger mBallanceTrigger = driverCommandJoystick.button(Y);
     mBallanceTrigger.whileTrue(mBalanceAutomationCommand);

    //  Trigger driveRamseteTrigger = driverCommandJoystick.axisLessThan(1, -0.3);
    //  driveRamseteTrigger.onTrue(mDriveBack1);

      //  Trigger driveMeterTrigger = driverCommandJoystick.button(A);
      //  driveMeterTrigger.whileTrue(mDriveMeter);
      

    //  Trigger automationCubeUpTrigger = driverCommandJoystick.button(CUBE_UP_AUTOMATION_BUTTON);
    //  automationCubeUpTrigger.onTrue(mAutomationPositioningConeCommand);

    //  Trigger automationCubeMidTrigger = driverCommandJoystick.button(CUBE_MID_AUTOMATION_BUTTON);
    //  automationCubeMidTrigger.onTrue(mAutomationPositioningConeCommand);

    //  Trigger automationHybridTrigger = driverCommandJoystick.button(HYBRID_AUTOMATION_BUTTON);
    //  automationHybridTrigger.onTrue(mAutomationPositioningConeCommand);


    

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  public  Command getRamseteCommand(Trajectory trajectory){

    return new RamseteCommand(
      trajectory,
      mDriveSubsystem::getPose,
      new RamseteController(RAMSETE_B, RAMSETE_ZETA),
      new SimpleMotorFeedforward(
          KS_VOLTS,
          KV_VOLT_SECOND_PER_METER,
          KA_VOLT_SECONDS_SQUARE_PER_METER),
      DRIVE_KINEMATICS,
      mDriveSubsystem::getWheelSpeeds,
      new PIDController(KP_DRIVE_VEL, 0, 0),
      new PIDController(KP_DRIVE_VEL, 0, 0),
      mDriveSubsystem::tankDriveVolts,
      mDriveSubsystem);
    
    }


}

