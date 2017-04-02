package uia.syslog.we.model;

/**
 * A Windows Filtering Platform provider has been changed.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent5448 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String processId;

    private String changeType;

    private String providerId;

    private String providerName;

    private String providerType;

    public WindowsEvent5448() {
        super("Security-Auditing", "5448");
    }

    public String getSecurityId() {
        return this.securityId;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getProcessId() {
        return this.processId;
    }

    public String getChangeType() {
        return this.changeType;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public String getProviderType() {
        return this.providerType;
    }

}
