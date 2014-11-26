package com.ualberta.team17;

import android.app.Application;
import android.content.res.Resources;

import com.ualberta.team17.controller.QAController;
import com.ualberta.team17.datamanager.DataManager;
import com.ualberta.team17.datamanager.LocalDataManager;
import com.ualberta.team17.datamanager.NetworkDataManager;

public class MoqaApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();

		// Make local data manager, and set the data to the test data set
		LocalDataManager localDataManager = new LocalDataManager(getApplicationContext());
		
		// Make net data manager
		Resources resources = getResources();
		NetworkDataManager netDataManager = new NetworkDataManager(
				resources.getString(R.string.esProductionServer),
				resources.getString(R.string.esProductionIndex));
		
		// Make the manager
		DataManager dataManager = new DataManager(getApplicationContext(), localDataManager, netDataManager);

		// Finally instantiate the controller
		new QAController(dataManager);
	}
}
