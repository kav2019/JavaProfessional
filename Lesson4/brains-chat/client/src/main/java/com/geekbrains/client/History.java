package com.geekbrains.client;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class History {
    private static final int COUNT_LINE = 2;

    public static void saveMsg(String login, String message){
        try {
            Files.write(getHistoryFilePath(login), message.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Path getHistoryFilePath(String login){ //Создание пути для конкретного логина
        Path historyPath = Paths.get("history", "history_" + login + ".txt");
        if (Files.notExists(historyPath.getParent())){ //Если нет папки history - то создаем
            createHistotyDirectory(historyPath);
        }
        return historyPath;
    }

    private static void createHistotyDirectory(Path path) { // Создаем директорию
        try{
            Files.createDirectories(path.getParent());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getHistory(String login){ // Получаем историю
        Path historyFilePath = getHistoryFilePath(login); // Путь к файлу с историей
        if (Files.notExists(historyFilePath)) return ""; // Если такого файла нет то возвращаем пустое значение
        try {
            List<String> line = Files.readAllLines(historyFilePath, StandardCharsets.UTF_8);
            return getLastLine(line); // Передаем в метод все что прочитали из файла
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getLastLine(List<String> line) { // Получаем нужное количество последних сообщений
        StringBuilder result = new StringBuilder();
        int startPos = 0;
        if(line.size()>COUNT_LINE){
            startPos = line.size() - COUNT_LINE; // находим последние сообщения которые мы должны получить
        }
        for (int i = startPos; i < line.size(); i++) { //
            result.append(line.get(i)).append(System.lineSeparator());
        }
        return result.toString();
    }


}
