import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)

WebUI.openBrowser('')
WebUI.navigateToUrl('http://demoaut-mimic.kazurayam.com/15801_testbed.html')
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_15801_testbed/div_main'), 10)

// this passes
TestObject staticId2 = findTestObject('Page_15801_testbed/button_staticId2')
WebUI.verifyElementPresent(staticId2, 3)

//println "staticId2=\n" + mapper.writeValueAsString(staticId2)


// but ...
TestObject staticId2aster = CustomKeywords.'my.TestObjectTransformer.toMichalPachuckiXpath'(
		findTestObject('Page_15801_testbed/button_staticId2'),
		FailureHandling.STOP_ON_FAILURE)

//println "staticId2=\n" + CustomKeywords.'my.TestObjectFormatter.format'(staticId2aster)

//println "staticId2aster=\n" + mapper.writeValueAsString(staticId2aster)

// this fails
WebUI.verifyElementPresent(staticId2, 3)




/*
TestObject everest = CustomKeywords.'my.TestObjectTransformer.toMichalPachuckiXpath'(
		findTestObject('Page_15801_testbed/button_EVEREST'),
		FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(everest, 3)

TestObject kilimanjaro = CustomKeywords.'my.TestObjectTransformer.toMichalPachuckiXpath'(
		findTestObject('Page_15801_testbed/button_KILIMANJARO'),
		FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(kilimanjaro, 3)
 */

WebUI.closeBrowser()


