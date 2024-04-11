// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
   
    public static final class DriveConstants {
        public static final int LEFT_MOTOR1 = 1;
        public static final int LEFT_MOTOR2 = 2;
        public static final int RIGHT_MOTOR1 = 3;
        public static final int RIGHT_MOTOR2 = 4;
        public static final int[] LEFT_ENCODER_IDS = {6,7};
        public static final int[] RIGHT_ENCODER_IDS = {8,9};


        public static final double[] CONE_POSES = {0,0,0,0,0,0};
        public static final double[] CUBE_UP_POSES = {0,0,0};
        public static final double[] CUBE_MID_POSES = {0,0,0};
        public static final double[] HYBRID_POSES = {0,0,0,0,0,0,0,0,0};

        public static final double X_CONE = 0;
        public static final double X_CUBE_UP = 0;
        public static final double X_CUBE_MID = 0;
        public static final double X_HYBRID = 0;

        public static final int GYRO_NUM = 7;

        public static final double TO_RADIANS = 1 / 180 * Math.PI;
        public static final double ROTATIONS_TO_METERS = 1 / 8.45 * 15.24 * Math.PI / 100;

        public static final double ENCODER_DISTANCE_PER_PULSE = 0.0002337787;
        public static final int RIGHT_ENCODER_REVERSED = 4;
        public static final double KS_VOLTS = 0.5;
        public static final double KV_VOLT_SECOND_PER_METER  = 2.8419;
        public static final double KA_VOLT_SECONDS_SQUARE_PER_METER = 1.4226;

        public static final double KP = 0.8;
        public static final double KI = 0.02;
    
        public static final double KP_DRIVE_VEL = 0.002;
        public static final double KTRACK_WIDTH_METERS = 0.54;
        public static final DifferentialDriveKinematics DRIVE_KINEMATICS =
            new DifferentialDriveKinematics(KTRACK_WIDTH_METERS);
    
        public static final double MAX_SPEED_METER_PER_SECOND = 2;
        public static final double MAX_ACCELERATION_METERS_PER_SECOND_SQUARED = 2;

        public static final double RATE = 0.04;
        public static final double ANGLE_TOLERANCE = 2;

        public static final double DRIVE_BACK = -2;




        // Reasonable baseline values for a RAMSETE follower in units of meters and seconds
        public static final double RAMSETE_B = 2;
        public static final double RAMSETE_ZETA = 0.7;

    }


    public static final class JoystickConstants {
        public static final int DRIVE_JOYSTICK = 0;
        public static final int OPERATE_JOYSTICK = 1;

        /** A button axis */
        public static final int A = 1;
        /** B button axis */
        public static final int B = 2;
        /** X button axis */
        public static final int X = 3;
        /** Y button axis */
        public static final int Y = 4;
        /** LB button axis */
        public static final int LB = 5;
        /**RB button axis */
        public static final int RB = 6;

        /** left joystick click button axis */
        public static final int LEFT_JOYSTICK_CLICK = 9;
        /** right joystick click button axis */
        public static final int RIGHT_JOYSTICK_CLICK = 10;

        /** left trigger button axis */
        public static final int LEFT_TRIGGER = 2;
        /** right trigger button axis */
        public static final int RIGHT_TRIGGER = 3;

        public static final int LEFT_JOYSTICK_Y = 1;
        public static final int LEFT_JOYSTICK_X = 0;
        public static final int RIGHT_JOYSTICK_Y = 5;
        public static final int RIGHT_JOYSTICK_X = 4;

        public static final int POV_DOWN = 180;
        public static final int POV_LEFT = 270;
        public static final int POV_RIGHT = 90;
        public static final int POV_UP = 0;
        public static final int POV_NONE = -1;

        public static final double THRESHOLD = 0.3;


    }
    public static final class GripperConstants {
        public static final int MOTOR_ID = 6;

        public static final double EJECT = 0.8;
        public static final double EJECT_SLOW = 0.31;
        public static final double TAKE_IN = -0.85;
    }
    public static final class LiftConstants {
        public static final int MOTOR_ID = 5;
        public static final int FOLD_MICRO_SWITCH_ID = 4;
        public static final int GROUND_MICRO_SWITCH_ID = 3;
        
        public static final double KP = 0.22;
        public static final double PROFILE_KP = 0.03;//CHECK!!
        public static final double KI = 0.0;
        public static final double KD = 0;
        
        public static final double KG = 0.045;
        public static final double CONVERSION_FACTOR = (1.0 / 50) * (16.0 / 42) * 2 * Math.PI;

        public static final double MAX_VEL = 0.5;//CHECK!!

        public static final double CLOSE_SLOW = -0.1;
        public static final double OPEN_RESET = 0.18;

        public static final double NONE = -1;

        public static final double TOLERANCE = 2.5;

        public static final double GROUND = 67.8;
        public static final double FOLD = 0;
        public static final double CUBE_DOWN = 51.5;
        public static final double CUBE_UP = 43.5;
        public static final double CONE = 51.5;
        public static final double FIDDER = 44.5;

        


    }

    public static final class GeneralFunctions{
        /**
         * checks if you reached set point with an alowed error
         * @param state the current state
         * @param setPoint the set point
         * @param tolerance the allowed error
         * @return have you reached
         */
        public static boolean allowedError(double state, double setPoint, double tolerance)
        {
            return Math.abs(state - setPoint) < tolerance; 
        }
    }
    
}

