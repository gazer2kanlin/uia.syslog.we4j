package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import uia.syslog.we.WindowsEventFactory;
import uia.syslog.we.WindowsEventParser;
import uia.syslog.we.model.xml.WindowsEventType;

public abstract class WindowsEventTest {
	
	protected Map<String, Object> test(String id, String content, Locale locale) throws Exception{
		WindowsEventFactory factory = new WindowsEventFactory();
		WindowsEventType weType = factory.find(id);
		WindowsEventParser parser = new WindowsEventParser(locale);
		Map<String, Object> result = parser.run(content, weType);

		System.out.println(weType.getId() + "(" + weType.getName() + ")> " + result);
		validate(result);
		
		return result;
	}
	
	protected void validate(Map<String, Object> result) {
	}
}
