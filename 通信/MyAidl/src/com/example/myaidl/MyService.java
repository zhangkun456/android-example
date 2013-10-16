package com.example.myaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {

	public class MyServiceImpl extends IMyService.Stub{

		@Override
		public String getValue() throws RemoteException {
			// TODO Auto-generated method stub
			return "zk test" + MainActivity.mTest;
		}
		
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return new MyServiceImpl();
	}

}
