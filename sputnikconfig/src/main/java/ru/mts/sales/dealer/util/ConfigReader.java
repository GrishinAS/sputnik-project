package ru.mts.sales.dealer.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

  private String propFileName = "answer.properties";
  private Logger log = LoggerFactory.getLogger(ConfigReader.class);

  public Properties getProperties() {
    Properties prop = new Properties();
    ClassLoader classLoader = getClass().getClassLoader();
    try {
      while (classLoader.getResources("").hasMoreElements()) {
        System.out.println(classLoader.getResources("").nextElement().toString());
          log.debug(classLoader.getResources("").nextElement().toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    try (InputStream inputStream = classLoader.getResourceAsStream(propFileName);) {
      prop.load(inputStream);
      return prop;
    } catch (Exception e) {
      System.out.println("propFileName " + " Exception: " + e);
    }

    try (InputStream inputStream = new FileInputStream(propFileName)) {
      prop.load(inputStream);
      return prop;
    } catch (Exception e) {
      System.out.println("propFileName " + " Exception: " + e);
    }
    throw new IllegalArgumentException("No config file was found");
  }
}