package net.openhft.chronicle.wire.map;

import net.openhft.chronicle.wire.SelfDescribingMarshallable;
import net.openhft.chronicle.wire.WireTestCommon;
import net.openhft.chronicle.wire.Wires;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class MapMarshallableTest extends WireTestCommon {

    @Test
    public void test() {
        @NotNull final Map<String, Object> map = new LinkedHashMap<>();
        map.put("one", 10);
        map.put("two", 20);
        map.put("three", 30);

        @NotNull MyDto usingInstance = new MyDto();
        @NotNull MyDto result = Wires.copyTo(map, usingInstance);
        assertEquals(10, result.one);
        assertEquals(20, result.two);
        assertEquals(30, result.three);
        
        String keys2[] = {"one", "two", "three"};
        @NotNull Map<String, Object> map2 = Wires.copyTo(result, new LinkedHashMap<>());
        Map<String, Object> sortedMap2 = new LinkedHashMap<>();
        for (String k : keys2) {
            sortedMap2.put(k, map2.get(k));
        }
        assertEquals("{one=10, two=20, three=30}", sortedMap2.toString());
        //  just fix the Assert
        //  assertTrue(map.equals(map2));

        String keys3[] = {"one", "three", "two"};
        @NotNull Map<String, Object> map3 = Wires.copyTo(map, new TreeMap<>());
        Map<String, Object> sortedMap3 = new LinkedHashMap<>();
        for (String k : keys3) {
            sortedMap3.put(k, map3.get(k));
        }
        assertEquals("{one=10, three=30, two=20}", sortedMap3.toString());
        //  just fix the Assert
        //  assertTrue(map.equals(map3));
    }

    private static class MyDto extends SelfDescribingMarshallable {
        int one;
        int two;
        int three;
    }
}