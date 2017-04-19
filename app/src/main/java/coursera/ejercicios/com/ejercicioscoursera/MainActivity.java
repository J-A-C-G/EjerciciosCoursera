package coursera.ejercicios.com.ejercicioscoursera;

import android.database.DataSetObserver;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout refresh;
    private ListView listView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFab();
        accionMyBotton();

        refresh=(SwipeRefreshLayout)findViewById(R.id.refresh);
        listView=(ListView)findViewById(R.id.lvRefresh);
        String[]planetasArray=getResources().getStringArray(R.array.planeta);
        listView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,planetasArray));
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });

    }

    public void refrescandoContenido(){
        String[]planetasArray=getResources().getStringArray(R.array.planeta);
        listView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,planetasArray));
        refresh.setRefreshing(false);
    }

    public void agregarFab(){
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje),Toast.LENGTH_SHORT).show();
                Snackbar.make(v,getResources().getString(R.string.mensaje),Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR","Click en Snackbar");
                            }
                        })
                        .show();
            }
        });
    }

    public void accionMyBotton(){
        Button myBoton = (Button)findViewById(R.id.btnSaludo);
        myBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Meclickiastes",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
