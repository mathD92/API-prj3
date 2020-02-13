package com.feetconnect.Fragments


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.feetconnect.R
import kotlinx.android.synthetic.main.fragment_sensor.*

/**
 * A simple [Fragment] subclass.
 */
class SensorFragment : Fragment(), SensorEventListener {

    var sensor: Sensor? = null
    var sensor1: Sensor? = null
    var sensorManager: SensorManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sensor, container, false)

        sensorManager = getActivity()?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)
        sensor1 = sensorManager!!.getDefaultSensor(Sensor.TYPE_ORIENTATION)

        val title_sensor_acceleration: TextView = view.findViewById(R.id.title_sensor_acceleration)
        val title_sensor_orientation: TextView = view.findViewById(R.id.title_sensor_orientation)

        title_sensor_acceleration.setText("Sensor Acceleration Linear")
        title_sensor_orientation.setText("Sensor Orientation")

        return view
    }

    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this, sensor, 500000, 500000)
        sensorManager!!.registerListener(this, sensor1, 500000, 500000)
    }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.sensor.type === Sensor.TYPE_LINEAR_ACCELERATION ){
            sensor_acceleration_x.setText("X : " + event!!.values[0].toDouble().toString())
            sensor_acceleration_y.setText("Y : " + event.values[1].toDouble().toString())
            sensor_acceleration_z.setText("Z : " + event.values[2].toDouble().toString())
        }
        if (event!!.sensor.type === Sensor.TYPE_ORIENTATION){
            sensor_orientation_x.setText("X : " + event!!.values[0].toDouble().toString())
            sensor_orientation_y.setText("Y : " + event.values[1].toDouble().toString())
            sensor_orientation_z.setText("Z : " + event.values[2].toDouble().toString())
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }


}
