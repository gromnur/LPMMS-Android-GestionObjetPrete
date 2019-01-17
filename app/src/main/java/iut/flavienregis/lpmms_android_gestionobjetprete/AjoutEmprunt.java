package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class AjoutEmprunt extends AppCompatActivity {

    private ImageView miniaturePhoto;

    public static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_pret);

        miniaturePhoto = findViewById(R.id.miniature_photo);

        Intent mediaChooser = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(mediaChooser, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            miniaturePhoto.setImageBitmap(imageBitmap);
        }
    }
}
