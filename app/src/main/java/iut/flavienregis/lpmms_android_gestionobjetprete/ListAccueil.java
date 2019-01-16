package iut.flavienregis.lpmms_android_gestionobjetprete;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListAccueil extends AppCompatActivity {

    private ArrayList<String> liste;

    private ArrayAdapter<String> adaptateur;

    private ListView listePret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        listePret = findViewById(R.id.liste_pret);

        liste = new ArrayList<>();

        adaptateur = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, liste);

        listePret.setAdapter(adaptateur);

        registerForContextMenu(listePret);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        new MenuInflater(this).inflate(R.menu.menu_contextuel, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo information = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch(item.getItemId()){
            case R.id.visualiser_pret :
                break;
            case R.id.modifier_pret :
                break;
            case R.id.supprimer_pret :
                adaptateur.remove(liste.get(information.position));
                break;
            case R.id.annuler :
                break;
        }
        return (super.onContextItemSelected(item));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option_pret, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.ajout_pret:
                // Lancer l'activité
                break;
            case R.id.recherche_personne:
                break;
            case R.id.recherche_mot:
                break;
            case R.id.recherche_date:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
