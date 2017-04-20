package uia.syslog.we.model;

/**
 * A trusted logon process has been registered with the Local Security Authority.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4616 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String processId;

    private String processName;

    private String previousTime;

    private String newTime;

    public WindowsEvent4616() {
        super("Security-Auditing", "4616");
    }

    public String getSecurityId() {
        return this.securityId;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getAccountDomain() {
        return this.accountDomain;
    }

    public String getLogonId() {
        return this.logonId;
    }

    public String getProcessId() {
        return this.processId;
    }

    public String getProcessName() {
        return this.processName;
    }

    public String getPreviousTime() {
        return this.previousTime;
    }

    public String getNewTime() {
        return this.newTime;
    }

}
