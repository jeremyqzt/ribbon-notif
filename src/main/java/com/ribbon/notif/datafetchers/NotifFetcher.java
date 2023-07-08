package com.ribbon.notif.datafetchers;

import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import com.ribbon.notif.generated.types.EmailType;
import com.ribbon.notif.generated.types.SendEmailResult;
import com.ribbon.notif.services.NotificationService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotifFetcher {

    private final NotificationService notifService;

    @DgsMutation(field = "sendEmail")
    public SendEmailResult shows(@InputArgument String toAddress, @InputArgument EmailType type) {
        notifService.sendNotif();

        return SendEmailResult.newBuilder().isSuccess(true).build();

    }

}
