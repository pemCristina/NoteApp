package es.telefonica.talentum.noteapp;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteDetailFragment extends Fragment {
    EditText titleText;
    EditText descriptionText;

    public NoteDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note_detail, container, false);

        titleText = (EditText) view.findViewById(R.id.fragment_note_details_title_text);
        descriptionText = (EditText) view.findViewById(R.id.fragment_note_details_description_text);

        return view;


    }

    @Override
    public void onPause() {
        super.onPause();
        // save all from screen to disk: fragment is going to ve destroyed
        saveAllDataToDisk();
    }

    @Override
    public void onResume() {
        super.onResume();
        // load data fo show on screen (if any)
        loadAllDataFromDisk();

    }
        // en la actividad no está garantizado que se llame. Pero para fragmento si
    @Override
    public void onDestroy() {
        super.onDestroy();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext()); // Acceso al fichero de preferencias. Si no existe lo crea
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("NOTE_TITLE");
        editor.remove("NOTE_DESCRIPTION");
        editor.apply();
    }

    // Ficheros de preferencia. Aquí usarlo para guardar datos temporales (shared preferences)
    private void saveAllDataToDisk() {
        // abrir fichero para escribir
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext()); // Acceso de solo lectura
        SharedPreferences.Editor editor = preferences.edit();
        // leer lo escrito en pantalla
        String title = titleText.getText().toString();
        String description = descriptionText.getText().toString();  // toString necesario porque getText devue editable
        // grabar en fichero
        editor.putString("NOTE_TITLE", title);
        editor.putString("NOTE_DESCRIPTION", description);

        editor.apply(); // La información se graba en un buffer y cada cierto tiempo se vuelca. Con apply se graba del tiron. Lanza una tarrea que graba el fichero
    }

    private void loadAllDataFromDisk() {
        //Abrir fichero
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext()); // Acceso al fichero de preferencias. Si no existe lo crea
        // leer
        String noteTitle = preferences.getString("NOTE_TITLE", ""); // Lee si existe algo con la clave. Recibe: clave y valor por defecto (si no hay nada)
        String noteDescription = preferences.getString("NOTE_DESCRIPTION", "");
        // guardar
        titleText.setText(noteTitle);
        descriptionText.setText(noteDescription);
        // Cuando se vuelca se borra o si no se queda para siempre. Funcionalidad en onDestroy

    }
}
