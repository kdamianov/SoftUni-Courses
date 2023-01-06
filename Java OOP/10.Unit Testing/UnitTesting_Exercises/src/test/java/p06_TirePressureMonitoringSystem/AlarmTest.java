package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class AlarmTest {
    private static final double LOW_PRESSURE_VALUE = 14.0;
    private static final double HIGH_PRESSURE_VALUE = 25.0;
    private static final double NORMAL_PRESSURE_VALUE = 20.0;
    private Alarm alarm;
    private Sensor sensor;

    @Before
    public void prepare(){
        sensor = Mockito.mock(Sensor.class);
        //mock-ваме, тк искаме определени стойности,
        //за да видим дали работи, а в Sensor класа има random метод за подаване на такива
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmShouldBeOnBecauseOfLowPressure(){
        when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_VALUE);

        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOnBecauseOfHighPressure(){
        when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_VALUE);

        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOff(){
        when(sensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE_VALUE);

        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

}