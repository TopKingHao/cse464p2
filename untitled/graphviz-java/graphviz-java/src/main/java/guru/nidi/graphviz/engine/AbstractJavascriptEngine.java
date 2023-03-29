/*
 * Copyright © 2015 Stefan Niederhauser (nidin@gmx.ch)
 *
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
package guru.nidi.graphviz.engine;

import static guru.nidi.graphviz.engine.StringFunctions.escapeJs;

public abstract class AbstractJavascriptEngine implements JavascriptEngine {
    @Override
    public void executeJavascript(String raw) {
        execute(raw + "; result('');");
    }

    @Override
    public String executeJavascript(String pre, String src, String post) {
        return execute(pre + "'" + escapeJs(src) + "'" + post);
    }

    protected abstract String execute(String js);

    @Override
    public void close() {
    }
}
