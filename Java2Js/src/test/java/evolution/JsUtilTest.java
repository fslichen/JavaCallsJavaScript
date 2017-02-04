package evolution;
import org.junit.Test;

import evolution.JsUtil;

public class JsUtilTest {
	@Test
	public void testFunction() {
		Object object = JsUtil.function("http://localhost:8080/function.js", "anyFunction", "Hello World");
		System.out.println(object);
	}
	
	@Test
	public void testVariableFunction() {
		Object object = JsUtil.variableFunction("http://localhost:8080/variableFunction.js", "anyVariable", "anyFunction", "Hello World");
		System.out.println(object);
	}
}
