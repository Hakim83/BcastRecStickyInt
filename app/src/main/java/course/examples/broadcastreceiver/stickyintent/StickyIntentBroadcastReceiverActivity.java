package course.examples.broadcastreceiver.stickyintent;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

// Note: Sticky Intents have been deprecated

public class StickyIntentBroadcastReceiverActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		final TextView currentStateView = (TextView) findViewById(R.id.level);

		registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {


					String age = "Reading taken recently";
					if (isInitialStickyBroadcast()) {
						age = "Reading may be stale";
					}

					currentStateView.setText("Current Battery Level:"
							+ String.valueOf(intent.getIntExtra(
									BatteryManager.EXTRA_LEVEL, -1))
							+ "\n" + age);
			}
		}, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
	}
}