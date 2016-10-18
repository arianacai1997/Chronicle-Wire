/*
 * Copyright 2016 higherfrequencytrading.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package net.openhft.chronicle.wire.marshallable;

import net.openhft.chronicle.wire.AbstractMarshallable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by peter on 09/05/16.
 */
public class Nested extends AbstractMarshallable {
    ScalarValues values;
    List<String> strings;
    Set<Integer> ints;
    Map<String, List<Double>> map;
    String[] array;

    public Nested() {
    }

    public Nested(ScalarValues values, List<String> strings, Set<Integer> ints, Map<String, List<Double>> map, String[] array) {
        this.values = values;
        this.strings = strings;
        this.ints = ints;
        this.map = map;
        this.array = array;
    }
}
