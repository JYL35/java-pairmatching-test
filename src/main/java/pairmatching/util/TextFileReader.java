package pairmatching.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {
    private static final String PATH = "D:\\workplace\\woowacourse\\final coding test\\"
            + "practice\\java-pairmatching-test\\src\\main\\resources\\";

    public static List<String> readFile(String input) {
        String fileName = "frontend-crew.md";
        if (input.equals("백엔드")) fileName = "backend-crew.md";

        File file = new File(PATH + fileName);

        if (!file.isFile() || !file.canRead()) {
            throw new IllegalArgumentException("파일을 읽을 수 없습니다.");
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            return fileToList(bufferedReader);
        } catch (IOException e) {
            throw new IllegalArgumentException("파일을 읽는 중 오류가 발생했습니다.");
        }
    }

    private static List<String> fileToList(BufferedReader bufferedReader) throws IOException {
        List<String> lines = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        return List.copyOf(lines);
    }
}
