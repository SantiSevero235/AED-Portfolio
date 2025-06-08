package uy.edu.ucu.aed.pd3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayListComboBoxModel extends AbstractListModel<String> implements MutableComboBoxModel<String> {
    private List<String> data;
    private Object selectedItem;

    public ArrayListComboBoxModel() {
        this.data = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public String getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void addElement(String element) {
        data.add(element);
        fireIntervalAdded(this, data.size() - 1, data.size() - 1);
    }

    @Override
    public void insertElementAt(String element, int index) {
        data.add(index, element);
        fireIntervalAdded(this, index, index);
    }

    @Override
    public void removeElement(Object element) {
        int index = data.indexOf(element);
        if (index != -1) {
            data.remove(index);
            fireIntervalRemoved(this, index, index);
        }
    }

    @Override
    public void removeElementAt(int index) {
        data.remove(index);
        fireIntervalRemoved(this, index, index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
