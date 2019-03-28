// Copyright 2018, Oath Inc.
// Licensed under the terms of the Apache License 2.0 license. See LICENSE file in Ultrabrew Metrics
// for terms.

package io.ultrabrew.metrics.data;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ConcurrentMonoidHashTableTest {

  @Test
  public void testNotMatchingFieldsAndIdentity() {
    assertThrows(AssertionError.class, () -> new ConcurrentMonoidHashTable(
        "test",
        128,
        4096,
        new String[]{"test"},
        new Type[]{Type.LONG},
        new long[]{0L, 1L}) {
      @Override
      protected void combine(long[] table, final long baseOffset, final long value) {
        // no-op
      }
    });
  }
}
