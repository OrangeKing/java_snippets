#!/usr/bin/jjs

var JavaApp = Java.type('app.App');
var testValue = JavaApp.testJSMethod('JS');
print (testValue);

var myClass = new JavaApp();
myClass.setVisible(true);

