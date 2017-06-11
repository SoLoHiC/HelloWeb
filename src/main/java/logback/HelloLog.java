package logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chuck
 * @since 20/01/2017
 */
public class HelloLog {

  public static void main(String[] args) {

    Logger log = LoggerFactory.getLogger(HelloLog.class);
    log.info("hello Slf4j and Logback!");
  }
}
