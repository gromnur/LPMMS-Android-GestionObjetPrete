package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class RechercheDate extends AppCompatActivity {

    EditText champRecherche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche_date);

        champRecherche = findViewById(R.id.saisie_date);
    }


    public void clicSurValider(View view) {
        String laDate = champRecherche.getText().toString();

        Intent intentionRetour = new Intent();
        intentionRetour.putExtra("Date", laDate);
        setResult(Activity.RESULT_OK, intentionRetour);
        finish();
    }
}
