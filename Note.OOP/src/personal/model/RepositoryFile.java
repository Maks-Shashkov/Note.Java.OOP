package personal.model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private NoteMapper mapper = new NoteMapper();
    private FileOperation fileOperation;

    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Note> getAllNote() {
        List<String> lines = fileOperation.readAllLines();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    @Override
    public String CreateNote(Note note) {

        List<Note> notes = getAllNote();
        int max = 0;
        for (Note item : notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);
        List<String> lines = new ArrayList<>();
        for (Note item: notes) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
        return id;
    }

    @Override
    public String DeleteNote(String id) {

        List<Note> notes = getAllNote();
        List<String> lines = new ArrayList<>();
        for (Note item: notes) {
            if (item.getId().equals(id))
                continue;
            else {
                lines.add(mapper.map(item));
            }
        }
        fileOperation.saveAllLines(lines);
        return id;
    }

    @Override
    public String UpdateNote(String id, String note, String text, String data) {

        List<Note> notes = getAllNote();
        List<String> lines = new ArrayList<>();
        for (Note item: notes) {
            if (item.getId().equals(id)){
                item.setNote(note);
                item.setText(text);
                item.setData(data);
                lines.add(mapper.map(item));
            } else {
                lines.add(mapper.map(item));
            }

        }
        fileOperation.saveAllLines(lines);
        return id;
    }



}
