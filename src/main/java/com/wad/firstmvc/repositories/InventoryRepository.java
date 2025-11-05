package com.wad.firstmvc.repositories;
import com.wad.firstmvc.domain.catalog.InventoryItem;
import java.util.*;

public interface InventoryRepository {
    Optional<InventoryItem> findAvailableByBookId(Long bookId);
}