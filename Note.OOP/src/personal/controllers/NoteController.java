package personal.controllers;

import personal.model.Note;
import personal.model.Repository;

import java.util.List;

public class NoteController {
    private final Repository repository;

    public NoteController(Repository repository) {
        this.repository = repository;
    }

    public void saveNote(Note note) {
        repository.CreateNote(note);
    }

    public void deleteNote(String id) {
        repository.DeleteNote(id);
    }

    public Note readNote(String userId) throws Exception {
        List<Note> notes = repository.getAllNote();
        for (Note note : notes) {
            if (note.getId().equals(userId)) {
                return note;
            }
        }

        throw new Exception("User not found");
    }
    public List<Note> readAllNote() throws Exception {
        List<Note> notes = repository.getAllNote();
        return notes;
    }

    public void UpdateNote(String id,String note,String text,String data) {
        repository.UpdateNote(id ,note, text, data);
    }

}
