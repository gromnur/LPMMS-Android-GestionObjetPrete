package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

public class VisuEmprunt extends AppCompatActivity {

    EditText designation;
    EditText nom;
    EditText prenom;
    EditText date;
    EditText description;
    EditText commentaire;

    private ImageView miniaturePhoto;

    GestionPretDAO bd;

    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualiser_pret);

        Intent intentionRecu = getIntent();

        bd = GestionPretDAO.getInstanceDAO(this);

        String id = intentionRecu.getStringExtra("item");
        Log.println(Log.DEBUG, "ID", id);

        this.item = bd.findByIdPret(id);

        designation = findViewById(R.id.visu_designation);
        nom = findViewById(R.id.visu_nom);
        prenom = findViewById(R.id.visu_prenom);
        date = findViewById(R.id.visu_date);
        description = findViewById(R.id.visu_description);
        commentaire = findViewById(R.id.visu_commentaire);
        miniaturePhoto = findViewById(R.id.miniature_photo_visu);

        designation.setText(item.designation);
        nom.setText(item.nom);
        prenom.setText(item.prenom);
        date.setText(item.date);
        description.setText(item.description);
        commentaire.setText(item.commentaire);
        miniaturePhoto.setImageBitmap(BitmapFactory.decodeByteArray(item.getThumbnail(), 0, item.getThumbnail().length));
    }
}
