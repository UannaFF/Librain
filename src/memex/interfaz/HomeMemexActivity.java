package memex.interfaz;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.os.Build;

public class HomeMemexActivity extends ActionBarActivity {
	ScrollView listaCompartidas, listaPopulares, listaRecientes;
	Button compart, recientes, populares;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_memex);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		listaCompartidas = (ScrollView) findViewById(R.id.compartidas);
		listaPopulares  = (ScrollView) findViewById(R.id.populares);
		listaRecientes  = (ScrollView) findViewById(R.id.recientes);
		
		compart = (Button) findViewById(R.id.invest_compartidas);
		recientes  = (Button) findViewById(R.id.invest_recientes);
		populares  = (Button) findViewById(R.id.invest_populares);
		compart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(listaCompartidas.getVisibility() != View.VISIBLE) {
            		if(listaPopulares.getVisibility() == View.VISIBLE) listaPopulares.setVisibility(View.GONE);
            		if(listaRecientes.getVisibility() == View.VISIBLE) listaRecientes.setVisibility(View.GONE);
            		listaCompartidas.setVisibility(View.VISIBLE);
            	} else {
            		listaCompartidas.setVisibility(View.GONE);
            	}
            }
        });
		recientes.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(listaRecientes.getVisibility() != View.VISIBLE) {
            		if(listaPopulares.getVisibility() == View.VISIBLE) listaPopulares.setVisibility(View.GONE);
            		if(listaCompartidas.getVisibility() == View.VISIBLE) listaCompartidas.setVisibility(View.GONE);
            		listaRecientes.setVisibility(View.VISIBLE);
            	} else {
            		listaRecientes.setVisibility(View.GONE);
            	}
            }
        });
		populares.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(listaPopulares.getVisibility() != View.VISIBLE) {
            		if(listaCompartidas.getVisibility() == View.VISIBLE) listaCompartidas.setVisibility(View.GONE);
            		if(listaRecientes.getVisibility() == View.VISIBLE) listaRecientes.setVisibility(View.GONE);
            		listaPopulares.setVisibility(View.VISIBLE);
            	} else {
            		listaPopulares.setVisibility(View.GONE);
            	}
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.home_memex, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	



	/*
	 @Override(non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		} else {
			Intent inte = new Intent(getApplicationContext(), PerfilActivity.class);
			startActivity(inte);
            finish();
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
			View rootView = inflater.inflate(R.layout.fragment_home_memex,
					container, false);
			return rootView;
		}
	}

}
