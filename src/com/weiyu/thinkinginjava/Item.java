package com.weiyu.thinkinginjava;

import java.util.Objects;

/**
 * Created by weiyu on 2017/1/3.
 */
public class Item implements Comparable<Item> {
    private String description;
    private int partNumber;
    @Override
    public int compareTo(Item other) {
        return Integer.compare(partNumber,other.partNumber);
//        return description.compareTo(other.getDescription());
    }

    public Item(){}

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (partNumber != item.partNumber) return false;
        return description != null ? description.equals(item.description) : item.description == null;

    }

    @Override
    public int hashCode() {
        return Objects.hash(description,partNumber);
    }
}
