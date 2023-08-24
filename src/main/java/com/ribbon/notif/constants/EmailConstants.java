package com.ribbon.notif.constants;

import java.util.HashMap;
import java.util.Map;

import com.ribbon.notif.generated.types.EmailType;

public class EmailConstants {
    public static final String RECOVERY_EMAIL = "recovery";
    public static final String RECOVERY_DONE_EMAIL = "recoveryComplete";

    public Map <EmailType, String> EMAIL_MAP = new HashMap<EmailType, String>()
    {
        {
            put(EmailType.PASSWORD, RECOVERY_EMAIL);
            put(EmailType.RECOVERY_DONE, RECOVERY_DONE_EMAIL);
        }
    };

}
