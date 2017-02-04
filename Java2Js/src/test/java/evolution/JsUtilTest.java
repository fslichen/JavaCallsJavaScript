package evolution;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class JsUtilTest {
//	@Test
	public void testFunction() {
		Object object = JsUtil.function("http://localhost:8080/function.js", "anyFunction", "Hello World");
		System.out.println(object);
	}
	
//	@Test
	public void testVariableFunction() {
		Object object = JsUtil.variableFunction("http://localhost:8080/variableFunction.js", "anyVariable", "anyFunction", "Hello World");
		System.out.println(object);
	}
	
//	@Test
	public void testArrayFunction() {
		int[] array = {1, 2, 3};
		Object object = JsUtil.function("http://localhost:8080/function.js", "arrayOrListFunction", array);
		System.out.println(object);
	}
	
//	@Test
	public void testMapFunction() {
		Map<Integer, Double> map = new LinkedHashMap<>();
		map.put(1, 3.14);
		map.put(2, 6.28);
		Object object = JsUtil.function("http://localhost:8080/function.js", "mapFunction", map);
		System.out.println(object);
	}
	
	@Test
	public void testListFunction() {
		List<String> list = new LinkedList<>();
		list.add("Hello World");
		list.add("Goodbye Past");
		Object object = JsUtil.function("http://localhost:8080/function.js", "arrayOrListFunction", list);
		System.out.println(object);
	}
}
