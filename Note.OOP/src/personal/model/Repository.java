package personal.model;

import java.util.List;

public interface Repository {
    List<Note> getAllNote();
    String CreateNote(Note note);


    String DeleteNote(String id);

    String UpdateNote(String id, String note, String text, String data);
}
