#!/usr/bin/jjs

//run from lab core directory 
//jjs -cp ./src/ src/main.js 

var JavaApp = Java.type('app.App');
var testValue = JavaApp.testJSMethod('JS');
print (testValue);

var myClass = new JavaApp();
myClass.setVisible(true);

