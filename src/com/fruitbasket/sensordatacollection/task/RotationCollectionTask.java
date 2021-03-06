package com.fruitbasket.sensordatacollection.task;

import java.io.IOException;

import com.fruitbasket.sensordatacollection.Condition;
import com.fruitbasket.sensordatacollection.sensor.RotationSensor;
import com.fruitbasket.sensordatacollection.utilities.ExcelProcessor;

public class RotationCollectionTask implements Runnable {

	private RotationSensor[] rotationSensorDatas;
	private int length=0;//数组中有效数据的长度
	
	public RotationCollectionTask(RotationSensor[] rotationSensorDatas,int length){
		this.rotationSensorDatas=RotationSensor.objectArrayDeepCopyOf(rotationSensorDatas, length);
		this.length=length;
	}
	
	@Override
	public void run() {
		try {
			ExcelProcessor.appendDataQuickly(Condition.ROTATION_EXCEL, rotationSensorDatas,length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
