package es.telefonica.talentum.noteapp.model;

import java.util.List;

// Interfaz = Lista de métodos
/*public interface Enumerable {
    int count();
    void add(Note element);
    void remove(int index);
    void update(int index, Note newElement);
    List<Note> getAll();
}*/
// Enumerable que funciona con cualquier cosa (genericos/comodines) t(de tipo)
public interface Enumerable <T>{
    int count();
    void add(T element);
    void remove(int index);
    void update(int index, T newElement);
    List<Note> getAll();
}
