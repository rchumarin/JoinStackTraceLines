package ru.sberbank;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * Объединение многострочной трассировки стека в одну строку и запись в лог
 * В обычном случае в лог пишется многострочная трассировка стека исключения
 */
public class JoinStackTraceLines {

    private static final Logger log = Logger.getLogger(JoinStackTraceLines.class);

    public static void main(String[] args) throws Exception {
        Properties logProperties = new Properties();
        try {
            logProperties.load(new FileInputStream("src/main/resources/log4j.properties"));
            PropertyConfigurator.configure(logProperties);
            throw new RuntimeException("Throw My Exception");
        } catch (FileNotFoundException e){
            log.info("File 'log4j.properties' not found");
        }catch(Exception e){
            log.error("Something failed", e);
        }
    }


}