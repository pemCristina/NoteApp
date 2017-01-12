package es.telefonica.talentum.noteapp.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import es.telefonica.talentum.noteapp.R;

public class NoteDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
    }
}
