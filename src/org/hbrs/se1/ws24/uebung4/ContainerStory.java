package org.hbrs.se1.ws24.uebung4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContainerStory<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public List<T> getSortedItems() {
        return items.stream()
                .sorted((Comparator<? super T>) Comparator.comparingDouble(((UserStory u) -> u.getPrioritizationValue())).reversed())
                .collect(Collectors.toList());
    }

    public void clear() {
        items.clear();
    }
}
