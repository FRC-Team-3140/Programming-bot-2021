/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public interface Constants {
    public interface GeneralConstants {
		public final static double DEADBAND = 0.1;

		// Use meters, seconds, degrees (180deg to -180deg) (CCWP), and volts for all units.
		public interface PhysicalConstants {
			public final double heightDeltaFromShooterReleaseToPowerPortCenter = 0; // m
			// Field dimensions, etc.
		}

		// Use meters, seconds, degrees (180deg to -180deg), and volts for all motion profiling based units.
		public interface RobotPhysicalConstants {
			// Robot dimensions
			public static final double robotLengthIntakeInWithBumpers = 0.953;
			public static final double robotLengthIntakeOutWithBumpers = 1.1;
			public static final double robotWidthWithBumpers = 0.889;
			public static final double shooterCenterFromRobotRearWithBumpers = 0.734;
						
			// Camera offsets

			// Gear Ratio's
			public static final double driveTrainGearRatio = 7.88;
			public static final double flyWheelGearRatio = 0.7159;
			public static final double turretGearRatio = 11.1;
			public static final double hoodDegreesPerRotation = 0;

			// Diameters
			public static final double wheelDiameterMeters = 0.1524;
			public static final double flyWheelDiameterMeters = 0.1016;
		}

		// Use meters, seconds, degrees (180deg to -180deg) (CCWP), and volts for all units.
		public interface SensorConstants {
			// Gyro
			// True to make Counter Clockwise Angles Positive, and Clockwise Negative.
			public static final boolean kGyroReversed = true; 

			// Position Conversions
			// (Native units for the Spark Max are in Rotations)
			public static final int kDriveTrainEncoderCPR = 1; // Encoder Counts/Pulses per Rotation (usually > 1)
			public static final int kFlyWheelEncoderCPR = 1; // Encoder Counts/Pulses per Rotation (usually > 1)
			public static final double kDriveTrainEncoderMetersPerPulse = (RobotPhysicalConstants.wheelDiameterMeters
					* Math.PI) / ((double) kDriveTrainEncoderCPR * RobotPhysicalConstants.driveTrainGearRatio);
			public static final double kFlyWheelEncoderMetersPerPulse = (RobotPhysicalConstants.flyWheelDiameterMeters
					* Math.PI) / ((double) kFlyWheelEncoderCPR * RobotPhysicalConstants.flyWheelGearRatio);

			// Velocity Conversions
			public static final double RPM_to_RPS = ((double) 1 / 60);
			public static final double driveTrainMetersPerRotation = kDriveTrainEncoderMetersPerPulse
					* kDriveTrainEncoderCPR;
			public static final double flyWheelMetersPerRotation = kFlyWheelEncoderMetersPerPulse
					* kFlyWheelEncoderCPR;
			public static final double kDriveTrainEncoderLinearMetersPerSecondPerRPM = driveTrainMetersPerRotation
					* RPM_to_RPS;
			public static final double kFlyWheelEncoderLinearMetersPerSecondPerRPM = flyWheelMetersPerRotation
					* RPM_to_RPS;
		}
	}

    public interface ElectricalPortConstants {
		// Xbox Controllers
		public static final int xboxPrimaryDriver = 0;

		// Other Can Bus
		public final static int PDP = 0;
		public final static int PCM = 1;

		// Drivetrain
		public final static int LEFT_DRIVE_MASTER = 7;
		public final static int RIGHT_DRIVE_MASTER = 5;
		public final static int LEFT_DRIVE_SLAVE1 = 4;
		public final static int RIGHT_DRIVE_SLAVE1 = 6;

		
	}
}
