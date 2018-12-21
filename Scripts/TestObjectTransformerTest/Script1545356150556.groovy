import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature

/**
 * TestObjectTransformerTest
 */

TestObject source = findTestObject("Object Repository/Page_15801_testbed/button_foo")
assert source != null
println "source is " + CustomKeywords.'my.TestObjectFormatter.format'(source)


// transform a Test Object into another as Michal.Pachuski wanted 
// see https://forum.katalon.com/t/customizing-xpath-generation/15801
TestObject target = CustomKeywords.'my.TestObjectTransformer.toMichalPachuckiXpath'(source, FailureHandling.OPTIONAL)
assert target != null
println "target is " + CustomKeywords.'my.TestObjectFormatter.format'(target)




// stringify fully by Jackson
//ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)
//println "target is \n" + mapper.writeValueAsString(target)
