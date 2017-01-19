package es.telefonica.talentum.noteapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.telefonica.talentum.noteapp.model.Note;
import es.telefonica.talentum.noteapp.model.Notes;

public class NoteAdapter extends RecyclerView.Adapter<NoteRowViewHolder> { // Esta clase depentde de la lista de notas. Se inyeecta la dependendia.

    Notes notes; // Las notas se pueden pasar por genter o setter o por constructors. En este caso contructor
    LayoutInflater inflater;

    public NoteAdapter(Notes notes, Context context) {
        this.notes = notes;
        this.inflater = LayoutInflater.from(context); // From devuelve un layoutinflater
    }
    @Override
    public NoteRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {   // Se va a llamar cada vez que se pinte una vista
        View view = inflater.inflate(R.layout.row_note, parent, false);

        NoteRowViewHolder viewHolder = new NoteRowViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NoteRowViewHolder holder, int position) { // Se llama cada vez que se pinta una fila
        Note  note = notes.get(position);
        holder.setNote(note); // nota a pintar
    }

    @Override
    public int getItemCount() { // ¿Cuántos elementos hay en la lista de notas?
        return notes.count();
    }
}
