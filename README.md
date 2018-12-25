Transforming Test Objects on the fly
=======

## What is this?

This is a [Katalon Studio](https://www.katalon.com/) project for demonstration purpose. You can down load its zip file from the [Releases](https://github.com/kazurayam/TransformingTestObjectOnTheFly/releases) page, unzip it, open it with your Katalon Studio and run it.

This project was developed using Katalon Studio 5.10.0.

This project was developed to propose a solution to a question raised in the Katalon Forum: [Customizing XPath generation](https://forum.katalon.com/t/customizing-xpath-generation/15801). The originator Michal.Pachucki worte:

>The website i am trying to test using Katalon Studio generates id that are partialy static and partialy dynamic:
"`//button[@id='staticId1:dynamicId:staticId2']/span`".
But there are never two elements that have the same staticId1/2 and different dynamicId.
So i would like to somehow generate xpath
"`//button[starts-with(@id, 'staticId1') and endswith('staticId2', @id)]/span`".
I know I can edit the xpath manually, but I will have hundreds of them, so I would prefer that it would be automatic.
>Is there a way of suppying my own xpath generator?

## Solution

Here I propose a Custom Keyword named `my.TestObjectTransformer`. The class has a public static method named `toMichalPachuckiXpath()`. The method takes an instance of `com.kms.katalon.core.testobject.TestObject` as an argument, and will return another `TestObject` instance as result.

The following table shows some examples of source xpath and generated xpath pairs.

| source xpath | generated xpath |
|:------------ | :--------------- |
| `//button[@id='staticId1:dynamicId:staticId2']/span` | `//button[starts-with(@id,"staticId1") and (substring(@id,string-length(@id)-string-length("staticId2")+1)="staticId2")]/span"}]}` |`
| `//button[@id='abc:96423857:EVEREST']/span"}]}` | `//button[starts-with(@id,"abc") and (substring(@id,string-length(@id)-string-length("EVEREST")+1)="EVEREST")]/span"}]}` |
| `//button[@id='abc:49238765:KILIMANJARO']/span"}]}` | `//button[starts-with(@id,"abc") and (substring(@id,string-length(@id)-string-length("KILIMANJARO")+1)="KILIMANJARO")]/span"}]}` |

The rule of xpath transformation above is not general at all. It is designed specifically to satisfy the need of Michal.Pachucki's case.

## Description



## Conclusion
