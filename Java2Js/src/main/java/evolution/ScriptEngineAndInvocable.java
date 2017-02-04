package evolution;

import javax.script.Invocable;
import javax.script.ScriptEngine;

import lombok.Data;

@Data
public class ScriptEngineAndInvocable {
	private ScriptEngine scriptEngine;
	private Invocable invocable;
}
