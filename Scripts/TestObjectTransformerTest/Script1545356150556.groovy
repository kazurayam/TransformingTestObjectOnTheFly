import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject

/**
 * TestObjectTransformerTest
 */

TestObject source = findTestObject("Object Repository/Page_15801_testbed/button_foo")
assert source != null
println "source is " + CustomKeywords.'my.TestObjectFormatter.format'(source)

TestObject target = CustomKeywords.'my.TestObjectTransformer.toMyFavoritesXPath'(source, FailureHandling.OPTIONAL)
assert target != null
println "target is " + CustomKeywords.'my.TestObjectFormatter.format'(target)
