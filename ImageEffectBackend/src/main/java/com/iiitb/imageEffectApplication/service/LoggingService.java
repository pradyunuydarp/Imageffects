package com.iiitb.imageEffectApplication.service;

import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;


@Service
public class LoggingService {

    private final List<LogModel> logQueue = new ArrayList<>(); // ArrayList for log access, just maintain a logQueue that stores Logs of current session(for future use)
    private final BlockingQueue<LogModel> blockingLogQueue = new LinkedBlockingQueue<>(); // BlockingQueue for thread safety
    private final String historyFilePath = "src/main/java/com/iiitb/imageEffectApplication/History.txt";
    //the History.txt file contains all past Logs(including the ones from past sessions)
    private final Thread loggingThread;

    public LoggingService() {
        loggingThread = new Thread(this::processLogs);
        loggingThread.start();
        loadLogsFromHistoryFile(); // Load logs from the history file on service initialization
    }
    private ArrayList<LogModel> loadLogsFromHistoryFile() {
        ArrayList<LogModel>returnlist = new ArrayList<>();
        try (BufferedReader newreader = new BufferedReader(new FileReader(historyFilePath))) {
            String line;
            while ((line = newreader.readLine()) != null) {
                LogModel log = parseLogFromLine(line);
                if (log != null) {
//                    logQueue.add(log); // Add parsed logs to the ArrayList
                    returnlist.add(log);
                    blockingLogQueue.offer(log); // Add parsed logs to the BlockingQueue
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading history file: " + e.getMessage());
        }
        finally {
            return returnlist;
        }
    }

    private void writeLogToHistoryFile(LogModel log) {
        try (FileWriter newwriter = new FileWriter(historyFilePath, true)) { // Append mode
            String logLine = log.getTimestamp() + ";" + log.getFilename() + ";" +//separate Log data by semicolons
                    log.getEffectName() + ";" + log.getOptionValues() + "\n";
            newwriter.write(logLine);//store the string in History.txt
        } catch (IOException e) {
            System.out.println("Error writing log to history file: " + e.getMessage());
        }
    }
    private LogModel parseLogFromLine(String line) {
        try {
            // Split the line into components
            String[] logParts = line.split(";"); // logs are separated by semicolon

            // Ensure the line contains necessary components
            if (logParts.length >= 4) {
                String timestamp = logParts[0];
                String fileName = logParts[1];
                String effectName = logParts[2];
                String optionValues = logParts[3];

                // Create a LogModel object and set its attributes
                LogModel log = new LogModel(timestamp, fileName, effectName, optionValues);
                return log;
            }
        } catch (Exception e) {
            System.out.println("Error parsing log from line: " + e.getMessage());
        }
        return null;
    }



public void addLog(String fileName, String effectName, String optionValues) {
    String timestamp = getCurrentTimestamp();
    LogModel log = new LogModel(timestamp, fileName, effectName, optionValues);
    logQueue.add(log); // Add log to the BlockingQueue
    writeLogToHistoryFile(log); // Write log to the history file
}

    public List<LogModel> getAllLogs() {

        ArrayList<LogModel>sendlist = loadLogsFromHistoryFile();
        return sendlist.reversed(); // Return a copy of logs in the ArrayList in reversed order
    }

    public List<LogModel> getLogsByEffect(String effectName) {//method to filter logs by effect
        List<LogModel> currentlogs = loadLogsFromHistoryFile();
        List<LogModel> logsByEffect = new ArrayList<>();
        for (LogModel log : currentlogs) {//among all the past/current logs
            if (log.getEffectName().equals(effectName)) {//check if the log was of the same effect
                logsByEffect.add(log);
            }
        }
        return logsByEffect.reversed();//return the filtered list
    }

    public void clearLogs() {
        logQueue.clear(); // Clear all logs in the ArrayList
        clearHistoryFile(); // Clear logs from the history file
    }

    private void clearHistoryFile() {
        try (FileWriter writer = new FileWriter(historyFilePath, false)) {//write/overwrite mode
            writer.write(""); // Clear content of history file(overwrite)
        } catch (IOException e) {
            System.out.println("Error clearing history file: " + e.getMessage());
        }
    }

    private String getCurrentTimestamp() {//returns the current date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTimestamp, LocalDateTime endTimestamp) {
        List<LogModel>currentlogs = loadLogsFromHistoryFile();//obtain the list of current/past logs
        return currentlogs.reversed().stream()//reverse and send the logs between the timestamps
                .filter(log -> {//a lambda expression that filters all available logs between the provided timestamps
                    LocalDateTime logTimestamp = LocalDateTime.parse(log.getTimestamp(),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    return (logTimestamp.isEqual(startTimestamp) || logTimestamp.isAfter(startTimestamp))
                            && logTimestamp.isBefore(endTimestamp);
                })
                .collect(Collectors.toList());
    }
    private void processLogs() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                LogModel log = blockingLogQueue.take(); // Retrieve logs from the BlockingQueue
                // Process log - you can write to a file, database, etc.
                // For demonstration, printing the log to console
                System.out.println("Logging: " + log);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
