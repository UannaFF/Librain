package memex.interfaz;



import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;
import android.view.View.OnClickListener;

public class HomeMemexActivity extends ActionBarActivity {
	ScrollView listaCompartidas, listaPopulares, listaRecientes;
	Button compart, recientes, populares;
	TextView textoZ;
	LinearLayout enlace;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_memex);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		textoZ = (TextView) findViewById(R.id.textoZelda);
		textoZ.requestFocus();
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
		enlace = (LinearLayout)findViewById(R.id.linearLayoutGrid2);
		//Estableciendo click para el enlace
        enlace.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
    			Intent inte = new Intent(getApplicationContext(), ArticuloActivity.class);
    			startActivity(inte);
                finish();
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
		} else if(id==R.id.perfil){
			Intent inte = new Intent(getApplicationContext(), PerfilActivity.class);
			startActivity(inte);
            finish();
		} else if(id == R.id.agregar) {
	    	final Dialog dialog = new Dialog(this);
	        dialog.setContentView(R.layout.dialog_articulo);
	        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
	        lp.copyFrom(dialog.getWindow().getAttributes());
	        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
	        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
	        dialog.setTitle("AGREGAR ARCHIVO");
	        //Acci�n de aceptar y cancelar
	        dialog.findViewById(R.id.aceptarbutton).setOnClickListener(new Button.OnClickListener(){
	            @Override
	            public void onClick(View v) {
	            	//Poner set view visible
	            	Toast.makeText(getApplicationContext(), "Se ha agregado su art�culo", Toast.LENGTH_SHORT).show();
	            	dialog.dismiss();
	            }
	        });
	        
	        dialog.findViewById(R.id.cancelarbutton).setOnClickListener(new Button.OnClickListener(){
	            @Override
	            public void onClick(View v) {
	            	dialog.dismiss();
	            }
	        });
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
			View rootView = inflater.inflate(R.layout.fragment_home_memex,
					container, false);
			return rootView;
		}
	}

}
