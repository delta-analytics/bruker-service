package deltaanalytics.bruker.hardware.commands;

public class MeasureSampleCommandResult {
    private String[] resultArray;

    public MeasureSampleCommandResult(String[] resultArray) {
        this.resultArray = resultArray;
    }

    public int getFileId() {
        return Integer.parseInt(resultArray[5]);
    }

    public String getPath() {
        return pathWithoutDoubleQuotes().substring(0, pathWithoutDoubleQuotes().lastIndexOf("\\"));
    }

    public String getFileName() {
        return pathWithoutDoubleQuotes().substring(pathWithoutDoubleQuotes().lastIndexOf("\\") + 1, pathWithoutDoubleQuotes().length());
    }

    private String pathWithoutDoubleQuotes() {
        return resultArray[3].replaceAll("\"", "");
    }
}
