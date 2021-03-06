/*-
 * -\-\-
 * Spotify styx
 * --
 * Copyright (C) 2017 Spotify AB
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */
package com.spotify.styx.util;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GuardedRunnableTest {
  
  @Mock
  private Runnable runnable;

  @Test
  public void shouldRun() {
    doNothing().when(runnable).run();
    GuardedRunnable.guard(runnable).run();
  }
  
  @Test
  public void shouldNotThrow() {
    doThrow(new RuntimeException()).when(runnable).run();
    GuardedRunnable.guard(runnable).run();
  }
}
