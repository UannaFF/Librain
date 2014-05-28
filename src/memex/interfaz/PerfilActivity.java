package memex.interfaz;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Build;

public class PerfilActivity extends ActionBarActivity {
	private HorizontalScrollView horizontalScrollViewfav, horizontalScrollViewInvest, horizontalScrollViewartic, horizontalScrollView1;
	private ImageButton favoritos, historial, misinvestigaciones, misarticulos;
	private String[] amigos = { "Ryan Gossling", "Rupert Green", "Anna Gomez", "Francisco Gamundi",
			"Erik Dell", "Bill Clinton", "Rafael Correa", "Ellen Page", "Emma Watson", "Marion Cotillard" };
	private ListView lv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		horizontalScrollViewfav = (HorizontalScrollView) findViewById(R.id.horizontalScrollViewfav);
		horizontalScrollViewInvest = (HorizontalScrollView) findViewById(R.id.horizontalScrollViewInvest);
		horizontalScrollView1 = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
		horizontalScrollViewartic = (HorizontalScrollView) findViewById(R.id.horizontalScrollViewartic);
		
		favoritos = (ImageButton) findViewById(R.id.favoritos);
		historial  = (ImageButton) findViewById(R.id.historial);
		misinvestigaciones  = (ImageButton) findViewById(R.id.misinvestigaciones);
		misarticulos  = (ImageButton) findViewById(R.id.misarticulos);
		
		favoritos.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(horizontalScrollViewfav.getVisibility() != View.VISIBLE) {
            		if(horizontalScrollView1.getVisibility() == View.VISIBLE) horizontalScrollView1.setVisibility(View.GONE);
            		horizontalScrollViewfav.setVisibility(View.VISIBLE);
            	} else {
            		horizontalScrollViewfav.setVisibility(View.GONE);
            	}
            }
        });
		historial.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(horizontalScrollView1.getVisibility() != View.VISIBLE) {
            		if(horizontalScrollViewfav.getVisibility() == View.VISIBLE) horizontalScrollViewfav.setVisibility(View.GONE);
            		horizontalScrollView1.setVisibility(View.VISIBLE);
            	} else {
            		horizontalScrollView1.setVisibility(View.GONE);
            	}
            }
        });
		misinvestigaciones.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(horizontalScrollViewInvest.getVisibility() != View.VISIBLE) {
            		if(horizontalScrollViewartic.getVisibility() == View.VISIBLE) horizontalScrollViewartic.setVisibility(View.GONE);
            		horizontalScrollViewInvest.setVisibility(View.VISIBLE);
            	} else {
            		horizontalScrollViewInvest.setVisibility(View.GONE);
            	}
            }
        });
		
		misarticulos.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(horizontalScrollViewartic.getVisibility() != View.VISIBLE) {
            		if(horizontalScrollViewInvest.getVisibility() == View.VISIBLE) horizontalScrollViewInvest.setVisibility(View.GONE);
            		horizontalScrollViewartic.setVisibility(View.VISIBLE);
            	} else {
            		horizontalScrollViewartic.setVisibility(View.GONE);
            	}
            }
        });
		
		//Funcionalidad de los amigos
        lv1 =(ListView)findViewById(R.id.listAmigos);     
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, amigos);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
                //tv1.setText("Población de "+ lv1.getItemAtPosition(posicion) + " es "+ habitantes[posicion]);
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.perfil, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		} else if(id == R.id.home) {
			Intent inte = new Intent(getApplicationContext(), HomeMemexActivity.class);
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
			View rootView = inflater.inflate(R.layout.fragment_perfil,
					container, false);
			return rootView;
		}
	}

}
