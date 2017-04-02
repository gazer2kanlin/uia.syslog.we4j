package uia.syslog.we.model;

/**
 * A Windows Filtering Platform sub-layer has been changed.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent5450 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String processId;

    private String providerId;

    private String providerName;

    private String changeType;

    private String subLayerId;

    private String subLayerName;

    private String subLayerType;

    private String weight;

    public WindowsEvent5450() {
        super("Security-Auditing", "5450");
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

    public String getProviderId() {
        return this.providerId;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public String getChangeType() {
        return this.changeType;
    }

    public String getSubLayerId() {
        return this.subLayerId;
    }

    public String getSubLayerName() {
        return this.subLayerName;
    }

    public String getSubLayerType() {
        return this.subLayerType;
    }

    public String getWeight() {
        return this.weight;
    }
}
