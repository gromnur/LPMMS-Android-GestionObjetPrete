package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class ModifEmprunt extends AppCompatActivity {

    EditText designation;
    EditText nom;
    EditText prenom;
    EditText date;
    EditText description;
    EditText commentaire;
    private ImageView miniaturePhoto;

    private byte[] photo;

    GestionPretDAO bd;

    Item item;

    public static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifier_pret);

        Intent intentionRecu = getIntent();

        bd = GestionPretDAO.getInstanceDAO(this);

        String id = intentionRecu.getStringExtra("item");
        Log.println(Log.DEBUG, "ID", id);

        this.item = bd.findByIdPret(id);

        designation = findViewById(R.id.modif_designation);
        nom = findViewById(R.id.modif_nom);
        prenom = findViewById(R.id.modif_prenom);
        date = findViewById(R.id.modif_date);
        description = findViewById(R.id.modif_description);
        commentaire = findViewById(R.id.modif_commentaire);
        miniaturePhoto = findViewById(R.id.miniature_photo_modif);

        designation.setText(item.designation);
        nom.setText(item.nom);
        prenom.setText(item.prenom);
        date.setText(item.date);
        description.setText(item.description);
        commentaire.setText(item.commentaire);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
            photo = baos.toByteArray();
            miniaturePhoto.setImageBitmap(imageBitmap);
        }
    }

    public void clicSurCamera(View view) {
        Intent mediaChooser = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(mediaChooser, REQUEST_IMAGE_CAPTURE);
    }

    public void clicSurModifier(View view) {
        if (designation.getText().toString().length()==0 ||
                nom.getText().toString().length()==0 ||
                prenom.getText().toString().length()==0 ){
            Toast.makeText(this, "Les champs designation, nom ou prenom ne peuvent pas etre null", Toast.LENGTH_LONG).show();
        } else {
            // enregistrer dans la BDD
            bd.updatePret(item.getId(), designation.getText().toString(), description.getText().toString(), photo, nom.getText().toString(), prenom.getText().toString(), commentaire.getText().toString(), date.getText().toString());

            // revenir sur la premiere activité
            Intent retoutList= new Intent(ModifEmprunt.this, ListAccueil.class);
            startActivity(retoutList);
            finish();
        }

    }
}
