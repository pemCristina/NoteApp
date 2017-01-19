package es.telefonica.talentum.noteapp.model;

import java.util.LinkedList;
import java.util.List;

public class Notes implements Enumerable<Note> {

    private List<Note> noteList = new LinkedList<>();

    @Override
    public int count() {
        return noteList.size();
    }

    @Override
    public void add(Note element) {
        noteList.add(element);
    }

    @Override
    public void remove(int index) {
        noteList.remove(index);
    }

    @Override
    public void update(int index, Note newElement) {
        noteList.set(index,newElement);
    }

    @Override
    public List<Note> getAll() {
        return noteList;
    }

    public Note get(int i) {
        return noteList.get(i);
    }
}
