package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class VisuEmprunt extends AppCompatActivity {

    EditText designation;
    EditText nom;
    EditText prenom;
    EditText date;
    EditText description;
    EditText commentaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualiser_pret);

        Intent intentionRecu = getIntent();

        Item item = intentionRecu.getParcelableExtra("item");

        designation = findViewById(R.id.visu_designation);
        nom = findViewById(R.id.visu_nom);
        prenom = findViewById(R.id.visu_prenom);
        date = findViewById(R.id.visu_date);
        description = findViewById(R.id.visu_description);
        commentaire = findViewById(R.id.visu_commentaire);

        designation.setText(item.designation);
        nom.setText(item.nom);
        prenom.setText(item.prenom);
        date.setText(item.date);
        description.setText(item.description);
        commentaire.setText(item.commentaire);
    }
}
