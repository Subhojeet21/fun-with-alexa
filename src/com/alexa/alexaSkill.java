package com.alexa;

import java.util.Optional;

import javax.security.auth.login.Configuration;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
//import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.ui.PlainTextOutputSpeech;
import com.amazon.ask.model.ui.Reprompt;
import com.amazon.ask.model.ui.SimpleCard;
import com.amazon.ask.model.ui.SsmlOutputSpeech;
import com.amazon.ask.request.Predicates;
import com.amazon.ask.response.ResponseBuilder;
import com.amazon.ask.response.SkillResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
  
@Path("/fun")
public class alexaSkill{
	
	@POST
	@Consumes("application/json")
	public String postMsg() throws JsonProcessingException {
		
		ObjectMapper Obj = new ObjectMapper();
		OutputSpeech resp1 = new OutputSpeech();
		resp1.type = "SSML";
		//resp1.ssml = "<speak><lang xml:lang=\"hi-IN\">आ गए बड़े लोग.</lang></speak>";
		//resp1.ssml = "<speak><emphasis level=\"strong\">oh my God look, who is here. <break time=\"1s\"/>Mr. Ghosh, the busy guy has arrived.</emphasis></speak>";
		resp1.ssml = "<speak>Hey buddy,<break time=\"1s\"/> this is a pandemic situation due to Novel Corona virus. You should not travel anywhere this time. Our government and all health care professionals ";
		resp1.ssml += "around the world are doing their best to control this situation. Now its our duty and responsibility to do out part. <break time=\"1s\"/>Stay home. <break time=\"1s\"/> Work from home. ";
		resp1.ssml += "<break time=\"1s\"/>Wash your hands often with soap and water or use hand sanitizer. <break time=\"1s\"/>Do not panic unnecessarily. <break time=\"1s\"/>Do not spread false news. <break time=\"1s\"/>Help elderly people. <break time=\"1s\"/>Stay safe.";
		resp1.ssml += "We are all in this together and if we follow all the precautionary measures and maintain social distancing, we all will get out of this situation soon.</speak>";

		
		Response rp = new Response();
		rp.outputSpeech = resp1;
		rp.shouldEndSession = true;
		
		Prediction pred = new Prediction();
		pred.version = "1.0";
		pred.response = rp;
		
		return Obj.writeValueAsString(pred);
		
    }
	
	public class Prediction{
		public String version;
		public Response response;
		
	}
	
	public class Response{
		public OutputSpeech outputSpeech;
		public boolean shouldEndSession;
	}
	
	public class OutputSpeech{
		public String type;
        public String ssml;
	}
	
	
}
