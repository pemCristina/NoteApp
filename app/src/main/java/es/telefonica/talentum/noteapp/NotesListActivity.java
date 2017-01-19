package es.telefonica.talentum.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import es.telefonica.talentum.noteapp.model.Note;
import es.telefonica.talentum.noteapp.model.NoteDetailActivity;
import es.telefonica.talentum.noteapp.model.Notes;

public class NotesListActivity extends AppCompatActivity {

    Notes listOfNotes = new Notes();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        // PASO 1 DE RECYCLERVIEW
        NoteListFragment noteListFragment = (NoteListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_note_list);   //getSupportFragmentManager Permite acceder a los fragmentos que están e las actividades

        // PASO $ DE RECYCLERVIEW. SE han añadido datos
        for (int i = 0; i < 20; i++) {
            Note note = new Note("Note " + i);
            note.setText("Noticia super importante " + i);
            listOfNotes.add(note);
        }
        // Conectar el adaptador con la lista
        NoteAdapter adapter = new NoteAdapter(listOfNotes, this);
        noteListFragment.setAdapter(adapter);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
// Android considera un giro de la pantalla como un cambio de configuración. Los cambios en el editText se pierden (ciclo de vida de las actividades
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_main_action_add_note) {
            Intent i = new Intent(NotesListActivity.this, NoteDetailActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
