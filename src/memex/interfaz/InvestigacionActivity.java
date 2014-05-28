package memex.interfaz;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.os.Build;

public class InvestigacionActivity extends ActionBarActivity {
	Button nodoP, filtro;
	ImageButton fav;
	LinearLayout linear;
	boolean favorit=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_investigacion);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		nodoP = (Button)findViewById(R.id.nodoPrincipal);
		nodoP.requestFocus();
		fav = (ImageButton)findViewById(R.id.imageButton1);
		fav.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(!favorit) {
            		fav.setImageResource(R.drawable.favorito_lleno);
            		favorit= !favorit;
            	} else {
            		fav.setImageResource(R.drawable.favorito_vacio82x79);
            		favorit= !favorit;
            	}
            }
        });
		
		filtro = (Button)findViewById(R.id.button1);
		linear = (LinearLayout)findViewById(R.id.filtLin);
		filtro.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(linear.getVisibility()!=View.VISIBLE) {
            		linear.setVisibility(View.VISIBLE);
            	} else {
            		linear.setVisibility(View.GONE);
            	}
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.investigacion, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		Intent inte;
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		} else if (id==R.id.home) {
			inte = new Intent(getApplicationContext(), HomeMemexActivity.class);
			startActivity(inte);
            finish();
		} else if (id==R.id.perfil) {
			inte = new Intent(getApplicationContext(), PerfilActivity.class);
			startActivity(inte);
            finish();			
		} else if(id == R.id.agregar) {
	    	final Dialog dialog = new Dialog(this);
	        dialog.setContentView(R.layout.dialog_articulo);
	        dialog.setTitle("AGREGAR ARCHIVO");
	        dialog.show();
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_investigacion,
					container, false);
			return rootView;
		}
	}

}
