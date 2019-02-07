package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AjoutEmprunt extends AppCompatActivity {

    private GestionPretDAO gestionPret;

    private ImageView miniaturePhoto;
    private EditText designation;
    private EditText description;
    private EditText nom;
    private EditText prenom;
    private EditText commentaire;
    private EditText date;
    public static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_pret);

        designation = findViewById(R.id.ajout_designation);
        description = findViewById(R.id.ajout_description);
        nom = findViewById(R.id.ajout_nom);
        prenom = findViewById(R.id.ajout_prenom);
        commentaire = findViewById(R.id.ajout_commentaire);
        date = findViewById(R.id.ajout_date);
        miniaturePhoto = findViewById(R.id.miniature_photo);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date.setText(simpleDateFormat.format(new Date()));
        gestionPret = gestionPret.getInstanceDAO(this);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            miniaturePhoto.setImageBitmap(imageBitmap);
        }
    }

    public void clicSurCamera(View view) {
        Intent mediaChooser = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(mediaChooser, REQUEST_IMAGE_CAPTURE);
    }

    public void clicSurValider(View view) {
        if (designation.getText().toString().length()==0 ||
            nom.getText().toString().length()==0 ||
            prenom.getText().toString().length()==0 ){
            Toast.makeText(this, "Les champs designation, nom ou prenom ne peuvent pas etre null", Toast.LENGTH_LONG).show();
        } else {
            // enregistrer dans la BDD
            gestionPret.createPret(designation.toString(), description.toString(), null, nom.toString(), prenom.toString(), commentaire.toString());

            // revenir sur la premiere activité
            Intent retoutList= new Intent(AjoutEmprunt.this, ListAccueil.class);
            startActivity(retoutList);
            finish();
        }

    }
}