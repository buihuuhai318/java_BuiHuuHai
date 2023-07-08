package controller;

import service.WordService;

import static view.Main.input;

public class Controller {


    WordService wordService = new WordService();

    public void display() {
        System.out.print("Action: ");
        String inputStr = input.nextLine().trim();
        if (inputStr.matches("^lookup.*")) {
            wordService.showWord(inputStr);
        } if (inputStr.matches("^define -.*")) {
            wordService.defineWord(inputStr);
        }
    }
}
