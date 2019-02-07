package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;


public class ListAccueil extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {


    private ArrayList<String> liste;

    private static final String TAG = ListAccueil.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<Item> cartList;
    private CartListAdapter mAdapter;
    private CoordinatorLayout coordinatorLayout;
    private ArrayAdapter adaptateur;

    public final static int RECHERCHE_DATE = 0;
    public final static int RECHERCHE_MOT = 1;
    public final static int RECHERCHE_PERSONNE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_accueil);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        recyclerView = findViewById(R.id.recycler_view);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        cartList = new ArrayList<>();

        // on recupère les element de la table pour les mettre dans la liste
        cartList.add(new Item(1,"tele","ma tele","10/06/2017","","GOSSMANN","Thommas","Rend le moi vite"));
        cartList.add(new Item(1,"tele","ma tele","10/06/2017",null,"GOSSMANN","Thommas","Rend le moi vite"));
        cartList.add(new Item(1,"tele","ma tele","10/06/2017",null,"GOSSMANN","Thommas","Rend le moi vite"));
        cartList.add(new Item(1,"tele","ma tele","10/06/2017",null,"GOSSMANN","Thommas","Rend le moi vite"));
        cartList.add(new Item(1,"tele","ma tele","10/06/2017",null,"GOSSMANN","Thommas","Rend le moi vite"));

        mAdapter = new CartListAdapter(this, cartList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        // adding item touch helper
        // only ItemTouchHelper.LEFT added to detect Right to Left swipe
        // if you want both Right -> Left and Left -> Right
        // add pass ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT as param
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
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
                Intent intention = new Intent(ListAccueil.this, AjoutEmprunt.class);
                startActivity(intention);
                break;
            case R.id.recherche_personne:
                Intent intention2 = new Intent(ListAccueil.this, RecherchePersonne.class);
                startActivityForResult(intention2, RECHERCHE_PERSONNE);
                break;
            case R.id.recherche_mot:
                Intent intention3 = new Intent(ListAccueil.this, RechercheMot.class);
                startActivityForResult(intention3, RECHERCHE_MOT);
                break;
            case R.id.recherche_date:
                Intent intention4 = new Intent(ListAccueil.this, RechercheDate.class);
                startActivityForResult(intention4, RECHERCHE_DATE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * callback when recycler view is swiped
     * item will be removed on swiped
     * undo option will be provided in snackbar to restore the item
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof CartListAdapter.MyViewHolder) {
            // get the removed item name to display it in snack bar
            String name = cartList.get(viewHolder.getAdapterPosition()).getDesignation();

            // backup of removed item for undo purpose
            final Item deletedItem = cartList.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            // remove the item from recycler view
            mAdapter.removeItem(viewHolder.getAdapterPosition());

            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Le prêt de \"" + name + "\" a été supprimé !", Snackbar.LENGTH_LONG);
            snackbar.setAction("Annuler", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    mAdapter.restoreItem(deletedItem, deletedIndex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }
    }

    protected void onActivityResult(int codeRequete, int codeResultat, Intent intention){
        if(codeRequete == RECHERCHE_DATE){
            if(codeResultat == Activity.RESULT_OK){

            }
        }
        if(codeRequete == RECHERCHE_MOT){
            if(codeResultat == Activity.RESULT_OK){

            }
        }
        if(codeRequete == RECHERCHE_PERSONNE){
            if(codeResultat == Activity.RESULT_OK){

            }
        }
    }

}
