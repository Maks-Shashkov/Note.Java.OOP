package personal.views;

import personal.controllers.NoteController;
import personal.model.Note;

import java.util.List;
import java.util.Scanner;

public class ViewNote {

    private NoteController noteController;

    public ViewNote(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() throws Exception {
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    String note = prompt("Заголовок: ");
                    String text = prompt("Текст: ");
                    String data = prompt("Дата: ");
                    noteController.saveNote(new Note(note, text, data));
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        Note noteInput = noteController.readNote(id);
                        System.out.println(noteInput);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case DELETE:
                    String idUser = prompt("Идентификатор пользователя: ");
                    try {
                        noteController.deleteNote(idUser);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case LIST:
                    List<Note> notes = noteController.readAllNote();
                    for (Note Listnote : notes) {
                        System.out.println(Listnote);
                    }
                    break;
                case UPDATE:
                    String upId = prompt("Id:");
                    String upNote = prompt("Заголовок: ");
                    String upText = prompt("Текст: ");
                    String upData = prompt("Дата: ");
                    noteController.UpdateNote(upId,upNote,upText,upData);
                    break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
