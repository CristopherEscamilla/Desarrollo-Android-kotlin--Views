package com.example.almacenamiento;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String url = "https://example.com/ejemplo.pdf";
        String filename = "myfile";
        File file = new File(this.getFilesDir(), filename);
        String string = "Hello world!";

        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



        File tempFile = getTempFile(this, url);
        String contenido = "Hola, esto es un ejemplo de contenido que se escribirá en el archivo temporal.";

        escribirEnArchivoTemporal(tempFile, contenido);

        File path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);

        Log.d("Debug",""+path);

        Bitmap imagenBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img); // Suponiendo que tienes una imagen en los recursos
        String nombreImagen = "mi_imagen.jpg"; // Nombre del archivo de imagen
        saveImageToExternalStorage(this, imagenBitmap, nombreImagen);
    }

    public File getTempFile(Context context, String url) {
        File file = null;
        try {
            String fileName = Uri.parse(url).getLastPathSegment();
            Log.d("Debug",""+fileName);
            file = File.createTempFile(fileName, null, context.getCacheDir());
        } catch (IOException e) {
            // Error while creating file
        }
        return file;
    }

    public void escribirEnArchivoTemporal(File archivoTemporal, String contenido) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal));
            writer.write(contenido);
            writer.close();
        } catch (IOException e) {
            // Manejo de errores
            e.printStackTrace();
        }
    }

    public static void saveImageToExternalStorage(Context context, Bitmap imageBitmap, String imageName) {
        // Verifica el estado del almacenamiento externo
        String estadoAlmacenamiento = Environment.getExternalStorageState();
        if (!estadoAlmacenamiento.equals(Environment.MEDIA_MOUNTED)) {
            // El almacenamiento externo no está disponible para escritura
            return;
        }

        // Obtiene el directorio de imágenes públicas del almacenamiento externo
        File directorioPictures = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        // Crea un nuevo archivo en el directorio de imágenes con el nombre especificado
        File archivoImagen = new File(directorioPictures, imageName);

        // Intenta guardar la imagen en el archivo
        try {
            FileOutputStream fos = new FileOutputStream(archivoImagen);
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos); // Comprime la imagen como JPEG con calidad máxima
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}