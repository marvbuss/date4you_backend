package com.tutego.date4you.shell;

import com.tutego.date4you.domain.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.*;
import org.springframework.util.unit.DataSize;

@ShellComponent
public class FsCommands {

    private final FileSystem fs;

    @Autowired
    public FsCommands( FileSystem fs ) { this.fs = fs; }

    public String freeDiskSpace() {
        return DataSize.ofBytes(fs.getFreeDiskSpace()).toGigabytes() + " GB";
    }
}
