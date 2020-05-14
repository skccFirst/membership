package ys;

import ys.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverStartedVideo_CheckMembership(@Payload StartedVideo startedVideo){

        if(startedVideo.isMe()){
            System.out.println("##### listener CheckMembership : " + startedVideo.toJson());
        }
    }

}
