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

package com.questdb.griffin.engine.functions.rnd;

import com.questdb.cairo.CairoConfiguration;
import com.questdb.cairo.sql.Function;
import com.questdb.cairo.sql.Record;
import com.questdb.griffin.FunctionFactory;
import com.questdb.griffin.SqlException;
import com.questdb.griffin.engine.functions.StatelessFunction;
import com.questdb.griffin.engine.functions.SymbolFunction;
import com.questdb.std.ObjList;
import com.questdb.std.Rnd;

public class RndSymbolListFunctionFactory implements FunctionFactory {
    @Override
    public String getSignature() {
        return "rnd_symbol(V)";
    }

    @Override
    public Function newInstance(ObjList<Function> args, int position, CairoConfiguration configuration) throws SqlException {
        final ObjList<String> symbols = new ObjList<>(args.size());
        RndStringListFunctionFactory.copyConstants(args, symbols);

        return new Func(position, symbols, configuration);
    }

    private static final class Func extends SymbolFunction implements StatelessFunction {
        private final ObjList<String> symbols;
        private final Rnd rnd;
        private final int count;

        public Func(int position, ObjList<String> symbols, CairoConfiguration configuration) {
            super(position);
            this.rnd = SharedRandom.getRandom(configuration);
            this.symbols = symbols;
            this.count = symbols.size();
        }

        @Override
        public CharSequence getSymbol(Record rec) {
            return symbols.getQuick(rnd.nextPositiveInt() % count);
        }
    }
}
