/*
 * Copyright (c) 2023 looly(loolly@aliyun.com)
 * Hutool is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

package cc.hongz.ztools.cron.pattern;

import cc.hongz.ztools.cron.pattern.matcher.PatternMatcher;
import cc.hongz.ztools.cron.pattern.parser.PatternParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

@DisplayName("IssueI7SMP7测试")
public class IssueI7SMP7Test {
    @DisplayName("步进表达式解析")
    @Test
    public void parseTest() {
        final List<PatternMatcher> parse = PatternParser.parse("0 0 3 1 1 ? */1");
        assertNotNull(parse);
    }
}
