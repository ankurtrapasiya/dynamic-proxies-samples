/*
 * Copyright (C) 2000-2019 Heinz Max Kabutz
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.  Heinz Max Kabutz licenses
 * this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.javaspecialists.books.dynamicproxies.ch02.equals;

import eu.javaspecialists.books.dynamicproxies.ch02.virtual.*;

import java.util.*;
import java.util.function.*;

public abstract class FixedEqualsTest extends EqualsTest {
  public FixedEqualsTest(UnaryOperator<CustomMap<Integer, Integer>> proxyGenerator) {
    super(CustomHashMap::new, proxyGenerator);
  }

  public static class CustomHashMap<K, V> implements CustomMap<K, V> {
    private final Map<K, V> map = new HashMap<>();
    @Override
    public int size() {
      return map.size();
    }
    @Override
    public V get(Object key) {
      return map.get(key);
    }
    @Override
    public V put(K key, V value) {
      return map.put(key, value);
    }
    @Override
    public V remove(Object key) {
      return map.remove(key);
    }
    @Override
    public void clear() {
      map.clear();
    }
    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
      map.forEach(action);
    }
    // tag::listing[]
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof CustomMap)) return false;

      if (getClass() == o.getClass()) {
        CustomHashMap<?, ?> m = (CustomHashMap<?, ?>) o;
        return map.equals(m.map);
      }
      return o.equals(this);
    }
    // end::listing[]
    @Override
    public int hashCode() {
      return map.hashCode();
    }
  }
}