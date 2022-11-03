package com.program.lru;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(JUnitParamsRunner.class)
public class LRUCacheTest {

    @Test
    public void addSomeDataToCache_WhenGetData_ThenIsEqualWithCacheElement() {
        LRUCache lrucache = new LRUCache();
        lrucache.putEntry(1, 1);
        lrucache.putEntry(10, 15);
        lrucache.putEntry(15, 10);
        lrucache.putEntry(10, 16);
        lrucache.putEntry(12, 15);
        lrucache.putEntry(18, 10);
        lrucache.putEntry(13, 16);
        assertEquals(-1, lrucache.getEntry(1));
        assertEquals(-1, lrucache.getEntry(2));
        assertEquals(16, lrucache.getEntry(10));
    }

}
