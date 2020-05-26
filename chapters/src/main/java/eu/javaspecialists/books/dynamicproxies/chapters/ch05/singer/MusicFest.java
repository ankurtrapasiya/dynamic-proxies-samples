/*
 * Copyright (C) 2020 Heinz Max Kabutz
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.  Heinz Max Kabutz
 * licenses this file to you under the Apache License, Version
 * 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the
 * License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */

package eu.javaspecialists.books.dynamicproxies.chapters.ch05.singer;

public class MusicFest {
  public static void main(String... args) {
    var choir = new Choir();

    choir.add(new Bass());
    choir.add(new Soprano());
    choir.add(new Tenor());

    choir.add(new SingingRapperClassAdapter());
    choir.add(new SingingRapperObjectAdapter(new Rapper()));

    choir.singAll();
  }
}