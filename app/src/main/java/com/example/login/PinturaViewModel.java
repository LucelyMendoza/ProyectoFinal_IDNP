package com.example.login;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.login.Entity.Autor;
import com.example.login.Entity.Galeria;
import com.example.login.Entity.Pintura;
import com.example.login.Room.AutorDao;
import com.example.login.Room.GaleriaDao;
import com.example.login.Room.PinturaDao;
import com.example.login.Room.PinturaDatabase;

public class PinturaViewModel extends AndroidViewModel {
    private PinturaDao pinturaDao;
    private AutorDao autorDao;
    private GaleriaDao galeriaDao;

    public PinturaViewModel(Application application) {
        super(application);
        PinturaDatabase database = Room.databaseBuilder(application,
                PinturaDatabase.class, "pintura_database").build();
        pinturaDao = database.pinturaDao();
        autorDao = database.autorDao();
        galeriaDao = database.galeriaDao();
    }

    // Método para insertar un Autor
    public void insertAutor(Autor autor) {
        new InsertAutorAsyncTask(autorDao).execute(autor);
    }

    // Método para insertar una Galeria
    public void insertGaleria(Galeria galeria) {
        new InsertGaleriaAsyncTask(galeriaDao).execute(galeria);
    }
    public void insert(Pintura pintura) {
        new InsertPinturaAsyncTask(pinturaDao, autorDao, galeriaDao).execute(pintura);
    }

    private static class InsertAutorAsyncTask extends AsyncTask<Autor, Void, Void> {
        private AutorDao autorDao;

        private InsertAutorAsyncTask(AutorDao autorDao) {
            this.autorDao = autorDao;
        }

        @Override
        protected Void doInBackground(Autor... autores) {
            autorDao.insert(autores[0]);
            return null;
        }
    }

    // AsyncTask para insertar una Galeria
    private static class InsertGaleriaAsyncTask extends AsyncTask<Galeria, Void, Void> {
        private GaleriaDao galeriaDao;

        private InsertGaleriaAsyncTask(GaleriaDao galeriaDao) {
            this.galeriaDao = galeriaDao;
        }

        @Override
        protected Void doInBackground(Galeria... galerias) {
            galeriaDao.insert(galerias[0]);
            return null;
        }
    }

    private static class InsertPinturaAsyncTask extends AsyncTask<Pintura, Void, Void> {
        private PinturaDao pinturaDao;
        private AutorDao autorDao;
        private GaleriaDao galeriaDao;

        private InsertPinturaAsyncTask(PinturaDao pinturaDao, AutorDao autorDao, GaleriaDao galeriaDao) {
            this.pinturaDao = pinturaDao;
            this.autorDao = autorDao;
            this.galeriaDao = galeriaDao;
        }

        @Override
        protected Void doInBackground(Pintura... pinturas) {
            Pintura pintura = pinturas[0];

            Autor autor = autorDao.getByName(pintura.getArtista());
            Galeria galeria = galeriaDao.getByName(pintura.getGaleria());

            if (autor != null && galeria != null) {
                pinturaDao.insert(pintura);
            } else {
                Log.e("PinturaViewModel", "Foreign key constraint failed: autor or galeria does not exist.");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.d("PinturaViewModel", "Pintura insertada correctamente.");
        }
    }


}

