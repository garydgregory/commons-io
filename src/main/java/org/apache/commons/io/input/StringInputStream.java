/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.commons.io.input;

import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Objects;

import org.apache.commons.io.build.AbstractStreamBuilder;

/**
 * An {@link InputStream} on a String.
 *
 * @since 2.13.0
 */
public final class StringInputStream extends ReaderInputStream {

    /**
     * Builds a new {@link StringInputStream} instance.
     * <p>
     * For example:
     * </p>
     *
     * <pre>{@code
     * ReaderInputStream s = new StringInputStream.Builder()
     *   .setString("String")
     *   .setCharsetEncoder(Charset.defaultCharset())
     *   .get()}
     * </pre>
     * <p>
     */
    public static class Builder extends AbstractStreamBuilder<StringInputStream, Builder> {

        private String string;

        /**
         * Constructs a new instance.
         *
         * Only uses the String and Charset aspects of this builder.
         */
        @Override
        public StringInputStream get() {
            return new StringInputStream(string, getCharset());
        }

        /**
         * Sets the non-null string.
         *
         * @param source The source string, MUST not be null.
         * @return this.
         */
        public Builder setString(final String source) {
            this.string = Objects.requireNonNull(source, "source");
            return this;
        }

    }

    /**
     * Creates a new instance on a String for a Charset.
     *
     * @param source  The source string, MUST not be null.
     * @param charset The source charset, null defaults to {@link Charset#defaultCharset()}.
     */
    @SuppressWarnings("deprecation")
    private StringInputStream(final String source, final Charset charset) {
        super(new StringReader(source), charset);
    }

}