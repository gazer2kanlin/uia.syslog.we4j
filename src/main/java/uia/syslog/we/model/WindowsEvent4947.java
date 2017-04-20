package uia.syslog.we.model;

/**
 * A change has been made to Windows Firewall exception list. A rule was modified.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4947 extends WindowsEvent {

    private String profileChanged;

    private String ruleId;

    private String ruleName;

    public WindowsEvent4947() {
        super("Security-Auditing", "4947");
    }

    public String getProfileChanged() {
        return this.profileChanged;
    }

    public String getRuleId() {
        return this.ruleId;
    }

    public String getRuleName() {
        return this.ruleName;
    }
}
