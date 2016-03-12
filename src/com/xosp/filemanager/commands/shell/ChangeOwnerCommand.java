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

import com.xosp.filemanager.commands.ChangeOwnerExecutable;
import com.xosp.filemanager.console.CommandNotFoundException;
import com.xosp.filemanager.console.ExecutionException;
import com.xosp.filemanager.console.InsufficientPermissionsException;
import com.xosp.filemanager.model.Group;
import com.xosp.filemanager.model.MountPoint;
import com.xosp.filemanager.model.User;
import com.xosp.filemanager.util.MountPointHelper;

import java.text.ParseException;


/**
 * A class for change the owner of an object.
 *
 * {@link "http://unixhelp.ed.ac.uk/CGI/man-cgi?chown"}
 */
public class ChangeOwnerCommand extends SyncResultProgram implements ChangeOwnerExecutable {

    private static final String ID = "chown";  //$NON-NLS-1$
    private Boolean mRet;
    private final String mFileName;

    /**
     * Constructor of <code>ChangeOwnerCommand</code>.
     *
     * @param fileName The name of the file or directory to be moved
     * @param newUser The new user owner of the object
     * @param newGroup The new group owner of the object
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public ChangeOwnerCommand(
            String fileName, User newUser, Group newGroup)
            throws InvalidCommandDefinitionException {
        super(ID, String.valueOf(newUser.getId()), String.valueOf(newGroup.getName()), fileName);
        this.mFileName = fileName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void parse(String in, String err) throws ParseException {
        //Release the return object
        this.mRet = Boolean.TRUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getResult() {
        return this.mRet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkExitCode(int exitCode)
            throws InsufficientPermissionsException, CommandNotFoundException, ExecutionException {
        if (exitCode != 0) {
            throw new ExecutionException("exitcode != 0"); //$NON-NLS-1$
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MountPoint getSrcWritableMountPoint() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MountPoint getDstWritableMountPoint() {
        return MountPointHelper.getMountPointFromDirectory(this.mFileName);
    }
}
