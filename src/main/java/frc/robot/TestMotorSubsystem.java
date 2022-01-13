package frc.robot;

import org.xero1425.base.Subsystem;
import org.xero1425.base.motorsubsystem.MotorEncoderSubsystem;

public class TestMotorSubsystem extends MotorEncoderSubsystem {
    public TestMotorSubsystem(Subsystem parent) throws Exception {
        super(parent, "motortest", false) ;
    }
}
