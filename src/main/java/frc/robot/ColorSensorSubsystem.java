package frc.robot;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import org.xero1425.base.Subsystem;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

public class ColorSensorSubsystem extends Subsystem {
    private int multiplexer_address_ ;
    private I2C i2c_ ;
    private I2C.Port port_ ;
    private ColorSensorV3 sensor_ ;
    private int which_ ;
    private int count_ ;
    private ColorMatch matcher_ ;

    class HSVColor
    {
        public float hue_ ;
        public float saturation_ ;
        public float value_ ;

        HSVColor(float h, float s, float v) {
            hue_ = h ;
            saturation_ = s ;
            value_ = v ;
        }
    } ;
    
    public ColorSensorSubsystem(Subsystem parent, String name, int count) {
        super(parent, name) ;

        matcher_ = new ColorMatch() ;
        matcher_.addColorMatch(Color.kRed) ;
        matcher_.addColorMatch(Color.kBlue) ;

        which_  = -1 ;
        count_ = count ;

        multiplexer_address_ = 112 ;
        port_ = I2C.Port.kMXP ;

        i2c_ = new I2C(port_, multiplexer_address_) ;
        switchTo(0) ;
        sensor_ = new ColorSensorV3(port_) ;

        for(int i = 0 ; i < count ; i++)
            init(i) ;
    }

    public void switchTo(int which) {

        if (which != which_) {
            byte[] dataToSend = new byte[1] ;
            dataToSend[0] = (byte)(0x01 << which) ;
            i2c_.writeBulk(dataToSend);
            which_ = which ;
        }
    }

    @Override
    public void computeMyState() {
        for(int i = 0 ; i < count_ ; i++)
        {
            switchTo(i) ;

            Color c = sensor_.getColor() ;
            ColorMatchResult res = matcher_.matchClosestColor(c) ;
            putDashboard("C" + i, DisplayType.Always, res.confidence);

            putDashboard("M-R-" + i, DisplayType.Always, res.color.red) ;
            putDashboard("M-G-" + i, DisplayType.Always, res.color.green) ;
            putDashboard("M-B-" + i, DisplayType.Always, res.color.blue) ;

            int prox = sensor_.getProximity() ;
            putDashboard("P" + i, DisplayType.Always, prox) ;
        }
    }

    private void init(int which) {
        switchTo(which) ;

        ColorSensorV3.ColorSensorResolution res = ColorSensorV3.ColorSensorResolution.kColorSensorRes16bit ;
        ColorSensorV3.ColorSensorMeasurementRate rate = ColorSensorV3.ColorSensorMeasurementRate.kColorRate100ms ;
        ColorSensorV3.GainFactor gain = ColorSensorV3.GainFactor.kGain18x ;
        sensor_.configureColorSensor(res, rate, gain) ;
    }
}
