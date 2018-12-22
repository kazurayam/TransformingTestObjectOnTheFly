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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://demoaut-mimic.kazurayam.com/15801_testbed.html')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_15801_testbed/div_main'), 10)

def staticId2 = CustomKeywords.'my.TestObjectTransformer.toMichalPachuckiXpath'(
		findTestObject('Page_15801_testbed/button_staticId2'),
		FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(staticId2, 3)

def everest = CustomKeywords.'my.TestObjectTransformer.toMichalPachuckiXpath'(
		findTestObject('Page_15801_testbed/button_EVEREST'),
		FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(everest, 3)

def kilimanjaro = CustomKeywords.'my.TestObjectTransformer.toMichalPachuckiXpath'(
		findTestObject('Page_15801_testbed/button_KILIMANJARO'),
		FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(kilimanjaro, 3)

WebUI.closeBrowser()


