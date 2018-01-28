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
package com.facebook.presto.resourceGroups.db;

import com.google.common.collect.ImmutableMap;
import io.airlift.configuration.testing.ConfigAssertions;
import org.testng.annotations.Test;

import java.util.Map;

import static io.airlift.configuration.testing.ConfigAssertions.assertFullMapping;
import static io.airlift.configuration.testing.ConfigAssertions.assertRecordedDefaults;

public class TestDbResourceGroupConfig
{
    @Test
    public void testDefaults()
    {
        assertRecordedDefaults(ConfigAssertions.recordDefaults(DbResourceGroupConfig.class).setConfigDbUrl(null).setExactMatchSelectorEnabled(false));
    }

    @Test
    public void testExplicitPropertyMappings()
    {
        Map<String, String> properties = new ImmutableMap.Builder<String, String>()
                .put("resource-groups.config-db-url", "jdbc:mysql//localhost:3306/config?user=presto_admin")
                .put("resource-groups.exact-match-selector-enabled", "true")
                .build();
        DbResourceGroupConfig expected = new DbResourceGroupConfig().setConfigDbUrl("jdbc:mysql//localhost:3306/config?user=presto_admin").setExactMatchSelectorEnabled(true);
        assertFullMapping(properties, expected);
    }
}
