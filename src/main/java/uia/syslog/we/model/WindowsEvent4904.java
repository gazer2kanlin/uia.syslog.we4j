package uia.syslog.we.model;

/**
 * An attempt was made to register a security event source.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4904 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String processId;

    private String processName;

    private String sourceName;

    private String eventSourceId;

    public WindowsEvent4904() {
        super("Security-Auditing", "4904");
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

    public String getSourceName() {
        return this.sourceName;
    }

    public String getEventSourceId() {
        return this.eventSourceId;
    }

}
