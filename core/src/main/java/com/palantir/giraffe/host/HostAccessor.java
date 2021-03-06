/**
 * Copyright 2015 Palantir Technologies, Inc.
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
package com.palantir.giraffe.host;

import java.io.IOException;

/**
 * Provides access to a host by opening file systems and execution systems.
 *
 * @author bkeyes
 */
public interface HostAccessor {

    /**
     * Returns the {@link Host} that this object makes accessible.
     */
    Host getHost();

    /**
     * Returns the {@link SystemRequest} object used when opening new systems.
     */
    SystemRequest request();

    /**
     * Opens a new host control system on this host. The returned system should be
     * closed after use. It is implementation specific if multiple host control systems
     * can be open for the same host at the same time.
     *
     * @return an open {@link HostControlSystem}
     *
     * @throws IOException if an I/O error occurs while opening the system
     */
    HostControlSystem open() throws IOException;

}
