package es.telefonica.talentum.noteapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import es.telefonica.talentum.noteapp.model.Note;

public class NoteRowViewHolder extends RecyclerView.ViewHolder {

    private TextView noteTitleText; // son las columnas row
    private TextView noteTextText;

    private Note note;

    public NoteRowViewHolder(View itemView) {
        super(itemView);
        noteTitleText = (TextView) itemView.findViewById(R.id.row_note_note_title);
        noteTextText = (TextView) itemView.findViewById(R.id.row_note_note_text);
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
        noteTitleText.setText(note.getTitle());
        noteTextText.setText(note.getText());
    }
}
