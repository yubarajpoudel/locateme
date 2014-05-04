package yuvi.first.locatesme;

import android.app.Activity;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {
	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		setupmap();
	}

	private void setupmap() {
		// enable mylocation layer in map
		map.setMyLocationEnabled(true);

		// get location manager from the system service
		LocationManager locationmanager = (LocationManager) getSystemService(LOCATION_SERVICE);
		// create the criteria object to retrieve provider
		Criteria criteria = new Criteria();
		// get the name of the best provider
		String provider = locationmanager.getBestProvider(criteria, true);
		Location mylocation = locationmanager.getLastKnownLocation(provider);
		map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		// get the latitude
		Double latitude = mylocation.getLatitude();
		Double longitude = mylocation.getLongitude();
		LatLng latlng = new LatLng(longitude, latitude);
		map.moveCamera(CameraUpdateFactory.newLatLng(latlng));
		map.animateCamera(CameraUpdateFactory.zoomTo(2));
		map.addMarker(new MarkerOptions().position(
				new LatLng(latitude, longitude)).title("i am here"));

	}

	public void linkme(View view) {
		Intent intent = new Intent(this, me.class);

		String links = "https://www.facebook.com/yubaraj.poudel.1";
		intent.putExtra("link", links);
		startActivity(intent);
	}

}
