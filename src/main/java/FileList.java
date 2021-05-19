import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileList {
    private static String line;

    public static List<String> setList() {
        List<String> fileList = new ArrayList<>();
        try {
            fileList = Files
                    .readAllLines(Paths.get(Movements.pathMovementsCsv));
            fileList.remove(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fileList;
    }

    public static List<String> getCorrectList() {
        List<String> correctList = new ArrayList<>();
        for (String setLine : FileList.setList()) {
            line = setLine;
            if (setLine.contains("\"")) {
                line = FileList.getCorrectLine(setLine);
            }
            correctList.add(line);
        }
        return correctList;
    }

    private static String getCorrectLine(String line) {
        String[] fragments = line.split("\"");
        StringBuilder correctLine = new StringBuilder(fragments[0].replace("\"", ""));
        correctLine.append(fragments[1].replace(",", "."));
        if (fragments.length == 3) {
            correctLine.append(fragments[2].replace("\"", ""));
        }
        return correctLine.toString().trim();
    }
}
