package es.pue.android.calllog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("RECEIVER", "Call event");
        Bundle data = intent.getExtras();
        if (data != null) {
            String state = data.getString(TelephonyManager.EXTRA_STATE);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                String phoneNumber = data.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.i("INCOMING_NUMBER", phoneNumber);
            }
        }
    }
}
