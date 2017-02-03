package evolution;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	@RequestMapping(value = "/0", method = RequestMethod.GET)
	public void anyMethod() throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		if (!(engine instanceof Invocable)) {
			System.out.println("Invoking methods is not supported.");
			return;
		}
		Invocable invocable = (Invocable) engine;
		String scriptPath = "http://localhost:8080/calculator.js";

		engine.eval("load('" + scriptPath + "')");

		Object calculator = engine.get("calculator");

		int x = 3;
		int y = 4;
		Object addResult = invocable.invokeMethod(calculator, "add", x, y);
		Object subResult = invocable.invokeMethod(calculator, "subtract", x, y);
		Object mulResult = invocable.invokeMethod(calculator, "multiply", x, y);
		Object divResult = invocable.invokeMethod(calculator, "divide", x, y);

		System.out.println(addResult);
		System.out.println(subResult);
		System.out.println(mulResult);
		System.out.println(divResult);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
