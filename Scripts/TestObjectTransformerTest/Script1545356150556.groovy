import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObjectProperty

TestObject source = findTestObject("Object Repository/Page_15801_testbed/button_foo")
assert source != null
println "source is ${format(source)}"

TestObject target = CustomKeywords.'my.TestObjectTransformer.toMyFavoritesXPath'(source, FailureHandling.OPTIONAL)
assert target != null

println "target is ${format(target)}"

/**
 * convert a test object into string
 * 
 * @param TestObject
 * @return
 */
String format(TestObject to) {
	StringBuilder sb = new StringBuilder()
	sb.append("{")
	// objectId
	sb.append("\"objectId\":\"")
	sb.append(to.getObjectId())
	sb.append("\"")
	// 
	if (to.getProperties().size() > 0) {
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
