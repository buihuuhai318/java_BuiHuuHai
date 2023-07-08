package service;

import repository.TypeRepository;

import static view.Main.input;

public class TypeWord {

    TypeRepository typeRepository = new TypeRepository();

    public void addType() {
        System.out.print(" - add new type: ");
        String type = input.nextLine();
    }
}
