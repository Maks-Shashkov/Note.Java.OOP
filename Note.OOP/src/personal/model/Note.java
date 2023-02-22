package personal.model;

public class Note {
    private String id = "";
    private String note;
    private String text;
    private String data;

    public Note(String note, String text, String data) {
        this.note = note;
        this.text = text;
        this.data = data;
    }

    public Note(String id, String firstName, String lastName, String phone) {
        this(firstName, lastName, phone);
        this.id = id;

    }

    @Override
    public String toString() {
        return String.format("Идентафикатор: %s\nИмя: %s,\nФамилия: %s,\nТелефон: %s", id, note, text, data);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
