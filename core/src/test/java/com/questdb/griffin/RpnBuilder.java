/*******************************************************************************
 *    ___                  _   ____  ____
 *   / _ \ _   _  ___  ___| |_|  _ \| __ )
 *  | | | | | | |/ _ \/ __| __| | | |  _ \
 *  | |_| | |_| |  __/\__ \ |_| |_| | |_) |
 *   \__\_\\__,_|\___||___/\__|____/|____/
 *
 * Copyright (C) 2014-2019 Appsicle
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 ******************************************************************************/

package com.questdb.griffin;

import com.questdb.griffin.model.ExpressionNode;
import com.questdb.std.str.StringSink;

public class RpnBuilder implements ExpressionParserListener {
    private final StringSink sink = new StringSink();

    @Override
    public void onNode(ExpressionNode node) {
        if (node.queryModel != null) {
            sink.put('(').put(node.queryModel).put(')');
        } else {
            sink.put(node.token);
        }
    }

    public void reset() {
        sink.clear();
    }

    public final CharSequence rpn() {
        return sink;
    }
}
