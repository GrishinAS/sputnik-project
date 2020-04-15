package ru.mts.sales.dealer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mts.sales.dealer.config.AnswerConfig;

@Path("/sputnik")
public class SputnikWebApi extends Application { //JavaDelegate,

  private AnswerConfig answerConfig;

  public SputnikWebApi() {
    log.info("SputnikWebApi created");
    answerConfig = new AnswerConfig();
  }

  private Logger log = LoggerFactory.getLogger(SputnikWebApi.class);

  @POST
  @Path("/complect")
  public String sellSTVComplect(@Context HttpHeaders headers) { //final STVRegisterRequest request,
    try {
      if (answerConfig != null) {
        return answerConfig.getAnswer();
      }
      return "ok";
    } catch (Exception e) {
      log.error("Error occurred while selling stv kit: ", e);
      throw new RuntimeException(e);
    }
  }

  @GET
  @Path("/ping")
  public String ping(@Context HttpHeaders headers) { //final STVRegisterRequest request,
    log.debug("Ping received");
    try {
      return "answer";
    } catch (Exception e) {
      log.error("Error occurred while receiving ping: ", e);
      throw new RuntimeException(e);
    }
  }

//  public void execute(DelegateExecution delegateExecution) throws Exception {
//    log.debug("Java delegate called");
//
//  }
}
