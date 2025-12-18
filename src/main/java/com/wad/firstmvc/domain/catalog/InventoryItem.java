package com.wad.firstmvc.domain.catalog;

import lombok.Getter;

public class InventoryItem {
    public enum Status { AVAILABLE, BORROWED, RESERVED }
    private final Long id; @Getter
    private final Book book; @Getter
    private Status status;
    public InventoryItem(Long id, Book book){ this.id=id; this.book=book; this.status=Status.AVAILABLE; }

    public void markBorrowed(){ status = Status.BORROWED; }
    public void markReturned(){ status = Status.AVAILABLE; }
}