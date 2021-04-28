package de.neuefische.model;

public class AnimalList {

    AnimalListItem head;

    public AnimalList add(Animal animal) {
        if (head == null) {
            head = new AnimalListItem(animal);
        } else {
            AnimalListItem i = head;
            while (i.next != null) {
                i = i.next;
            }
            i.next = new AnimalListItem(animal);
        }
        return this;
    }

    public AnimalList remove(Animal animal){
        if (head == null) {
            return this;
        } else {
            while (head.value.equals(animal)) {
                if (head.next != null) {
                    head = head.next;
                } else {
                    head = null;
                    return this;
                }
            }

            AnimalListItem i = head;
            while (i.next != null) {
                if (i.next.value.equals(animal)) {
                    if (i.next.next != null) {
                        i.next = i.next.next;
                    } else {
                        i.next = null;
                    }
                } else {
                    i = i.next;
                }
            }

            return this;
        }
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        } else {
            String string = head.value.name;
            AnimalListItem i = head;
            while(i.next != null){
                i = i.next;
                string += " -> " + i.value.name;
            }
            return string;
        }
    }

}
