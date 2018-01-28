/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.metadata;

import com.facebook.presto.spi.ColumnHandle;
import com.facebook.presto.spi.predicate.TupleDomain;

public class TableLayoutResult
{
    private final TableLayout layout;
    private final TupleDomain<ColumnHandle> unenforcedConstraint;

    public TableLayoutResult(TableLayout layout, TupleDomain<ColumnHandle> unenforcedConstraint)
    {
        this.layout = layout;
        this.unenforcedConstraint = unenforcedConstraint;
    }

    public TableLayout getLayout()
    {
        return layout;
    }

    public TupleDomain<ColumnHandle> getUnenforcedConstraint()
    {
        return unenforcedConstraint;
    }
}
