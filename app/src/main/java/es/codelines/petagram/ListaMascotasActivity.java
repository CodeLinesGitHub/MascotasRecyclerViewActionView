package es.codelines.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaMascotasActivity extends AppCompatActivity {

    private Toolbar toolbar;
    ArrayList<Mascota> mascota;
    private RecyclerView rvListaMascotas;
    private ImageButton imgBtnStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgBtnStar = (ImageButton) findViewById(R.id.imgBtnStar);
        imgBtnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaMascotasActivity.this, MascotasFavoritasActivity.class);
                startActivity(intent);
            }
        });

        rvListaMascotas = (RecyclerView) findViewById(R.id.rvListaMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuOpcion1:
                Toast.makeText(this, "Has pulsado la opción 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuOpcion2:
                Toast.makeText(this, "Has pulsado la opción 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public MascotaAdaptador adaptador;

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascota ,this);
        rvListaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascota = new ArrayList<>();

        mascota.add(new Mascota("Gato", R.drawable.gato, 3));
        mascota.add(new Mascota("Pajaro", R.drawable.pajaro, 2));
        mascota.add(new Mascota("Perro", R.drawable.perro, 3));
        mascota.add(new Mascota("Perro Asistencia", R.drawable.perroasistencia, 5));
        mascota.add(new Mascota("Perro y Gato", R.drawable.perrogato, 1));
        mascota.add(new Mascota("Pez", R.drawable.pez, 4));
        mascota.add(new Mascota("Reptil", R.drawable.reptil, 2));
        mascota.add(new Mascota("Pez Dorado", R.drawable.pez_oro, 7));

    }

    public void clickFloatingActionButtonCamera(View view){
        Toast.makeText(this, "Hacer una foto", Toast.LENGTH_SHORT).show();
    }
}
