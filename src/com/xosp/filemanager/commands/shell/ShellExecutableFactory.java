/*
 * Copyright (C) 2012 The CyanogenMod Project
 *
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
 */

package com.xosp.filemanager.commands.shell;

import com.xosp.filemanager.commands.ExecutableCreator;
import com.xosp.filemanager.commands.ExecutableFactory;
import com.xosp.filemanager.console.shell.ShellConsole;

/**
 * A class that represents a factory for creating shell {@link "Executable"} objects.
 */
public class ShellExecutableFactory extends ExecutableFactory {

    private final ShellConsole mConsole;

    /**
     * Constructor of <code>ShellExecutableFactory</code>.
     *
     * @param console A shell console that use for create objects
     */
    public ShellExecutableFactory(ShellConsole console) {
        super();
        this.mConsole = console;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableCreator newCreator() {
        return new ShellExecutableCreator(this.mConsole);
    }

}
