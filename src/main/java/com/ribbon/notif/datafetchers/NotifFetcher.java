package com.ribbon.notif.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.ribbon.notif.generated.types.EmailType;
import com.ribbon.notif.generated.types.SendEmailResult;
import com.ribbon.notif.services.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@DgsComponent
public class NotifFetcher {

    private final NotificationService notifService;

    @DgsData(parentType = "Mutation", field = "sendEmail")
    public SendEmailResult sendEmail(@InputArgument String toAddress, @InputArgument EmailType type) {
        log.info("Wtf");

        notifService.sendNotif();

        return SendEmailResult.newBuilder().isSuccess(true).build();
    }

}
