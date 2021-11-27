package pl.creator.currencytoexcel.filecreated;

import pl.creator.currencytoexcel.filecreated.actions.FileAction;

public class FileAggregator {
    private FileAction[] fileActions;

    public FileAggregator(FileAction[] fileActions) {
        this.fileActions = fileActions;
    }
}
