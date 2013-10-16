package com.example.myaidl;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	private IMyService mMyService = null;
	private Button btnInvokeAIDLService;
	private Button btnBindAIDLService;
	private TextView textView;
	public static int mTest;
	private ServiceConnection serviceConnection = new ServiceConnection(){

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			mMyService = IMyService.Stub.asInterface(service);
			btnInvokeAIDLService.setEnabled(true);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnInvokeAIDLService = (Button)findViewById(R.id.btn_invoke);
		btnBindAIDLService = (Button)findViewById(R.id.btn_bind);
		btnInvokeAIDLService.setEnabled(false);
		textView = (TextView)findViewById(R.id.textview);
		mTest = 2;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btn_bind:
			bindService(new Intent("com.zk.aidl.IMyService"), serviceConnection, Context.BIND_AUTO_CREATE);
			break;
		case R.id.btn_invoke:
			try{
				textView.setText(mMyService.getValue()+" src="+mTest);
			}catch(Exception e){
				
			}
			break;
		}
	}

}
