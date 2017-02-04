package evolution;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JsUtil {
	public static Object variableFunction(String scriptPath, String variableName, String functionName, Object... parameters) {
		try {
			ScriptEngineAndInvocable scriptEngineAndInvocable = getEngineAndInvocable(scriptPath);
			Object variable = scriptEngineAndInvocable.getScriptEngine().get(variableName);
			return scriptEngineAndInvocable.getInvocable().invokeMethod(variable, functionName, parameters);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Object function(String scriptPath, String functionName, Object... parameters) {
		try {
			return getEngineAndInvocable(scriptPath).getInvocable().invokeFunction(functionName, parameters);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ScriptEngineAndInvocable getEngineAndInvocable(String scriptPath) {
		try {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine scriptEngine = manager.getEngineByName("JavaScript");
			Invocable invocable = (Invocable) scriptEngine;
			scriptEngine.eval("load('" + scriptPath + "')");
			ScriptEngineAndInvocable scriptEngineAndInvocable = new ScriptEngineAndInvocable();
			scriptEngineAndInvocable.setScriptEngine(scriptEngine);
			scriptEngineAndInvocable.setInvocable(invocable);
			return scriptEngineAndInvocable;
		} catch (ScriptException e) {
			e.printStackTrace();
			return null;
		}
	}
}
