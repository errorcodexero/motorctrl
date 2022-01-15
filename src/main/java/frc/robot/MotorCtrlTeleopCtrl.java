package frc.robot;

import org.xero1425.base.XeroRobot;
import org.xero1425.base.controllers.TeleopController;
import org.xero1425.base.motors.BadMotorRequestException;
import org.xero1425.base.motorsubsystem.PowerTestAction;
import org.xero1425.misc.BadParameterTypeException;
import org.xero1425.misc.MissingParameterException;

public class MotorCtrlTeleopCtrl extends TeleopController {
    public MotorCtrlTeleopCtrl(XeroRobot robot) {
        super(robot, "Teleop") ;
    }

    @Override
    public void init() {
        MotorCtrlRobotSubsystem robsys = (MotorCtrlRobotSubsystem)getRobot().getRobotSubsystem() ;
        TestMotorSubsystem test = robsys.getTestmotors() ;
        try {
            test.setAction(new PowerTestAction(test)) ;
        } catch (MissingParameterException | BadParameterTypeException | BadMotorRequestException e) {
        }
    }

    @Override
    public void run() {

    }
}
