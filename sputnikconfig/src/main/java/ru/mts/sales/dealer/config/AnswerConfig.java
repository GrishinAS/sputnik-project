package ru.mts.sales.dealer.config;

import java.util.Properties;
import ru.mts.sales.dealer.util.ConfigReader;

public class AnswerConfig {
  private final Properties properties;
  public AnswerConfig() {
    properties = new ConfigReader().getProperties();
  }
  public String getAnswer(){
    return properties.getProperty("answer");
  }
}
