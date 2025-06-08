package uy.edu.ucu.aed.pd3;

import javax.swing.*;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedListModel extends AbstractListModel<String> {
    private SortedSet<String> model;

    public SortedListModel() {
        model = new TreeSet<>();
    }

    @Override
    public int getSize() {
        return model.size();
    }

    @Override
    public String getElementAt(int index) {
        return (String) model.toArray()[index];
    }

    public void addElement(String element) {
        if (model.add(element)) {
            fireContentsChanged(this, 0, getSize());
        }
    }

    public void removeElement(String element) {
        if (model.remove(element)) {
            fireContentsChanged(this, 0, getSize());
        }
    }

    public String firstElement() {
        return model.first();
    }

    public String lastElement() {
        return model.last();
    }

    public Iterator<String> iterator() {
        return model.iterator();
    }
}
