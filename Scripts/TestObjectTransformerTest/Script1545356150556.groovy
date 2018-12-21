import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import com.kms.katalon.core.testobject.TestObjectXpath

TestObject source = findTestObject("Object Repository/Page_15801_testbed/button_foo")
assert source != null
println "source is ${formatTestObject(source)}"

TestObject target = CustomKeywords.'my.TestObjectTransformer.toMyFavoritesXPath'(source, FailureHandling.OPTIONAL)
assert target != null

println "target is ${formatTestObject(target)}"


println target.getActiveXpaths()
println target.getActiveXpaths().size()
println target.getActiveXpaths().get(0).class
println target.getActiveXpaths().get(0).getName()
println target.getActiveXpaths().get(0).getValue()
Method[] allMethods = target.getActiveXpaths().get(0).class.getDeclaredMethods()
for (Method m : allMethods) {
	println m.toString()
}

/**
 * convert a test object into string
 * 
 * @param TestObject
 * @return
 */
String formatTestObject(TestObject to) {
	StringBuilder sb = new StringBuilder()
	sb.append("{")
	// objectId
	sb.append("\"objectId\":\"")
	sb.append(to.getObjectId())
	sb.append("\"")
	// selectorMethod
	sb.append(",")
	sb.append("\"selectorMethod\":\"")
	sb.append(to.getSelectorMethod())  // XPATH,BASIC,CSS
	sb.append("\"")
	//
	if (to.getSelectorMethod().equals("XPATH") && to.getActiveXpaths().size() > 0) {
		sb.append(",")
		sb.append("[")
		int count = 0
		for (TestObjectXpath xp : to.getActiveXpaths()) {
			if (count > 0) {
				sb.append(",")
			}
			sb.append("{")
			sb.append("\"name\":\"")
			sb.append(xp.getName())
			sb.append("\",\"")
			sb.append(xp.getValue())
			sb.append("\"")
			sb.append("}")
			count += 1
		}
		sb.append("]")
	}
	// 
	if (to.getSelectorMethod().equals("BASIC") && to.getProperties().size() > 0) {
		sb.append(",")
		sb.append("[")
		int count = 0
		for (TestObjectProperty top : to.getActiveProperties()) {
			if (count > 0) {
				sb.append(",")
			}
			sb.append("{")
			sb.append("\"name\":\"")
			sb.append(top.getName())
			sb.append("\"")
			sb.append(",")
			sb.append("\"conditionType\":\"")
			sb.append(top.getCondition().toString())
			sb.append("\"")
			sb.append(",")
			sb.append("\"value\":\"")
			sb.append(top.getValue())
			sb.append("\"")
			sb.append(",")
			sb.append("\"isActive\":\"")
			sb.append(top.isActive())
			sb.append("\"")
			sb.append("}")
			count += 1			
		}
		sb.append("]")
	}
	sb.append("}")
	return sb.toString()
}
