package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {

    private CANSparkMax rightFrontMotor = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax leftFrontMotor = new CANSparkMax(15, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax rightBackMotor = new CANSparkMax(16, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax leftBackMotor = new CANSparkMax(17, CANSparkMaxLowLevel.MotorType.kBrushless);

    private SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);
    private SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);

    public void setSpeed(double desiredRMGSpeed, double desiredLMGSpeed) {
        leftMotors.setInverted(true);
        rightMotors.setInverted(false);

        rightMotors.set(desiredRMGSpeed);
        leftMotors.set(desiredLMGSpeed);
    }
}
