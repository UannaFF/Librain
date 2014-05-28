package memex.interfaz;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.os.Build;

public class ArticuloActivity extends ActionBarActivity {
	Button irInvestigacion, lineaHandle;
	ScrollView s1, s2, s3;
	LinearLayout relacion, lin1, lin2, lin3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_articulo);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		//Manejando cambio a la investigacion.
		irInvestigacion = (Button)findViewById(R.id.lineaHandleIvestigacion);
		irInvestigacion.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
    			Intent inte = new Intent(getApplicationContext(), InvestigacionActivity.class);
    			startActivity(inte);
                finish();
            }
        });
		
		//Manejando drawer de lado izquierdo
		lineaHandle = (Button)findViewById(R.id.lineaHandle);
		relacion = (LinearLayout)findViewById(R.id.relacionado);
		lineaHandle.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(relacion.getVisibility()!= View.VISIBLE) {
            		relacion.setVisibility(View.VISIBLE);
            	} else {
            		relacion.setVisibility(View.GONE);
            	}
            }
        });
		
		//Manejando movimiento dentro del drawer izquierdo
		lin1 = (LinearLayout)findViewById(R.id.relacionadoEnlaces);
		s1 = (ScrollView)findViewById(R.id.scrollEnlaces);
		lin2 = (LinearLayout)findViewById(R.id.relacionadoInvest);
		s2 = (ScrollView)findViewById(R.id.scrollInvest);
		lin3 = (LinearLayout)findViewById(R.id.relacionadoRela);
		s3 = (ScrollView)findViewById(R.id.scrollRelacion);
		lin1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(s1.getVisibility()!=View.VISIBLE) {
            		if(s2.getVisibility()== View.VISIBLE) s2.setVisibility(View.GONE);
            		if(s3.getVisibility()== View.VISIBLE) s3.setVisibility(View.GONE);
            		s1.setVisibility(View.VISIBLE);
            	} else {
            		s1.setVisibility(View.GONE);
            	}
            }
        });
		
		lin2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(s2.getVisibility()!=View.VISIBLE) {
            		if(s1.getVisibility()== View.VISIBLE) s1.setVisibility(View.GONE);
            		if(s3.getVisibility()== View.VISIBLE) s3.setVisibility(View.GONE);
            		s2.setVisibility(View.VISIBLE);
            	} else {
            		s2.setVisibility(View.GONE);
            	}
            }
        });
		
		lin3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(s3.getVisibility()!=View.VISIBLE) {
            		if(s2.getVisibility()== View.VISIBLE) s2.setVisibility(View.GONE);
            		if(s1.getVisibility()== View.VISIBLE) s1.setVisibility(View.GONE);
            		s3.setVisibility(View.VISIBLE);
            	} else {
            		s3.setVisibility(View.GONE);
            	}
            }
        });
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.articulo, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_articulo,
					container, false);
			return rootView;
		}
	}

}
