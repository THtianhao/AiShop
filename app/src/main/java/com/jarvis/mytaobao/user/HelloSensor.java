package com.jarvis.mytaobao.user;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.jarvis.mytaobaotest.R;
import com.zdp.aseo.content.AseoZdpAseo;


public class HelloSensor extends Activity {       
    Sensor sensor ;       
    private float x, y, z;       

    @SuppressWarnings("deprecation")
	@Override       
    public void onCreate(Bundle savedInstanceState) {       
        super.onCreate(savedInstanceState);       
        setContentView(R.layout.hellosener);       
       
        //׼UI齨
        final TextView tx1 = (TextView) findViewById(R.id.textView1);       
       
        //ϵͳлô
        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);       
       
        //лȫĴб
        List<Sensor> allSensors = sm.getSensorList(Sensor.TYPE_ALL);       
		AseoZdpAseo.initType(this, AseoZdpAseo.INSERT_TYPE);
        //жٸ
        tx1.setText("ֻ" + allSensors.size() + "Ƿֱǣ\n");
       
        //ÿľ
        for (Sensor s : allSensors) {       
       
            String tempString = "\n" + "  豸ƣ" + s.getName() + "\n" + "  豸汾" + s.getVersion() + "\n" + "  Ӧ̣"
                    + s.getVendor() + "\n";       
       
            switch (s.getType()) {       
            case Sensor.TYPE_ACCELEROMETER:       
                tx1.setText(tx1.getText().toString() + s.getType() + " ٶȴaccelerometer" + tempString);
                break;       
            case Sensor.TYPE_GRAVITY:       
                tx1.setText(tx1.getText().toString() + s.getType() + " gravity API 9" + tempString);
                break;       
            case Sensor.TYPE_GYROSCOPE:       
                tx1.setText(tx1.getText().toString() + s.getType() + " Ǵgyroscope" + tempString);
                break;       
            case Sensor.TYPE_LIGHT:       
                tx1.setText(tx1.getText().toString() + s.getType() + " ߴlight" + tempString);
                break;       
            case Sensor.TYPE_LINEAR_ACCELERATION:       
                tx1.setText(tx1.getText().toString() + s.getType() + " ԼLINEAR_ACCELERATION API 9" + tempString);
                break;       
            case Sensor.TYPE_MAGNETIC_FIELD:       
                tx1.setText(tx1.getText().toString() + s.getType() + " ųmagnetic field" + tempString);
                break;       
            case Sensor.TYPE_ORIENTATION:       
                tx1.setText(tx1.getText().toString() + s.getType() + " 򴫸orientation" + tempString);
                break;       
            case Sensor.TYPE_PRESSURE:       
                tx1.setText(tx1.getText().toString() + s.getType() + " ѹpressure" + tempString);
                break;       
            case Sensor.TYPE_PROXIMITY:       
                tx1.setText(tx1.getText().toString() + s.getType() + " 봫proximity" + tempString);
                break;       
            case Sensor.TYPE_ROTATION_VECTOR:       
                tx1.setText(tx1.getText().toString() + s.getType() + " תROTATION" + tempString);
                break;       
            case Sensor.TYPE_TEMPERATURE:       
                tx1.setText(tx1.getText().toString() + s.getType() + " ¶ȴtemperature" + tempString);
                break;       
            default:       
                tx1.setText(tx1.getText().toString() + s.getType() + " δ֪" + tempString);
                break;       
            }       
        }       
               
        //titleı仯
        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);       
        SensorEventListener lsn = new SensorEventListener() {       
           
			public void onSensorChanged(SensorEvent e) {       
                x = e.values[SensorManager.DATA_X];       
                y = e.values[SensorManager.DATA_Y];       
                z = e.values[SensorManager.DATA_Z];       
                setTitle("x=" + (int) x + "," + "y=" + (int) y + "," + "z="+ (int) z);       
            }       
       
            public void onAccuracyChanged(Sensor s, int accuracy) {       
            }       
        };       
        // עlistenerǼľ
        sm.registerListener(lsn, sensor, SensorManager.SENSOR_DELAY_GAME);       
       
    }       
}  