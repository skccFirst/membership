package youtube;

import youtube.config.kafka.KafkaProcessor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverStartedVideo_CheckMembership(@Payload StartedVideo startedVideo){

        if(startedVideo.isMe()){
            if(startedVideo.getMembershipId() != null)
            {
                System.out.println("############# 멤버십 확인 되었습니다. ################");
            }
            System.out.println("##### listener CheckMembership : " + startedVideo.toJson());
        }
    }

}
