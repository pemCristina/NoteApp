package es.telefonica.talentum.noteapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment {

    private RecyclerView recyclerNotesView;

    public NoteListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_note_list, container, false);
        // Inflate the layout for this fragment
        recyclerNotesView = (RecyclerView) view.findViewById(R.id.fragment_note_list_note_list);
        recyclerNotesView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    public void setAdapter(NoteAdapter adapter) {
        recyclerNotesView.setAdapter(adapter);
    }
}
